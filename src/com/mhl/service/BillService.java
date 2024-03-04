package com.mhl.service;

import com.mhl.dao.BillDAO;
import com.mhl.dao.MultiTableDAO;
import com.mhl.domain.Bill;
import com.mhl.domain.MultiTableBean;

import java.util.List;
import java.util.UUID;

public class BillService {
    //定义BillDAO属性
    private BillDAO billDAO = new BillDAO();
    //定义MultiTableDAO
    private MultiTableDAO multiTableDAO = new MultiTableDAO();
    //定义MenuService属性
    private MenuService menuService = new MenuService();
    //定义DiningTableService属性
    private DiningTableService diningTableService = new DiningTableService();
    //编写点餐方法
    //1.生成账单
    //2.需要更新对应餐桌的状态
    public boolean orderMenu(int menuId,int nums,int diningTableId){
        //生成一个账单号，UUID
        String billId = UUID.randomUUID().toString();

        double price = menuService.getMenuById(menuId).getPrice() * nums;
        //将账单生成到bill表
        int update = billDAO.update("insert into bill values(null,?,?,?,?,?,now(),'未结账')", billId, menuId, nums, price, diningTableId);
        if(update <= 0) return false;

        //需要更新对应餐桌的状态
        return diningTableService.updateDiningTableState(diningTableId,"就餐中");
    }

    //返回所有的账单
    public List<Bill> list(){
        return billDAO.queryMulti("select * from bill", Bill.class);
    }

    //返回所有的账单并带有菜品名 多表
    public List<MultiTableBean> mulList(){
        return multiTableDAO.queryMulti("select bill.*,name,price from bill,menu where bill.menuId = menu.id", MultiTableBean.class);
    }

    //查看某个餐桌是否有未结账的账单
    public boolean hasPayBillByDiningTableId(int diningTableId){
        Bill bill = billDAO.querySingle("select * from bill where diningTableId = ? and state = '未结账' limit 0,1", Bill.class, diningTableId);
        return bill != null;
    }

    //完成结账[如果餐桌存在，并且该餐桌有未结账的账单]
    public boolean payBill(int diningTableId,String payMode){
        //如果这里使用事务的话，需要用ThreadLocal来解决 , 框架中比如mybatis 提供了事务支持
        //1.修改bill表
        int update = billDAO.update("update bill set state = ? where diningTableId = ? and state = '未结账'", payMode, diningTableId);
        if(update <= 0) return false;

        //2.修改diningTable表 该方法需在diningTableService实现
        if(!diningTableService.updateDiningTableToFree(diningTableId,"空")) return false;
        return true;
    }
}

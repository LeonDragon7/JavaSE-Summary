package com.mhl.view;

import com.mhl.domain.*;
import com.mhl.service.BillService;
import com.mhl.service.DiningTableService;
import com.mhl.service.EmployeeService;
import com.mhl.service.MenuService;
import com.mhl.utils.Utility;

import java.util.List;

/**
 * 主界面
 */
public class MHLView {
    private boolean loop = true;
    private String key = "";
    private EmployeeService employeeService = new EmployeeService();
    private DiningTableService diningTableService = new DiningTableService();
    private MenuService menuService = new MenuService();
    private BillService billService = new BillService();

    public static void main(String[] args) {
        new MHLView().mainMenu();
    }

    //显示所有餐桌状态
    public void listDiningTable() {
        List<DiningTable> list = diningTableService.list();
        System.out.println("\n餐桌编号\t\t餐桌状态");
        for (DiningTable diningTable : list) {
            System.out.println(diningTable);
        }
        System.out.println("=============== 显示完毕！ ==============");
    }

    //完成订座
    public void orderDiningTable(){
        System.out.println("================ 预定餐桌 ================");
        while (true){
            System.out.print("请选择要预定餐桌编号(-1退出)：");
            int orderId = Utility.readInt();
            char confirm = Utility.readConfirmSelection();
            if(orderId != -1 && confirm == 'Y' || confirm == 'N'){
                if(confirm == 'Y'){
                    //根据orderId 返回 对应DiningTable对象, 如果为null, 说明该对象不存在
                    DiningTable diningTable = diningTableService.getDiningTableById(orderId);
                    if(diningTable == null){
                        System.out.println("预定餐桌不存在");
                        break;
                    }
                    //判断该餐桌的状态是否 "空"
                    if(!("空".equals(diningTable.getState()))){//说明当前这个餐桌不是"空"的状态
                        System.out.println("该餐桌已经预定或者就餐中");
                        break;
                    }
                    //预定
                    System.out.print("预订人名字：");
                    String orderName = Utility.readString(20);
                    System.out.print("预订人电话：");
                    String orderTel = Utility.readString(20);
                    if(diningTableService.orderDiningTable(orderId, orderName, orderTel)) System.out.println("预定餐桌成功");
                    else System.out.println("预定餐桌失败");
                } else {
                    System.out.println("你已经取消预定！");
                    break;
                }
            } else System.out.println("你输入有误，请重新输入！");
        }
    }

    //显示所有菜品
    public void listMenu(){
        List<Menu> list = menuService.list();
        System.out.println("\n菜品编号\t\t菜品名\t\t类别\t\t价格");
        for (Menu menu : list) {
            System.out.println(menu);
        }
        System.out.println("================ 显示完毕 ================");
    }

    //完成点餐
    public void orderMenu() {
        System.out.println("================ 点餐服务 ================");
        System.out.print("请输入点餐的桌号(-1退出): ");
        int orderDiningTableId = Utility.readInt();
        if (orderDiningTableId == -1) {
            System.out.println("==============取消点餐============");
            return;
        }
        System.out.print("请输入点餐的菜品号(-1退出): ");
        int orderMenuId = Utility.readInt();
        if (orderMenuId == -1) {
            System.out.println("==============取消点餐============");
            return;
        }
        System.out.print("请输入点餐的菜品量(-1退出): ");
        int orderNums = Utility.readInt();
        if (orderNums == -1) {
            System.out.println("==============取消点餐============");
            return;
        }

        //验证餐桌号是否存在.
        DiningTable diningTable = diningTableService.getDiningTableById(orderDiningTableId);
        if (diningTable == null) {
            System.out.println("==============餐桌号不存在============");
            return;
        }
        //验证菜品编号
        Menu menu = menuService.getMenuById(orderMenuId);
        if (menu == null) {
            System.out.println("==============菜品号不存在============");
            return;
        }

        //点餐
        if (billService.orderMenu(orderMenuId, orderNums, orderDiningTableId)) {
            System.out.println("==============点餐成功============");
        } else {
            System.out.println("==============点餐失败============");
        }
    }

    //显示账单信息
    public void listBill(){
//        List<Bill> bills = billService.list();
//        System.out.println("\n编号\t\t菜品号\t\t菜品量\t\t金额\t\t桌号\t\t日期\t\t\t\t\t\t\t状态\t\t菜品名\t\t价格");
//        for (Bill bill : bills) {
//            System.out.println(bill);
//        }
        List<MultiTableBean> multiTableBeans = billService.mulList();
        System.out.println("\n编号\t\t菜品号\t\t菜品量\t\t金额\t\t桌号\t\t日期\t\t\t\t\t\t\t状态\t\t菜品名\t\t价格");
        for (MultiTableBean multiTableBean : multiTableBeans) {
            System.out.println(multiTableBean);
        }
        System.out.println("================ 显示完毕 ================");
    }

    //完成结账
    public void payBill(){
        System.out.println("================ 完成结账 ================");
        System.out.print("请选择要结账的餐桌编号(-1退出): ");
        int diningTableId = Utility.readInt();
        if(diningTableId == -1){
            System.out.println("================ 取消结账 ================");
            return;
        }
        //验证餐桌是否存在
        DiningTable diningTable = diningTableService.getDiningTableById(diningTableId);
        if(diningTable == null) System.out.println("结账的餐桌号不存在");
        //验证餐桌是否有需要结账的账单
        if(!billService.hasPayBillByDiningTableId(diningTableId)){
            System.out.println("该餐位没有未结账的账单");
            return;
        }
        System.out.print("结账方式(现金/支付宝/微信)回车表示退出: ");
        String payMode = Utility.readString(20, "");//"":为了可以下面进行校验
        if("".equals(payMode)){
            System.out.println("================ 取消结账 ================");
            return;
        }
        char confirm = Utility.readConfirmSelection();
        if(confirm == 'Y'){
            if(billService.payBill(diningTableId,payMode)) System.out.println("================ 完成结账 ================");
            else System.out.println("================ 结账失败 ================");
        } else System.out.println("================ 取消结账 ================");
    }
    public void mainMenu(){
        while (loop) {
            System.out.println("================= 满汉楼 =================");
            System.out.println("\t\t 1.登录满汉楼");
            System.out.println("\t\t 2.退出满汉楼");
            System.out.print("请输入你的选择：");
            key = Utility.readString(1);
            switch (key){
                case "1":
                    System.out.print("请输入员工号：");
                    String empId = Utility.readString(50);
                    System.out.print("请输入密  码：");
                    String pwd = Utility.readString(50);
                    //登录校验
                    Employee employee = employeeService.getEmployeeByIdPwd(empId, pwd);
                    if(employeeService.getEmployeeByIdPwd(empId,pwd) != null){
                        System.out.println("================= 用户："+ employee.getName() +",登录成功 =================\n");
                        //显示二级菜单
                        while (loop){
                            System.out.println("\n=============== 满汉楼二级菜单 ==============");
                            System.out.println("\t\t 1.显示餐桌状态");
                            System.out.println("\t\t 2.预定餐桌");
                            System.out.println("\t\t 3.显示所有菜品");
                            System.out.println("\t\t 4.点餐服务");
                            System.out.println("\t\t 5.查看账单");
                            System.out.println("\t\t 6.结账");
                            System.out.println("\t\t 9.退出满汉楼");
                            System.out.print("请输入你的选择：");
                            key = Utility.readString(1);
                            switch (key){
                                case "1":
                                    listDiningTable();
                                    break;
                                case "2":
                                    orderDiningTable();
                                    break;
                                case "3":
                                    listMenu();
                                    break;
                                case "4":
                                    orderMenu();
                                    break;
                                case "5":
                                    listBill();
                                    break;
                                case "6":
                                    payBill();
                                    break;
                                case "9":
                                    loop = false;
                                    break;
                                default:
                                    System.out.println("你输入的有误，请重新输入！");
                            }
                        }
                    } else System.out.println("================= 登录失败 =================");
                    break;
                case "2":
                    loop = false;
                    break;
                default:
                    System.out.println("你输入的有误，请重新输入！");
            }
        }
        System.out.println("退出满汉楼系统");
    }
}

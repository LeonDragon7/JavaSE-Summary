package com.mhl.service;

import com.mhl.dao.MenuDAO;
import com.mhl.domain.Menu;

import java.util.List;

/**
 * 完成对menu表的各种操作（通过调用MenuDAO）
 */
public class MenuService {
    //定义MenuDAO属性
    private MenuDAO menuDAO = new MenuDAO();

    //返回所有的菜品，返回给界面使用
    public List<Menu> list(){
        return menuDAO.queryMulti("select * from menu",Menu.class);
    }

    //需要方法，根据id，返回menu对象
    public Menu getMenuById(int id){
        return menuDAO.querySingle("select * from menu where id = ?", Menu.class,id);
    }
}

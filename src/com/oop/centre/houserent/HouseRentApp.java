package com.oop.centre.houserent;

import com.oop.centre.houserent.view.HouseView;

/*
    房屋出租系统-需求
    实现基于文本界面的《房屋出租软件》。 能够实现对房屋信息的添加、修改和删除（用数组实现），并能够打印房屋明细表
 */
public class HouseRentApp {
    public static void main(String[] args) {
        new HouseView().mainMenu();
    }
}

package com.oop.centre.petshop.controller;

import com.oop.centre.petshop.domain.Dog;
import com.oop.centre.petshop.domain.PetShop;
import com.oop.centre.petshop.service.PetShopService;
import com.oop.centre.petshop.utils.Utility;

public class PetShopController {
    private boolean loop = true;
    private char key = ' ';
    private PetShopService service = new PetShopService();
    //添加宠物
    public void add(){
        System.out.println("买入宠物记录");
        System.out.println("商店名称：");
        String shopName = Utility.readString(50);
        System.out.println("宠物名称：");
        String petName = Utility.readString(50);
        System.out.println("宠物年龄：");
        int age = Utility.readInt();
        System.out.println("买入宠物价格：");
        double price = Utility.readDouble();
        PetShop petShop = new PetShop(shopName, new Dog(petName, age));
        service.BuyPet(petShop,price);
    }
    //销售宠物
    public void reduce(){
        System.out.println("销售宠物记录");
        System.out.println("请输入销售宠物信息");
        System.out.println("宠物名称：");
        String petName = Utility.readString(50);
        System.out.println("宠物年龄：");
        int age = Utility.readInt();
        System.out.println("销售宠物价格：");
        double price = Utility.readDouble();
        Dog dog = new Dog(petName, age);
        service.SellPet(dog,price);
    }
    //显示宠物清单
    public void show(){
        service.ShowPet();
    }
    //查询所有已销售的宠物清单和统计
    public void sellShow(){
        service.Statics();
    }
    //退出系统
    public void exit(){
        char choice = Utility.readConfirmSelection();
        if(choice == 'Y'){
            loop = false;
        }
    }
    public void menu(){
        do {
            System.out.println("===========宠物商店管理系统=========");
            System.out.println("1、买入宠物");
            System.out.println("2、销售宠物");
            System.out.println("3、显示宠物列表");
            System.out.println("4、显示销售和盈利");
            System.out.println("5、退出系统");
            key = Utility.readChar();
            switch (key){
                case '1':
                    add();
                    break;
                case '2':
                    reduce();
                    break;
                case '3':
                    show();
                    break;
                case '4':
                    sellShow();
                    break;
                case '5':
                    exit();
                    break;
                default:
                    System.out.println("你输入的选项有误！");
            }
        }while (loop);
    }
}

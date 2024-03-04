package com.oop.centre.smallchange.oop;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SmallChangeSysOOP {
    boolean loop = true;
    Scanner scanner = new Scanner(System.in);
    String key = "";

    String details = "--------------零钱通明细--------------";

    double money = 0;
    double balance = 0;
    Date date = null;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");//可以用于日期格式化

    String note = "";//消费的名称

    //1、先完成显示菜单，并可以选择菜单，给出对应提示
    public void mainMenu(){
        do{
            //1、先完成显示菜单，并可以选择菜单，给出对应提示
            System.out.println("\n==============零钱通菜单(OOP)==============");
            System.out.println("\t\t\t1 零钱通明细");
            System.out.println("\t\t\t2 收益入账");
            System.out.println("\t\t\t3 消费");
            System.out.println("\t\t\t4 退     出");

            System.out.println("请选择(1-4):");
            key = scanner.next();

            switch (key){
                case "1":
                    this.detail();
                    break;
                case "2":
                    this.income();
                    break;
                case "3":
                    this.pay();
                    break;
                case "4":
                    this.exit();
                    break;
                default:
                    System.out.println("选择有误，请重新选择");
                    break;
            }
        }while (loop);
    }

    //2、完成零钱通明细
    public void detail(){
        System.out.println(details);
    }

    //3、完成收益入账
    public void income(){
        System.out.println("收益入账金额:");
        money = scanner.nextDouble();
        //对money的值范围校验
        //找出不正确的金额条件，然后给出提示，就直接return
        if(money <= 0){
            System.out.println("收益入账金额需要大于0");
            return;//退出方法，不在执行后面的代码
        }
        balance += money;
        //拼接收益入账信息到details
        date = new Date();//获取当前日期
        details += "\n收益入账\t+" + money + "\t" + sdf.format(date) + "\t" + balance;
    }

    //4、完成消费
    public void pay(){
        System.out.println("消费金额:");
        money = scanner.nextDouble();
        //对money的值范围校验
        //找出不正确的金额条件，然后给出提示，就直接return
        if(money <= 0 || money > balance){
            System.out.println("消费金额需要在0-" + balance);
            return;
        }
        System.out.println("消费说明:");
        note = scanner.next();

        balance -= money;
        //拼接消费信息到details
        date = new Date();//获取当前日期
        details += "\n" + note + "\t-" + money + "\t" + sdf.format(date) + "\t" + balance;
    }

    //5.退出
    public void exit(){
         /*
            1、用户输入4退出时，给出提示"你确定要退出吗？y/n",必须输入正确的y/n,否则
            循环输入指令，直到输入y或者n。

            1、定义一个变量 choice，接收用户输入
            2、使用while + break，来处理接收到的输入是否为 y 或者 n
            3、退出while后，在判断choice是y还是n，就可以决定是否退出
         */
        String choice = "";//接收用户输入
        while (true){
            System.out.println("你确定要退出吗？y/n");
            choice = scanner.next();
            if("y".equals(choice) || "n".equals(choice)){
                break;
            }
        }
        if("y".equals(choice)){
            loop = false;
        }
    }
}

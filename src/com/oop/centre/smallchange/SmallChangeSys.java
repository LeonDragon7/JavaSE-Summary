package com.oop.centre.smallchange;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/*
    项目-零钱通
    项目开发流程说明
    项目需求说明
    使用Java开发零钱通项目，可以完成收益入账、消费、查看明细和退出系统等功能。

    项目界面：
    化繁为简
    1、先完成显示菜单，并可以选择菜单，给出对应提示
    2、完成零钱通明细
        1）可以吧收益入账和消费，保存到数组
        2）可以使用对象
        3）可以使用String拼接
    3、完成收益入账
    4、完成消费
    5、退出

    项目代码实现改进：
    1、用户输入4退出时，给出提示"你确定要退出吗？y/n",必须输入正确的y/n,否则
    循环输入指令，直到输入y或者n。
    2、在收益入账和消费时，判断金额是否合理，并给出相应的提示。
    3、将面向过程的代码修改成面向对象的方法，编写SmallChangeSysOOP类[完成各个功能]，
    并使用SmallChangeSysApp类[创建SmallChangeSysOOP对象，调用相关方法，完成功能]完成测试
 */
public class SmallChangeSys {
    public static void main(String[] args) {

        //定义相关的变量
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        String key = "";

        //2、完成零钱通明细 可以使用String拼接
        String details = "-------------零钱通明细-------------";

        //3、完成收益入账
        double money = 0;
        double balance = 0;
        Date date = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");//可以用于日期格式化

        //4、完成消费
        String note = "";//消费的名称
        do{
            //1、先完成显示菜单，并可以选择菜单，给出对应提示
            System.out.println("\n=============零钱通菜单=============");
            System.out.println("\t\t\t1 零钱通明细");
            System.out.println("\t\t\t2 收益入账");
            System.out.println("\t\t\t3 消费");
            System.out.println("\t\t\t4 退     出");

            System.out.println("请选择(1-4):");
            key = scanner.next();

            switch (key){
                case "1":
                    System.out.println(details);
                    break;
                case "2":
                    System.out.println("收益入账金额:");
                    money = scanner.nextDouble();
                    //对money的值范围校验
                    //找出不正确的金额条件，然后给出提示，就直接break
                    if(money <= 0){
                        System.out.println("收益入账金额需要大于0");
                        break;
                    }
                    balance += money;
                    //拼接收益入账信息到details
                    date = new Date();//获取当前日期
                    details += "\n收益入账\t+" + money + "\t" + sdf.format(date) + "\t" + balance;
                    break;
                case "3":
                    System.out.println("消费金额:");
                    money = scanner.nextDouble();
                    //对money的值范围校验
                    //找出不正确的金额条件，然后给出提示，就直接break
                    if(money <= 0 || money > balance){
                        System.out.println("消费金额需要在0-" + balance);
                        break;
                    }
                    System.out.println("消费说明:");
                    note = scanner.next();

                    balance -= money;
                    //拼接消费信息到details
                    date = new Date();//获取当前日期
                    details += "\n" + note + "\t-" + money + "\t" + sdf.format(date) + "\t" + balance;
                    break;
                case "4":
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
                    break;
                default:
                    System.out.println("选择有误，请重新选择");
                    break;
            }
        }while (loop);

        System.out.println("----------退出了零钱通项目----------");
    }
}

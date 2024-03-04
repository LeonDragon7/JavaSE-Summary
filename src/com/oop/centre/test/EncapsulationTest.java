package com.oop.centre.test;

public class EncapsulationTest {
    public static void main(String[] args) {
        /*
        创建程序，在其中定义两个类：Account和AccountTest类体会Java的封装性。
        1、Account类要求具有属性：姓名（长度为2位3为或4位）、余额(必须>20)、
        密码（必须是6位），如果不满足，则给出提示信息，并给默认值
        2、通过setXxx的方法给Account的属性赋值
        3、在AccountTest中测试

        提示知识点：
        String name = "";
        int len = name.length();
         */
    }
}
class Account{
    private String name;
    private double balance;
    private String password;

    //无参构造器
    public Account() {
    }
    //三个属性参数构造器
    public Account(String name, double balance, String password) {
        setName(name);
        setBalance(balance);
        setPassword(password);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name.length() >= 2 && name.length() <= 4){
            this.name = name;
        }else {
            System.out.println("姓名（长度为2位3为或4位），提供默认值");
            this.name = "";
        }
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        if(balance > 20){
            this.balance = balance;
        }else{
            System.out.println("余额(必须>20)，提供默认值");
            this.balance = 18.5;
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if(password.length() == 6){
            this.password = password;
        }else{
            System.out.println("密码（必须是6位），默认密码：123456");
            this.password = "123456";
        }
    }

    public String info(){
        return "信息为 name = " + name + " balance = " + balance + " password = " + password;
    }
}
class AccountTest{
    public static void main(String[] args) {
        Account account1 = new Account();
        account1.setName("jack");
        account1.setBalance(60);
        account1.setPassword("123456");

        Account account = new Account("张三",21,"123456");
        System.out.println(account.info());
    }
}

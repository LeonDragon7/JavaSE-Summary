package com.oop.centre.test;

public class OOPTest08 {
    public static void main(String[] args) {
        CheckingAccount checkingAccount = new CheckingAccount(1000);
        checkingAccount.deposit(10);
        checkingAccount.withdraw(10);
        System.out.println(checkingAccount.getBalance());

        SavingsAccount account = new SavingsAccount(10000);
        account.deposit(100);
        account.deposit(100);
        account.deposit(100);
        System.out.println(account.getBalance());
        account.deposit(100);
        System.out.println(account.getBalance());

        //月初，定时器自动调用一下earnMonthlyInterest
        account.earnMonthlyInterest();//统计利息
        System.out.println(account.getBalance());
        account.withdraw(100);//免手续费(earnMonthlyInterest -> count = 3)
        System.out.println(account.getBalance());
        account.withdraw(100);//免手续费
        account.withdraw(100);//免手续费
        System.out.println(account.getBalance());
        account.deposit(100);//扣手续费
    }
}
/*
    8.扩展如下的BankAccount
    要求：
    （1）在下面类的基础上扩展 新类CheckingAccount
    对每次存款和取款都收取1美元的手续费
    （2）扩展前一个练习的BankAccount类，新类
    SavingsAccount每个月都有利息产生
    (earnMonthlyInterest方法被调用)，并且有每月三次
    免手续费的存款或取款。在earnMonthlyInterest方法
    中重置交易计数
 */
class BankAccount{
    private double balance;
    public BankAccount(double initialBalance){
        this.balance = initialBalance;
    }
    public void deposit(double amount){
        balance += amount;
    }
    public void withdraw(double amount){
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
class CheckingAccount extends BankAccount{
    private double balance;
    public CheckingAccount(double initialBalance){
        super(initialBalance);
    }

    @Override
    public void deposit(double amount) {
        super.deposit(amount - 1);
    }

    @Override
    public void withdraw(double amount) {
        super.withdraw(amount + 1);
    }
}
class SavingsAccount extends BankAccount{
    private int count = 3;
    private double rate = 0.01;//利率
    public SavingsAccount(double initialBalance){
        super(initialBalance);
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    @Override
    public void deposit(double amount) {
        //判断是否还可以免手续费
        if(count > 0){
            super.deposit(amount);
        }else {
            super.deposit(amount - 1);
        }
        count--;
    }

    @Override
    public void withdraw(double amount) {
        //判断是否还可以免手续费
        if(count > 0){
            super.withdraw(amount);
        }else {
            super.withdraw(amount - 1);
        }
        count--;
    }

    public void earnMonthlyInterest(){
        count = 3;
        super.deposit(getBalance() * rate);
    }
}
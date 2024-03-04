package com.oop.up.test;

public class ObjectOriTest03 {
    public static void main(String[] args) {
        /*
        3.编写类Book,定义方法updatePrice，实现更改某本书的价格，具体：如果价格
        >150,则更改为150，如果价格>100，更改为100，否则不变
         */
        Book book = new Book("笑傲江湖",300);
        book.info();
        book.updatePrice();
        book.info();
    }
}
class Book{
    String name;
    double price;
    public Book(String name,double price){
        this.name = name;
        this.price = price;
    }
    public void updatePrice(){
        //如果方法中，没有price局部变量，this.price 等价 price
        if(this.price > 150){
            this.price = 150;
        } else if (this.price > 100) {
            this.price = 100;
        }//如果都不满足，则不变，不需要添加else条件了
    }

    //显示书籍情况
    public void info(){
        System.out.println("书名 = " + this.name + "，价格 = " + this.price);
    }
}
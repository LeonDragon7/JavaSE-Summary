package com.oop.advanced.Test;

public class OOPTest01 {
    public static void main(String[] args) {
        Car c = new Car();
        Car c1 = new Car(100);
        //类的加载static只会执行一次
        System.out.println(c);//9 red
        System.out.println(c1);//100 red
    }
}
class Car{
    double price = 10;
    static String color = "white";

    @Override
    public String toString() {
        return price + "\t" + color;
    }

    public Car() {
        this.price = 9;
        this.color = "red";
    }

    public Car(double price) {
        this.price = price;
    }
}

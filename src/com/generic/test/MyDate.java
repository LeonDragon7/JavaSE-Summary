package com.generic.test;
/*
    定义Employee类
    1、该类包含: private成员变量name, sal, birthday，其中 birthday 为 MyDate 类的对象;
    2、为每一个属性定义getter, setter方法;
    3、重写toString方法输出name, sal, birthday
    4、MyDate类包含:private成员变量month, day, year; 并为每一个属性定义 getter,setter方法;
    5、创建该类的3个对象，并把这些对象放入ArrayList集合中(ArrayList需使用泛型来定义),对集合中的元素进行排序，并遍历输出:
    6、排序方式:调用ArrayList的sort方法，传入 Comparator对象[使用泛型]，先按照name排序，如果name相同，则按生日日期的先后排序。【即:定制排序】
 */
public class MyDate implements Comparable<MyDate>{
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }

    @Override
    public int compareTo(MyDate o) { //把对year-month-day比较放在这里

        int yearMinus = year - o.getYear();
        if(yearMinus != 0) {
            return  yearMinus;
        }
        //如果year相同，就比较month
        int monthMinus = month - o.getMonth();
        if(monthMinus != 0) {
            return monthMinus;
        }
        //如果year 和 month
        return day - o.getDay();
    }
}

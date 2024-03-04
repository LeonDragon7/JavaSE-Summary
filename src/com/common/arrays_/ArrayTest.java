package com.common.arrays_;


import java.util.Arrays;
import java.util.Comparator;

public class ArrayTest {
    public static void main(String[] args) {
        /*
           自定义Book类，里面包含name和price，按price排序(从大到小)。要求使用
           两种方式排序，对对象的某个属性排序，有一个 Book[] books = 4本书对象。
           按照 (1) price从大到小 (2) price从小到大 (3) 书名长度从大到小
         */
        Book[] books = new Book[4];
        books[0] = new Book("红楼梦",120);
        books[1] = new Book("金瓶梅新",150);
        books[2] = new Book("青年文摘20年",109);
        books[3] = new Book("java从入门到放弃",90);

        //(1) price从大到小
        Arrays.sort(books, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Book b1 = (Book) o1;
                Book b2 = (Book) o2;
                double priceVal = b2.getPrice() - b1.getPrice();
                //(2) price从小到大 调换 -1和1的位置
                if(priceVal > 0){
                    return 1;
                } else if (priceVal < 0) {
                    return -1;
                }
                return 0;
            }
        });
        System.out.println(Arrays.toString(books));

        //(3) 书名长度从大到小
        Arrays.sort(books, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Book b1 = (Book) o1;
                Book b2 = (Book) o2;
                return b2.getName().length() - b1.getName().length();
            }
        });
        System.out.println(Arrays.toString(books));
    }
}
class Book{
    private String name;
    private double price;

    public Book(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}

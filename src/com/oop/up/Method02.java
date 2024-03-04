package com.oop.up;

public class Method02 {
    public static void main(String[] args) {
        //请遍历一个数组，输出数组的各个元素值。
        //传统的方法
        int[][] map = {{0,0,1},{1,1,1},{1,1,3}};
        for(int i = 0;i < map.length;i++){
            for(int j = 0;j < map[i].length;j++){
                System.out.print(map[i][j] + "\t");
            }
            System.out.println();
        }
        /*
        当写了十几万行代码的时候要求再次遍历，只能粘贴拷贝，
        重复代码，代码冗余度太高，不好更改代码。
        解决思路：定义成员方法
         */

        System.out.println("------------------");
        //成员方法
        Array arr = new Array();
        arr.array(map);
        /*
        成员方法的好处
        1、提高代码的复用性-反复使用
        2、可以将实现的细节封装起来，然后供其他用户来调用即可。
         */
    }
}
class Array{
    public void array(int[][] map){
        //对传入的map数组进行遍历输出
        for(int i = 0;i < map.length;i++){
            for(int j = 0;j < map[i].length;j++){
                System.out.print(map[i][j] + "\t");
            }
            System.out.println();
        }
    }
}

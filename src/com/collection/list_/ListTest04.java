package com.collection.list_;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ListTest04 {
    public static void main(String[] args) {
        /*
            用户从键盘输入一个整数，程序将判断这个数是几位数并输出其位数，并判断这个数是否是回文数，是则输出Y，
            否则输出N。回文数是指将该数含有的数字逆序排列后得到的数和原数相同，例如12121、3223都是回文数。
         */
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        List<Integer> newList1 = new ArrayList<>();
        List<Integer> newList2 = new ArrayList<>();
        int a = scanner.nextInt();
        list.add(a);
        for (Integer  i : list) {
            while (i > 0){
                newList1.add(i % 10);
                i /= 10;
            }
        }
        for (Integer  i : list) {
            while (i > 0){
                newList2.add(i % 10);
                i /= 10;
            }
        }
        Collections.reverse(newList2);

        System.out.println(newList1.size());
        if(newList1.equals(newList2)){
            System.out.println("Y");
        }else {
            System.out.println("N");
        }
        /*
       int a = scanner.nextInt();
       int anx = 0;
       int index = 0;
       int temp = a;
       while(temp > 0){
        int r = temp % 10;
        anx = ans * 10 + r;
        temp /= 10;
        index++;
       }
       System.out.println(index);
       if.(ans.==.n).System.out.println("y");
        else.System.out.println("N");
         */
    }
}

package com.collection.list_;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListTest03 {
    public static void main(String[] args) {
        //输入一个3位正整数，然后逆序输出这个3位数。
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        List<Integer> newList = new ArrayList<>();
        int a = scanner.nextInt();
        list.add(a);
        for (Integer  i : list) {
            while (i > 0){
                newList.add(i % 10);
                i /= 10;
            }
        }
        for (Integer i : newList) {
            System.out.print(i + " ");
        }
        /*
        或者
        int res = (n % 10) * 100 + ((n / 10) % 10) * 10 + ((n / 10) / 10) % 10;
         */
    }
}

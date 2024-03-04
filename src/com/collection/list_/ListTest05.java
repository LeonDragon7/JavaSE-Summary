package com.collection.list_;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ListTest05 {
    public static void main(String[] args) {
    /*
    从键盘输入N个整数，并输出指定的某个整数在这N个整数中的按照由小到大的顺序排列的位次
    （最小的位次是1，最大的位次是N，指定的整数如果不在这N个数中，则其位次是-1）
     */
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        ArrayList<Integer> list = new ArrayList();
        for(int i = 0;i < a;i++){
            int b = scanner.nextInt();
            list.add(b);
        }
        Collections.sort(list);

        int b = scanner.nextInt();
        for (Integer i : list) {
            if(b == i){
                System.out.println(list.indexOf(i) + 1);
                break;
            }
        }
        if(!list.contains(b)){
            System.out.println(-1);
        }
        /*
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < a.length; i++) a[i] = scanner.nextInt();
        int k = scanner.nextInt();

        Arrays.sort(a);

        int l = 0;
        int r = a.length - 1;

        while(l < r){
            int mid = (l + r) >> 1;
            if(a[mid] >= k) r = mid;
            else l = mid + 1;
        }
        if(a[l] != k) System.out.println(-1);
        else System.out.println(l + 1);

         */

    }
}

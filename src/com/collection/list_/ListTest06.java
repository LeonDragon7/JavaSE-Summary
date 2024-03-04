package com.collection.list_;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListTest06 {
    public static void main(String[] args) {
         /*
        一个数如果恰好等于它的因子之和，这个数就称为"完数"。 例如，6的因子为1、2、3，而6=1+2+3，因此6是"完数"。 编程序找出30之内的所有完数。
         */
        Scanner scanner = new Scanner(System.in);
        int n = 30;
        List<Integer> perfectNumbers = new ArrayList<>();

        // 寻找所有完美数
        for (int i = 1; i <= n; i++) {
            int temp = 0;
            for (int j = 1; j <= i / 2; j++) {
                if (i % j == 0) {
                    temp += j;
                }
            }
            if (temp == i) {
                perfectNumbers.add(i);
            }
        }

        // 输出完美数，确保最后一个后没有逗号
        for (int i = 0; i < perfectNumbers.size(); i++) {
            System.out.print(perfectNumbers.get(i));
            if (i < perfectNumbers.size() - 1) {
                System.out.print(",");
            }
        }
    }
}

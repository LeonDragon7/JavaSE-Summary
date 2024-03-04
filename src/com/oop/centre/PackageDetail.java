package com.oop.centre;

import java.util.Arrays;

/*
        包
        注意事项和使用细节
        1、package的作用是声明当前类所在的包，需要放在类的最上面，一个类中最多
        只有一句package
        2、import指令位置放在package的下面，在类定义前面，可以有很多且没有顺序
        要求
        建议，需要用到哪个类，就导入哪个类即可，不建议使用'*'导入
 */

public class PackageDetail {
    public static void main(String[] args) {
        //使用系统提供Arrays完成数组排序
        System.out.println(Math.PI);
        int[] arr = {1, -1, 100, 90, 78};
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
    }
}

package com.array;

import java.util.Scanner;

/*
	数组的使用
	使用方式1-动态初始化
		数组的定义
		数据类型[] 数组名 = new 数据类型[大小];//数据类型[] 数组名 = new 数据类型[大小];
		int[] a = new int[5];//创建了一个数组，名字a存放5个int
		说明：这是定义数组的一种方法。
		区分：a的数据类型是int[],a[i]的数据类型是int

	数组的引用(使用/访问/获取数组元素)
	数组名[下标/索引/index] 比如：你要使用a数组的第三个数 a[2],数组的下标从0开始
*/
public class ArrayUsage01{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //循环输入5个成绩，保存到double数组，并输出
        //声明数组开辟空间
        double[] scores = new double[5];
        //循环输入
        for(int i = 0;i < scores.length;i++){
            System.out.println("请输入第" + (i + 1) + "个元素的值");
            scores[i] = scanner.nextDouble();
        }
        //循环输出
        for (int i = 0; i < scores.length; i++) {
            System.out.println("第" + (i + 1) + "个元素的值：" + scores[i]);
        }
    }
}

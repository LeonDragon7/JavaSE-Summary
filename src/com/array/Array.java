package com.array;
/*
	数组介绍
	数组可以存放多个同一类型的数据。数组也是一种数据类型，是引用类型。即：数组就是一组数据。
*/
public class Array {
    public static void main(String[] args) {
        /*
		一个养鸡场有6只鸡，它们的体重分别是3kg，5kg，1kg，
		3.4kg，2kg，50kg。请问这六只鸡的总体重是多少？平
		均体重是多少？
		*/
        double totalWeight = 0;
        double avgWeight = 0;
        double[] hens = {3,5,1,3.4,2,50};//double类型的数组
        //遍历数组得到数组的所有元素的和，使用for
        for(int i = 0;i < hens.length;i++){
            totalWeight += hens[i];
        }
        avgWeight = totalWeight / 6;
        System.out.println("总体重 = " + totalWeight + "平均体重 = " + avgWeight);
		/*
		1. double[] 表示是double类型的数组、数组名xxx
		2. {3,5,1,3.4,2,50}表示数组的值/元素,依次表示数组的第几个元素
		3. 我们可以通过hens[下标]来访问数组的元素
		4. 下标是从0开始编号的，比如：第一个元素：hens[0],以此类推
		5. 通过for循环就可以循环的访问数组的元素/值
		6. 使用一个变量 totalWeight 将各个元素累加
		7. 可以通过 数组名.length 得到数组的大小/长度
		*/
    }
}

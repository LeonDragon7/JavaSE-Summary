package com.grammar.flow.test;

import java.util.Scanner;
public class MultipleLoopTest03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
		/*
		正直角三角形
		System.out.println("请输入层数:");
		int totalLevel = scanner.nextInt();
		for(int i = 1;i <= totalLevel;i++){//i 表示层数
			//控制打印每层*的个数
			for(int j = 1;j <= i;j++){//层数对应'*'的数量,所有j <= i;
				System.out.print("*");
			}
			System.out.println();//换行
		}
		*/
		/*
		倒直角三角形
		System.out.println("请输入层数:");
		int totalLevel = scanner.nextInt();
		for(int i = 1;i <= totalLevel;i++){
			for(int j = 1;j <= totalLevel - i;j++){
				System.out.print("*");
			}
			System.out.println();
		}
		*/
		/*正三角形
		System.out.println("请输入层数:");
		int totalLevel = scanner.nextInt();
		for(int i = 1;i <= totalLevel;i++){
			for(int j = 1;j <= totalLevel - i;j++){//(总层数 - i)为空格数
				System.out.print(" ");
			}
			for(int k = 1;k <= i * 2 - 1;k++){//层数i == 2 * 层数i - 1
				System.out.print("*");
			}
			System.out.println();
		}
		*/
		/*
			经典的打印金字塔
			使用for循环和while循环分别完成下面的案例
			请编写一个程序，可以接收一个整数，表示层数(totalLevel),打印出空心金字塔和空心的菱形。
		*/
		/*
			思路分析
			化繁为简
				1、先打印一个矩形
				*****
				*****
				*****
				*****
				*****
				2、打印半个金字塔(正直角三角形)[层数 == *数]
				*     	1个 '*'
				**		2个 '*'
				***		3个 '*'
				****	4个 '*'
				*****	5个 '*'
				3、打印整个金字塔(正三角形)[层数 == 2 * 层数 - 1]
					*		1个 '*'		4(总层数 - 1)个空格
				   ***		3个 '*'		3(总层数 - 2)个空格
				  *****		5个 '*'		2(总层数 - 3)个空格
				 *******	7个 '*'		1(总层数 - 4)个空格
				*********	9个 '*'		0(总层数 - 5)个空格
				4、打印空心的金字塔
					*		1个 '*'		当前行的第一个位置是*，最后一个位置也是* 1
				   * *		2个 '*'		当前行的第一个位置是*，最后一个位置也是* 1 3
				  *   *		2个 '*'		当前行的第一个位置是*，最后一个位置也是* 1 5
				 *     *	2个 '*'		当前行的第一个位置是*，最后一个位置也是* 1 7
				*********	9个 '*'		全部输出*
				5、打印空心的菱形
					*		1个 '*'		当前行的第一个位置是*，最后一个位置也是* 1
				   * *		2个 '*'		当前行的第一个位置是*，最后一个位置也是* 1 3
				  *   *		2个 '*'		当前行的第一个位置是*，最后一个位置也是* 1 5
				 *     *	2个 '*'		当前行的第一个位置是*，最后一个位置也是* 1 7
				*       *	2个 '*'		当前行的第一个位置是*，最后一个位置也是* 1 9
				 *	   *	2个 '*'		当前行的第一个位置是*，最后一个位置也是* 1 7  1个空格
				  *	  *		2个 '*'		当前行的第一个位置是*，最后一个位置也是* 1 5  2个空格
				   * *		2个 '*'		当前行的第一个位置是*，最后一个位置也是* 1 3  3个空格
				    *	 	2个 '*'		当前行的第一个位置是*，最后一个位置也是* 1 	   4个空格
				6、先死后活
					层数做成输入变量 int totalLevel = scanner.nextInt();
		*/
		/*空心金字塔
		System.out.println("请输入层数:");
		int totalLevel = scanner.nextInt();
		for(int i = 1;i <= totalLevel;i++){ // i表示层数
			//在输出*之前，还要输出对应的空格
			for(int j = 1;j <= totalLevel - i;j++){
				System.out.print(" ");
			}
			//控制打印每层*的个数
			for(int k = 1;k <= 2 * i - 1;k++){
				//当前行的第一个位置是*，最后一个位置也是*,最后一层全部输出
				if(k == 1 || k == 2 * i - 1 || i == totalLevel){
				   System.out.print("*");
				}else{
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		*/
        //空心的菱形
        System.out.println("请输入层数:");
        int totalLevel = scanner.nextInt();
        for(int i = 1;i <= totalLevel;i++){
            for(int j = 1;j <= totalLevel - i;j++){
                System.out.print(" ");
            }
            for(int k = 1;k <= 2 * i - 1;k++){
                if(k == 1 || k == 2 * i - 1){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        for(int i = totalLevel - 1;i >= 1;i--){
            for(int j = 1;j <= totalLevel - i;j++){
                System.out.print(" ");
            }
            for(int k = 1;k <= 2 * i - 1;k++){
                if(k == 1 || k == 2 * i - 1){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}

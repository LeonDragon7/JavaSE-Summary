package com.grammar.flow.test;
/*
			编程思想：
				1・化繁为简：即将复杂的需求，拆解成简单的需求，逐步完成
				2.先死后活：先考虑固定的值，然后转成可以灵活变化的值
		*/
public class ForLoopTest01 {
    public static void main(String[] args) {
//1.打印1-100之间所有是9的倍数的整数，统计个数及总和
		/*
			思路分析：
				化繁为简：
					① 完成输出1-100的值
					② 在输出过程中，进行过滤，只输出9的倍数 i % 9 == 0
					③ 统计个数：定义一个变量，int count = 0;当条件满足时，count++;
					④ 总和：定义一个变量 ,int sum = 0;当条件满足时累积，sum += i;
				先死后活：
					① 为了适应更好的需求，把范围的开始的值和结束的值，做出变量
					② 还可以更进一步 9 的倍数也做成变量 int multiple = 9;

		*/
        int i = 0;
        int count = 0;
        int sum = 0;
        int start = 1;
        int end = 100;
        int multiple = 9;
        for(i = start;i <= end;i++){
            if(i % multiple == 0){
                count++;
                sum += i;
            }
        }
        System.out.println("1-100之间所有是9的倍数的整数的个数为：" + count + ",总和为：" + sum);

		/*
			2.完成下列的表达式输出
			0 + 5 = 5
			1 + 4 = 5
			2 + 3 = 5
			3 + 2 = 5
			4 + 1 = 5
			5 + 0 = 5
		*/
        //方法1：
        for(int a = 0;a <= 5;a++){
            for(int b = 5;b >=0;b--){
                if(a + b == 5){
                    System.out.println(a + "+" + b + "=" + (a + b));
                }
            }
        }
        //方法2：
		/*
			化繁为简：
				① 先输出 0 - 5
				② 后面的+是 5-i
			先死后活：
				① 5 替换成变量
		*/
        int n = 5;
        for(i = 0;i <= 5;i++){
            System.out.println(i + "+" + (n-i) + "=" + n);
        }
    }
}

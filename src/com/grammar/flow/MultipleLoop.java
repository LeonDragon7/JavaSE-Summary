package com.grammar.flow;
/*
	多重循环控制
		1、讲一个循环放在另一个循环体内，就形成了嵌套循环。其中，for，while，do...while均可
		以作为外层循环和内层循环。【建议一般使用两层，最多不要超过三层，否则，代码的可读性差】
		2、实质上，嵌套循环就是把内层循环当成外层循环的循环体。当只有内层循环的循环条件为false
		时，才会完全跳出内层循环，才可结束外层的当次循环，开始下一次的循环。
		3、设外层循环次数为m次，内层为n次，则内层循环体实际上需要执行m*n次。
*/
public class MultipleLoop {
    public static void main(String[] args) {
        for(int i = 0;i < 2;i++){
            for(int j = 0;j < 3;j++){
                System.out.println("i = " + i + "j = " + j);
            }
        }
    }
}

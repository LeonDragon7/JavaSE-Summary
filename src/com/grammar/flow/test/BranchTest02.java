package com.grammar.flow.test;

public class BranchTest02 {
    public static void main(String[] args) {
        //1、对下列代码，若有输出，指出输出结果。
        int x = 4;
        int y = 1;
        if(x > 2){
            if(y > 2)
                System.out.println(x + y);
            System.out.println("atguigu");//输出结果atguigu
        }else
            System.out.println("x is" + x);
        //2
        boolean b = true;
        //如果写成if(b = false)能编译通过吗？如果能，结果是？c
        if(b == false)
            System.out.println("a");
        else if(b)
            System.out.println("b");//输出结果 b
        else if(!b)
            System.out.println("c");
        else
            System.out.println("d");
    }
}

package com.grammar.flow;
/*
2、
    分支结构
        1. if-else结构(条件判断结构)
            第一种：
                if(条件表达式){
                    执行代码块;（可以有多条语句）
                }
            第二种：
                if(){}else{}
            第三种：
                if(){}else if{}else if{}...else{}

 */
public class Branch {
    public static void main(String[] args) {
        //1.if-else
        int heartBeats = 79;
        if(heartBeats < 60 || heartBeats > 100){
            System.out.println("需要做进一步检查");
        }
        System.out.println("检查结束");

        int age = 23;
        if(age < 18){
            System.out.println("你还可以看动画片");
        }else{
            System.out.println("你可以看成人电影了");
        }

        if(age < 0)
        {
            System.out.println("你输入的数据非法");
        }else if(age < 18){
            System.out.println("青少年时期");
        }else if(age < 35){
            System.out.println("青壮年时期");
        }else if(age < 60){
            System.out.println("中年时期");
        }else if(age < 120){
            System.out.println("老年时期");
        }else{
            System.out.println("你是要成仙啊~");
        }
    }
}

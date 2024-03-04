package com.oop.up.test;

public class VariableParameterTest {
    public static void main(String[] args) {
        /*
        有三个方法，分别实现返回姓名和两门课成绩(总分)，返回姓名和三门课成绩(总
        分)，返回姓名和五门课成绩(总分)。封装成一个可变参数的方法。
         */
        HspMethods01 methods01 = new HspMethods01();
        System.out.println(methods01.showScore("张三", 78.5, 89));
        System.out.println(methods01.showScore("李四", 87, 75, 98));
        System.out.println(methods01.showScore("王五", 67, 89, 45, 99, 100));
    }
}
class HspMethods01{
    public String showScore(String a,double... scores){
        double totalScore = 0;
        for (int i = 0; i < scores.length; i++) {
            totalScore += scores[i];
        }
        return a + "有" + scores.length +"门课的成绩总分为：" + totalScore;
    }
}
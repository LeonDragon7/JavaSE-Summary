package com.grammar.variable.test;

public class VariableTest02 {
    public static void main(String[] args) {
        //编程实现
		/*
		姓名		年龄		成绩		性别		爱好
		xx		xx		xx		xx		xx

		要求：
		1)用变量将姓名、年龄、成绩、性别、爱好存储
		2)使用+
		3)添加适当的注释
		4)添加转义字符，使用一条语句输出
		*/

        String name = "张三";//定义姓名变量
        int age = 18;//定义年龄变量
        double grade = 78.5;//定义成绩变量
        char gender = '男';//定义性别变量
        String hobby = "打篮球";//定义爱好变量
        System.out.println("姓名\t年龄\t成绩\t性别\t爱好\n" + name + "\t" + age
                + "\t" + grade + "\t" + gender + "\t" + hobby);//'\t'
    }
}

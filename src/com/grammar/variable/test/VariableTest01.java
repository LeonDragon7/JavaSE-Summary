package com.grammar.variable.test;

public class VariableTest01 {
    public static void main(String[] args) {
        //保存两本书名、性别、书的价格，用+号拼接
        //书名
        String b1 = "《红楼梦》";
        String b2 = "《水浒传》";
        System.out.println(b1 + b2);//《红楼梦》 《水浒传》
        //性别
        char c1 = '男';
        char c2 = '女';
        System.out.println(c1 + c2);//得到整数 (男) 字符码值 + (女) 字符码值
        //价格
        double p1 = 78.9;
        double p2 = 97.7;
        System.out.println(p1 + p2);//176.6000000000000002
    }
}

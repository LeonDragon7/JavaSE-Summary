package com.file.properties_;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
    Properties 类
    看一个需求
    如下一个配置文件mysql.properties
        · ip=192.168.0.13
        · user = root
        · pwd = 123456
    请问编程读取ip. user 和pwd的值是多少

    分析
    1、传统的方法
    2、使用Properties类可以方便实现
 */
public class Properties01 {
    public static void main(String[] args) throws IOException {
        //1、传统的方法 比较麻烦
        //读取mysql.properties 文件，并得到ip, user 和 pwd
        BufferedReader br = new BufferedReader(new FileReader("D:\\BackEnd\\Java\\JavaSE\\Project\\Basic\\src\\mysql.properties"));
        String line = "";
        while ((line = br.readLine()) != null) { //循环读取
            String[] split = line.split("=");
            //如果我们要求指定的ip值
            if("ip".equals(split[0])) {
                System.out.println(split[0] + "值是: " + split[1]);
            }
        }
        br.close();
    }
}

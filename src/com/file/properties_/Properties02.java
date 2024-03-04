package com.file.properties_;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/*
    Properties 类
    基本介绍
    1、专门用于读写配置文件的集合类
    配置文件的格式:
        键=值
        键=值
    2、注意:键值对不需要有空格，值不需要用引号一起来。默认类型是String
    3、Properties的常见方法
    · load:加载配置文件的键值对到Properties对象
    · list:将数据显示到指定设备/流对象
    · getProperty(key):根据键获取值
    · setProperty(key,value):设置键值对到Properties对象
    · store:将Properties中的键值对存储到配置文件,在idea中，保存信息到配置文件，如果含有中文，会存储为unicode码
    http://tool.chinaz.com/tools/unicode.aspx unicode码查询工具
 */
public class Properties02 {
    //2、使用Properties类可以方便实现
    public static void main(String[] args) throws IOException {
        //1.使用Properties 类来读取mysql.properties 文件

        //1. 创建Properties 对象
        Properties properties = new Properties();
        //2. 加载指定配置文件
        properties.load(new FileReader("D:\\BackEnd\\Java\\JavaSE\\Project\\Basic\\src\\mysql.properties"));
        //3. 把k-v显示控制台
        properties.list(System.out);
        //4. 根据key 获取对应的值
        String user = properties.getProperty("user");
        String pwd = properties.getProperty("pwd");
        System.out.println("用户名=" + user);
        System.out.println("密码是=" + pwd);
    }
}

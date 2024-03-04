package com.grammar.flow.test;

import java.util.Scanner;


public class BreakTest01 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    //1) 1-100以内的数求和，求出当和第一次大于20的当前数【for + break】
    /*
    思路分析
    1.循环 1-100，求和 sum
    2.当sum > 20時，记录下当前数，然后break
     */
    int sum = 0; // 累计和
    for (int i = 1; i <= 10; i++) {
      sum += i;
      if(sum > 20){
        System.out.println("和 > 20,当前数i = " + i);
        break;
      }
    }
    /*
    2) 实现登录验证，有三次机会，如果用户为“丁真”，密码“666”提示登录成功，
    否则提示还有几次机会，请使用for+break完成
     */
    /*
    思路分析：
    1.创建Scanner对象接受用户输入。
    2.定义String username;String password;保存用户名和密码。
    3.最多循环3次[登录3次]，如果满足条件就提前退出。
    4.定义一般变量 int change;记录还有几次登录机会
     */
    String username = "";
    String password = "";
    int change = 3;//登录一次，就减少一次
    for (int i = 1; i <= 3; i++) {
      System.out.println("请输入用户名：");
      username = scanner.next();
      System.out.println("请输入密码：");
      password = scanner.next();
      //比较输入的名字和密码是否正确
      //字符串的比较：使用的方法equals 例：username.equals("丁真")
      if("丁真".equals(username) && "666".equals(password)){//推荐 可以避免空指针
        System.out.println("恭喜你，登陆成功~");
        break;
      }
      //登录的机会就减少一次
      change--;
      if(change == 0){
        System.out.println("你的机会用完了");
        break;
      }
      System.out.println("你还有" + change + "次机会");
    }
  }
}

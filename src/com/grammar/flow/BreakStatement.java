package com.grammar.flow;

/*
    跳转控制语句-break
      基本介绍：
      break语句用于终止某个语句块的执行，一般使用在switch或者循环中
      基本语法：
      {
      ...
      break;
      ...
      }
 */
public class BreakStatement {
  public static void main(String[] args) {
    /*
      随机生成1-100的一个数，直到生成了97这个数，看看你一共用了几次？
      提示使用(int)(Math.random()*100) + 1
     */
    for (int i = 0; i <= 1000; i++) {
      int number = (int)(Math.random()*100) + 1;
      if(number == 97){
        System.out.println("i = " + i);
        break;
      }
    }
  }
}

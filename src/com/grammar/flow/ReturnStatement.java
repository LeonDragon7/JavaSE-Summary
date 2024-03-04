package com.grammar.flow;

/*
    跳转控制语句-return
    介绍：
    return使用在方法，表示跳出所在方法。
    注意：如果return写在main方法，退出程序
 */
public class ReturnStatement {
  public static void main(String[] args) {
    for (int i = 1; i <= 5; i++) {
      if(i == 3){
        System.out.println("山炮哈哈哈哈哈哈");
        return;//Hello World! Hello World! 山炮哈哈哈哈哈哈
        //break;输出：Hello World! Hello World! 山炮哈哈哈哈哈哈 Go on.
        //continue;输出：Hello World! Hello World! 山炮哈哈哈哈哈哈 Hello World! Hello World! Go on.
      }
      System.out.println("Hello World!");
    }
    System.out.println("Go on.");
  }
}

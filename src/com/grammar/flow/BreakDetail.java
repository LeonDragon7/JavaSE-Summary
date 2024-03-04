package com.grammar.flow;


/*
    跳转控制语句-break
      注意事项和细节说明：
      1.break语句出现在多层嵌套的语句块中時，可以通过标签指明要终止的是哪一层语句块
      2.标签的基本使用
        label1:{  ...
        label2:        { ...
        label3:                       {           ...
                                                  break label2;
                                                  ...
                                       }
                       }
                 }
          (1) break语句可以指定退出哪层。
          (2) label1是标签，由程序员指定。
          (3) break 后指定到哪个label就退出到哪里。
          (4) 在实际的开发中，尽量不要使用标签。
          (5) 如果没有指定 break，默认推出最近的循环体。
 */
public class BreakDetail {
  public static void main(String[] args) {
      lable1:
      for (int j = 0; j < 4; j++) {
        lable2:
        for (int i = 0; i < 10; i++) {
          if (i == 2) {
            break lable1;
          }
          System.out.println("i = " + i);
        }
      }
  }
}

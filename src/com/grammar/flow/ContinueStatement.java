package com.grammar.flow;
/**
 * ClassName: ContinueStatement
 * Description:
 *
 * @Author Agility6
 * @Create 2023-10-23 21:31
 * @Version 1.0
 */
/*
    跳转控制语句-continue
        基本介绍：
        1) continue语句用于结束本次循环，继续执行下一次循环。
        2) continue语句出现在多层嵌套的循环语句体中时，可以通过标签指明要跳过的是哪一层循环，这个和前面的标签的使用的规则一样。
        基本语法：
        {
            ...
            continue;
            ...
        }
 */
public class ContinueStatement {
  public static void main(String[] args) {
    int i = 1;
    while (i <= 4){
      i++;
      if(i == 2){
        continue;
      }
      System.out.println("i = " + i);
    }
  }
}

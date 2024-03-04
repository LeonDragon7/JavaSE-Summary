package com.grammar.flow;

public class ContinueDetail {
  public static void main(String[] args) {
    lable1:
    for (int i = 0; i < 4; i++) {
      lable2:
      for (int j = 0; j < 10; j++) {
        if(j == 2){
          continue lable1;//(j = 0 j = 1) x 4
          //continue; 等价于 continue lable 2 (j = 0 ...j = 9) x 4
        }
        System.out.println("j = " + j);
      }
    }
  }
}

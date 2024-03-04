package Flow.Test;

import java.util.Scanner;

/**
 * ClassName: FlowTest01
 * Description:
 *
 * @Author Agility6
 * @Create 2023-10-23 22:03
 * @Version 1.0
 */
public class FlowTest01 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    /*
    1.编程实现如下功能
    某人有100,000元，每经过一次路口，需要交费，规则如下：
    1) 当现金>50000时，每次交5%
    2) 当现金<=50000时，每次交1000
    编程计算该人可以经过多少次路口，要求：使用while break方式完成

    思路分析：
    1.定义 double cash;
    2.有三种情况
      1) cash > 50000
      2) cash >= 1000 && cash <= 50000
      3) cash < 1000
    3.使用多分支语句if{}- else if(){} - else{}
    4.while+break[cash < 1000],同时使用一个变量count来保存通过的入口
     */
    System.out.println("请输入你的现金：");
    double cash = scanner.nextDouble();
    int count = 0;//经过路口的次数
    while(true){//无限循环
      if(cash > 50000){
        cash *= 0.95;//cash -= cash * 0.05;
        count++;
      }else if(cash >= 1000){
        cash -= 1000;
        count++;
      }else{
        break;
      }
    }
    System.out.println("你可以经过" + count + "次路口");
  }
}

package Flow.Test;

import java.util.Scanner;

/**
 * ClassName: FlowTest04
 * Description:
 *
 * @Author Agility6
 * @Create 2023-10-23 22:28
 * @Version 1.0
 */
public class FlowTest04 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    /*
    4.判断一个整数是否是水仙花数，所谓水仙花数是指一个3位数，其各个位上数字立方和等于其本身。
    例如：153 = 1 * 1 * 1 + 3 * 3 * 3 + 5 * 5 * 5

    思路分析：
    1. 定义变量int number = 153;
    2. 先得到number的百位，十位，个位的数字，使用if判断他们的立方和是否相等
      1) 百位 = number / 100;
      2) 十位 = number % 100 / 10;
      3) 个位 = number % 10;
    3. 判断if
     */
    int hundred = 0;
    int decade = 0;
    int unit = 0;
    int sum = 0;
    System.out.println("请输入一个3位整数：");
    int number = scanner.nextInt();
    if(number >= 100 && number <= 999){
      hundred = number / 100;
      decade = number % 100 / 10;
      unit = number % 10;
      sum = (hundred * hundred * hundred) + (decade * decade * decade) + (unit * unit * unit);
      if(sum == number){
        System.out.println(number + "是水仙花数");
      } else {
        System.out.println(number + "不是水仙花数");
      }
    }else {
      System.out.println("请输入一个3位整数!");
    }
  }
}

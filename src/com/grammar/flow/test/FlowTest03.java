package Flow.Test;

import java.util.Scanner;

/**
 * ClassName: FlowTest03
 * Description:
 *
 * @Author Agility6
 * @Create 2023-10-23 22:25
 * @Version 1.0
 */
public class FlowTest03 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    //3.判断一个年份是否为闰年
    System.out.println("请输入年份");
    int year = scanner.nextInt();
    if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0){
      System.out.println(year + "是闰年");
    }else {
      System.out.println(year + "不是闰年");
    }
  }
}

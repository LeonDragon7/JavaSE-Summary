package Flow.Test;

import java.util.Scanner;

/**
 * ClassName: FlowTest02
 * Description:
 *
 * @Author Agility6
 * @Create 2023-10-23 22:17
 * @Version 1.0
 */
public class FlowTest02 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    //2.实现判断一个整数，属于哪个范围：大于0;小于0;等于0
    System.out.println("请输入一个整数：");
    int number = scanner.nextInt();
    if(number > 0){
      System.out.println("大于0");
    } else if (number == 0) {
      System.out.println("等于0");
    }else {
      System.out.println("小于0");
    }
  }
}

package Flow.Test;

/**
 * ClassName: FlowTest07
 * Description:
 *
 * @Author Agility6
 * @Create 2023-10-24 20:42
 * @Version 1.0
 */
public class FlowTest07 {
  public static void main(String[] args) {
    //7.输出小写的a-z以及大写的Z-A
    /*
    思路分析：
    1. 'b' = 'a' + 1 -> 'c' = 'a' + 2
    2. 使用for循环
     */
    System.out.println("小写字母:");
    for (char i = 'a'; i <= 'z'; i++) {
      System.out.print(i  + " ");
    }
    System.out.println(" ");
    System.out.println("大写字母:");
    for (char i = 'Z'; i >= 'A'; i--) {
      System.out.print(i + " ");
    }
  }
}

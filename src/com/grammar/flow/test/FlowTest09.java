package Flow.Test;

/**
 * ClassName: FlowTest09
 * Description:
 *
 * @Author Agility6
 * @Create 2023-10-24 21:32
 * @Version 1.0
 */
public class FlowTest09 {
  public static void main(String[] args) {
    //9.求1 + (1 + 2) + (1 + 2 + 3) + (1 + 2 + 3 + 4) + ... + (1 + 2 + 3 + .. + 100)的结果
    /*
    思路分析：
    1. 一共有100组和相加 for i
    2. 每一组的数字在逐渐相加 for j
     */
    int sum = 0;
    for (int i = 1; i <= 100; i++) {
      for (int j = 1; j <= i; j++) {
        sum += j;
      }
    }
    System.out.println("输出结果为：" + sum);
  }
}

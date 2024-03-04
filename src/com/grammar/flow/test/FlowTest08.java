package Flow.Test;

/**
 * ClassName: FlowTest08
 * Description:
 *
 * @Author Agility6
 * @Create 2023-10-24 21:11
 * @Version 1.0
 */
public class FlowTest08 {
  public static void main(String[] args) {
    //求出1 - 1/2 + 1/3 - 1/4......1/100的和
    /*
    思路分析：
    1. 1 - 1/2 + 1/3 - 1/4......1/100 = (1 / 1) - (1 / 2) + (1 / 3) - (1 / 4)...(1 / 100)
    2. 从上面的分析我们可以得出：
     1) 一共有100个数，分子为1，分母从1 - 100
     2) 分母为奇数时，前面时+,分母时偶数时，前面时-
    3. 使用for + if-else
    4. 将结果存放到double sum = 0;
    5. 定义分子为0 double deno = 1.0;->防止 double = int / int 为 0
     */
    double deno = 1.0;
    double sum  = 0;
    for (int i = 1; i <= 100; i++) {
      if(i % 2 == 0){
         sum -= deno / i;
      }else{
        sum += deno / i;
      }
    }
    System.out.println("sum = " + sum);
  }
}

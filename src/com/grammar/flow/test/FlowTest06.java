package Flow.Test;

/**
 * ClassName: FlowTest06
 * Description:
 *
 * @Author Agility6
 * @Create 2023-10-24 20:30
 * @Version 1.0
 */
public class FlowTest06 {
  public static void main(String[] args) {
    //6.输出1-100之间不能被5整除的数，每5个一行
    /*
     思路分析：
     1. 先输出1-100所有的数
     2. 过滤输出 不能被5整除的数 i % 5 != 0
     3. 每5个一行:使用int count = 0;统计输出的个数，当 count % 5 == 0就输出换行
     */
    int count = 0;
    for (int i = 1; i <= 100; i++) {
      if(i % 5 != 0){
        count++;
        System.out.print(i +  "\t");
      }
      if(count % 5 == 0){
        System.out.println();
      }
    }
  }
}

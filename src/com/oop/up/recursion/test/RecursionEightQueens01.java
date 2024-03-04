package com.oop.up.recursion.test;
/*
    方法递归调用
    八皇后问题
    说明：
    八皇后问题，是一个古老而著名的问题，是回朔算法的典型案例。该问题是国际
    西洋棋棋手马克斯·贝瑟尔1848年提出：在8×8格的国际象棋上摆放八个皇后，
    使其不能互相攻击，即：任意两个皇后都不能处于同一行、同一列或同一斜线上
    ，问有多少种摆法？

    思路分析：
    1、第一个皇后先放第一行第一列
    2、第二个皇后放在第二行第一列、然后判断是否ok，如果不ok，继续放在第二列、
    第三列、依次把所有；列都放完，找到一个合适
    3、继续第三个皇后，还是第一列、第二列......直到第8个皇后也能放在一个不
    冲突的位置，算是找到了一个正确解
    4、当得到一个正确解时，在栈回退到上一个栈时，就会开始回溯，即将第一个皇后，
    放到第一列的所有正确解，全部得到。
    5、然后回头继续第一个皇后放第二列，后面继续执行1,2,3,4的步骤

    说明：理论上应该创建一个二维数组来表示棋盘，但是实际上可以通过算法，用一个
    一维数组即可解决问题，arr[8] = {0,4,7,5,2,6,1,3}//对应arr下标 表示第
    几行，即第几个皇后，arr[i] = val,val表示第i + 1个皇后，放在第i + 1行的
    第val + 1列
 */
public class RecursionEightQueens01 {
    //定义一个max，表示共有多少个皇后
    int max = 8;
    //定义一个数组arr，保存皇后放置位置的结果，比如arr[8] = {0,4,7,5,2,6,1,3}
    int[] arr = new int[max];
    static int count = 0;//统计一共有多少种解法
    static int judgeCount = 0;//统计冲突的次数
    public static void main(String[] args) {
        RecursionEightQueens01 rec = new RecursionEightQueens01();
        rec.check(0);
        System.out.println("一共有" + count + "解法");
        System.out.println();
        System.out.println("一共判断冲突的次数为" + judgeCount + "次");
    }

    //放置第n + 1 皇后
    private void check(int n){
        if(n == max){//已有八个皇后，第九个不用放
            print();
            return;
        }
        //依次放入皇后，并判断是否冲突
        for (int i = 0; i < max; i++) {
            //先把这个皇后放在该行的第一列，第i列
            arr[n] = i;
            //判断这个位置是否冲突
            if(judge(n)){//不冲突
                //接着放下一个皇后
                check(n + 1);
            }
            //如果冲突，继续执行i++,arr[n] = i，尝试下一个位置
        }
    }

    /**
     * 查看当我们放置第n + 1个皇后，就去检测该皇后是否和前面以放置的皇后冲突
     *
     *  n 表示第 n + 1个皇后
     * @return
     */
    private boolean judge(int n){
        judgeCount++;
        for (int i = 0; i < n; i++) {
            //arr[i] == arr[n]：说明在同一列
            //Math.abs(arr[n] - arr[i])：说明在同一斜线上 Math.abs()：求绝对值
            // n = 1 放置2列1 n = 1 arr[1] = 1
            //Math.abs(1-0) == 1 Math.abs(arr[1] - arr[0]) == Math.abs(1 - 0) == 1
            if(arr[i] == arr[n] || Math.abs(n - i) == Math.abs(arr[n] - arr[i])){
                return false;
            }
        }
        return true;
    }
    //输出皇后摆放的位置
    private void print(){
        count++;
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}



package com.oop.up.recursion;
/*
    递归方法调用
    递归重要规则
    1、执行一个方法时，就创建一个新的受保护的独立空间(栈空间)
    2、方法的局部变量是独立的，不会相互影响，比如：n变量
    3、如果方法中使用的是引用类型变量（比如：数组），就会共享该引用类型
    的数据
    4、递归必须向退出递归的条件逼近，否则就是无限递归，出现
    StackOverflowError,死递归了
    5、讲一个方法执行完毕，或者遇到return，就会返回，遵守谁调用，
    就将结果返回给谁，同时当方法执行完毕或者返回时，该方法也将执行完毕。
 */
public class RecursiveCall01 {
    public static void main(String[] args) {
        T t = new T();
        t.test(4);
        int res = t.factorial(5);
        System.out.println("res = " + res);//120
    }
}
class T{
    //打印问题,输出结果？
    public void test(int n){
        if(n > 2){
            test(n - 1);
        }
        System.out.println("n = " + n);
    }
    //阶乘问题,输出结果？
        public int factorial(int n){
            if(n == 1){
                return 1;
            }else{
                return factorial(n - 1) * n;
            }
        }
}
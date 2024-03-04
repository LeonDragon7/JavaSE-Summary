package com.exception_.try_;
/*
    try-catch 方式处理异常细节
    5、可以进行try-finally配合使用,这种用法相当于没有捕获异常，因此程序会直接崩掉/退出。
    应用场景就是执行一段代码，不管是否发生异常，都必须执行某个业务逻辑。

    try-catch-finally 执行顺序小结
    1、如果没有出现异常，则执行try块中所有语句，不执行catch块中语句，如果有finally，
    最后还需要执行finally里面的语句。
    2、如果出现异常，则try块中异常发生后，try块剩下的语句不再执行。将执行catch块中的语句，
    如果有finally，最后还需要执行finally里面的语句。
 */
public class TryCatchDetail02 {
    public static void main(String[] args) {
        /*
        可以进行 try-finally 配合使用, 这种用法相当于没有捕获异常，
        因此程序会直接崩掉/退出。应用场景，就是执行一段代码，不管是否发生异			常，都必须执行某个业务逻辑
         */
        try{
            int n1 = 10;
            int n2 = 0;
            System.out.println(n1 / n2);
        }finally {
            System.out.println("执行了finally.."); // 执行完直接退出
        }
        System.out.println("程序继续执行.."); // 不会执行
    }
}

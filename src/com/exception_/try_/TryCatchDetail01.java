package com.exception_.try_;
/*
    try-catch 方式处理异常细节
    1、如果异常发生了，则异常发生后面的代码不会执行，直接进入到catch块。
    2、如果异常没有发生，则顺序执行try的代码块，不会进入到catch。
    3、如果希望不管是否发生异常，都执行某段代码(比如关闭连接,释放资源等)
    则使用如下代码 finally {}
    4、可以有多个catch语句，捕获不同的异常(进行不同的业务处理)，要求父类异常
    在后，子类异常在前，比如( Exception 在后，NullPointerException 在前)，
    如果发生异常，只会匹配一个catch。（因为如果在前面都让Exception捕获了，
    后面写子类捕获就没有用了）。
 */
public class TryCatchDetail01 {
    public static void main(String[] args) {

        //1.如果try代码块有可能有多个异常
        //2.可以使用多个catch 分别捕获不同的异常，相应处理
        //3.要求子类异常写在前面，父类异常写在后面
        try {
            Person person = new Person();
            //person = null;
            System.out.println(person.getName());//NullPointerException
            int n1 = 10;
            int n2 = 0;
            int res = n1 / n2;//ArithmeticException
        } catch (NullPointerException e) {
            System.out.println("空指针异常=" + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("算术异常=" + e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
        }
    }
}
class Person {
    private String name = "jack";
    public String getName() {
        return name;
    }
}


package com.oop.advanced.final_;

public class FinalDetail01 {
    /*
        final使用注意事项和细节讨论
        1、final修饰的属性又叫常量,一般用 XX_XX_XX来命名
        2、final修饰的属性在定义时,必须赋初值,并且以后不能再修改，赋值可以在如下位置之一:
        1）定义时:如public final double TAX_RATE=0.08;
        2）在构造器中
        3）在代码块中
        3、如果final修饰的属性是静态的，则初始化的位置只能是
        ①定义时
        ②在静态代码块（不能在构造器中赋值。因为构造器是在对象创建的时候才会进行赋值）
        4、final类不能继承,但是可以实例化对象。
        5、如果类不是final类，但是含有final方法，则该方法虽然不能重写，但是可以被继承。
        （子类用是没问题的，虽然不能重写）

     */
}
class AA {
    /*
    1. 定义时：如public final double TAX_RATE=0.08;
    2. 在构造器中
    3. 在代码块中
    */
    public final double TAX_RATE = 0.08;//1.定义时赋值
    public final double TAX_RATE2 ;
    public final double TAX_RATE3 ;
    public AA() {//构造器中赋值
        TAX_RATE2 = 1.1;
        }
        {//在代码块赋值
            TAX_RATE3 = 8.8;
        }
}

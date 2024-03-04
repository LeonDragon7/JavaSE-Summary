package com.oop.advanced.final_;

public class FinalDetail02 {
    /*
        final使用注意事项和细节讨论
        6、一般来说，如果一个类已经是final类了，就没有必要再将方法修饰成final方法。
        （因为类既然不能被继承，也就相应无法被重写或使用）。
        7、final不能修饰构造方法(即构造器)。
        8、final和static 往往搭配使用，效率更高，因为不会导致类加载，底层编译器做了优化处理。
        9、包装类(Integer,Double,Float,Boolean等都是final),String也是final类。
     */
}

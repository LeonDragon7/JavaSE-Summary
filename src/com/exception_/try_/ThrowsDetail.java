package com.exception_.try_;
/*
    注意事项和使用细节
    1、对于编译异常,程序中必须处理，比如try-catch或者throws。
    2、对于运行时异常，程序中如果没有处理,默认就是throws的方式处理（相当于方法后有一个throws XXXException，
    这时逐级向上，最后main方法上可能也默认throws，这时就给JVM处理）。
    3、子类重写父类的方法时，对抛出异常的规定：子类重写的方法，所抛出的异常类型要么和父类抛出的异常一致，要么为父
    类抛出的异常的类型的子类型。
    4、在throws过程中，如果有方法try-catch，就相当于处理异常，就可以不必throws。
    例如子类有一个编译异常，使用throws抛出，那么父类也必须对该异常做出反应，或是throws，或者try catch，否则同
    样是编译异常。
 */
public class ThrowsDetail {
}

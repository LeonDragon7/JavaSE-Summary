package com.reflection.classload_;
/*
    加载阶段
    JVM在该阶段的主要目的是将字节码从不同的数据源(可能是class文件、也可能是jar包，甚至网络）转化为二进制字节流加载到内存中，并生成一个代表该类的java.lang.Class对象。

    连接阶段-验证
    1.目的是为了确保 Class文件的字节流中包含的信息符合当前虚拟机的要求，并且不会危害虚拟机自身的安全。
    2.包括:文件格式验证(是否以魔数oxcafebabe开头)、元数据验证、字节码验证和符号引用验证[举例说明]。
    3.可以考虑使用 -Xverify:none 参数来关闭大部分的类验证措施，缩短虚拟机类加载的时间。

    连接阶段-准备
    1.JVM会在该阶段对静态变量，分配内存并默认初始化（对应数据类型的默认初始值，如0、OL、null、false等)。这些变量所使用的内存都将在方法区中进行分配。
 */
public class ClassLoad02 {
    public static void main(String[] args) {

    }
}
class A {
    //属性-成员变量-字段
    //分析类加载的链接阶段-准备 属性是如何处理
    //1. n1 是实例属性, 不是静态变量，因此在准备阶段，是不会分配内存
    //2. n2 是静态变量，分配内存 n2 是默认初始化 0 ,而不是20。初始化子阶段才会是20。
    //3. n3 是 static final 是 常量, 他和静态变量不一样, 因为一旦赋值就不变 因此n3 = 30
    public int n1 = 10;
    public static  int n2 = 20;
    public static final  int n3 = 30;
}

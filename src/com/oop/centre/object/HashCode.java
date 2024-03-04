package com.oop.centre.object;
/*
    Object类详解
    hashCode方法
    public int hashCode()
    返回对象的哈希码值。支持此方法是为了使用哈希表(如HashMap提供的哈希表)。
    hashCode的常规协定是:
    1、在Java应用程序的执行过程中，只要在同一对象上多次调用hashCode方法，hashCode方法必须始终返回相同的整数，
    前提是对象上用于equals比较的信息没有被修改。该整数不必在应用程序的一次执行与另一次执行之间保持一致。
    2、如果根据equals(Object)方法两个对象相等，那么对这两个对象中的每一个调用hashCode方法必须产生相同的整数结果。
    3、根据equals(java.lang.Object)方法，如果两个对象不相等，则不要求对这两个对象中的每一个调用hashCode方法必须
    产生不同的整数结果。然而，程序员应该意识到，为不相等的对象生成不同的整数结果可能会提高哈希表的性能。

    在合理可行的情况下，由Object类定义的hashCode方法确实为不同的对象返回不同的整数。
    (这通常通过将对象的内部地址转换为整数来实现，但是Java™编程语言不需要这种实现技术。)

    返回:
        该对象的哈希码值。

    小结：
    1）提高具有哈希结构的容器效率
    2）两个引用，如果指向的是同一个对象，则哈希值肯定是一样的
    3）两个引用，如果指向的是不同对象，则哈希值是不一样的
    4）哈希值主要根据地址号来的，不能完全将哈希值等价于地址
 */
public class HashCode {
    public static void main(String[] args) {
        //3）两个引用，如果指向的是不同对象，则哈希值是不一样的
        AA aa1 = new AA();
        AA aa2 = new AA();
        System.out.println("aa1.hashCode() = " + aa1.hashCode());
        System.out.println("aa2.hashCode() = " + aa2.hashCode());
        AA aa3 = aa1;
        //2）两个引用，如果指向的是同一个对象，则哈希值肯定是一样的
        System.out.println("aa3.hashCode() = " + aa3.hashCode());
    }
}
class AA{}
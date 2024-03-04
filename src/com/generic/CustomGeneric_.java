package com.generic;

import java.util.Arrays;

/*
    自定义泛型
    自定义泛型类
    class 类名 <T,R..> {//..表示可以有多个泛型
	成员
    }

    注意细节
    1、普通成员可以使用泛型(属性、方法)
    2、使用泛型的数组,不能初始化：因为没有确定类型，就不知道到底要开辟多大的空间。
    3、静态方法中不能使用类的泛型，因为静态是与类相关的，因此类的加载时对象还没有创建，因此无法指定静态方法/变量的类型。
    如果静态方法和静态属性使用了泛型，JVM就无法完成初始化。
    4、泛型类的类型，是在创建对象时确定的(因为创建对象时，需要指定确定类型
    5、如果在创建对象时,没有指定类型，默认为Object
    class Tiger<T, R, M>{
        String name;
        R r;
        M m;
        T t;
    }
 */
@SuppressWarnings({"all"})
public class CustomGeneric_ {
    public static void main(String[] args) {

        //T=Double, R=String, M=Integer
        Tiger1<Double,String,Integer> g = new Tiger1<>("john");
        g.setT(10.9); //OK
        //g.setT("yy"); //错误，类型不对
        System.out.println(g);
        Tiger1 g2 = new Tiger1("john~~");//OK T=Object R=Object M=Object
        g2.setT("yy"); //OK ,因为 T=Object "yy"=String 是Object子类
        System.out.println("g2=" + g2);

    }
}
//1. Tiger1 后面泛型，所以我们把 Tiger1 就称为自定义泛型类
//2, T, R, M 泛型的标识符, 一般是单个大写字母
//3. 泛型标识符可以有多个.
//4. 普通成员可以使用泛型 (属性、方法)
//5. 使用泛型的数组，不能初始化
//6. 静态方法中不能使用类的泛型
class Tiger1<T, R, M> {
    String name;
    R r; //属性使用到泛型
    M m;
    T t;
    //因为数组在new 不能确定T的类型，就无法在内存开空间 T[] ts = new T[8];错误
    T[] ts;

    public Tiger1(String name) {
        this.name = name;
    }

    public Tiger1(R r, M m, T t) {//构造器使用泛型

        this.r = r;
        this.m = m;
        this.t = t;
    }

    public Tiger1(String name, R r, M m, T t) {//构造器使用泛型
        this.name = name;
        this.r = r;
        this.m = m;
        this.t = t;
    }

    //因为静态是和类相关的，在类加载时，对象还没有创建
    //所以，如果静态方法和静态属性使用了泛型，JVM就无法完成初始化
//    static R r2;
//    public static void m1(M m) {
//
//    }

    //方法使用泛型

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public R getR() {
        return r;
    }

    public void setR(R r) {//方法使用到泛型
        this.r = r;
    }

    public M getM() {//返回类型可以使用泛型.
        return m;
    }

    public void setM(M m) {
        this.m = m;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    @Override
    public String toString() {
        return "Tiger{" +
                "name='" + name + '\'' +
                ", r=" + r +
                ", m=" + m +
                ", t=" + t +
                ", ts=" + Arrays.toString(ts) +
                '}';
    }
}
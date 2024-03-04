package com.oop.advanced.innerclass;
/*
    成员内部类的使用
    说明: 成员内部类是定义在外部类的成员位置,并且没有static修饰。
    1.可以直接访问外部类的所有成员，包含私有的。
    2.可以添加任意访问修饰符(public、protected、默认、private), 因为它的地 位就是一个成员。
    3.作用域和外部类的其他成员一样，为整个类体比如前面案例，在外部类的成员方法中创建成员内部类对象，再调用方法。
    4.成员内部类---访问---->外部类成员(比如:属性) 访问方式:直接访问
    5.外部类---访问------>成员内部类(说明) 访问方式:创建对象,再访问
    6.外部其他类---访问---->成员内部类
    7.如果外部类和内部类的成员重名时，内部类访问的话，默认遵循就近原则，如果想访问外部类的成员，则可以使用(外部类名.this.成员)去访问
 */
public class MemberInnerClass {
    public static void main(String[] args) {
        Outer08 outer08 = new Outer08();
        outer08.t1();

        //外部其他类，使用成员内部类的二种方式
        // 第一种方式
        // outer08.new Inner08(); 相当于把 new Inner08()当做是outer08成员
        // 这就是一个语法，不要特别的纠结.
        Outer08.Inner08 inner08 = outer08.new Inner08();
        inner08.say();
        // 第二方式 在外部类中，编写一个方法，可以返回 Inner08对象
        Outer08.Inner08 inner08Instance = outer08.getInner08Instance();
        inner08Instance.say();
    }
}
class Outer08 { //外部类
    private int n1 = 10;
    public String name = "张三";

    private void hi() {
        System.out.println("hi()方法...");
    }

    //1.注意: 成员内部类，是定义在外部内的成员位置上
    //2.可以添加任意访问修饰符(public、protected 、默认、private),因为它的地位就是一个成员
    public class Inner08 {//成员内部类
        private double sal = 99.8;
        private int n1 = 66;
        public void say() {
            //可以直接访问外部类的所有成员，包含私有的
            //如果成员内部类的成员和外部类的成员重名，会遵守就近原则.
            //，可以通过  外部类名.this.属性 来访问外部类的成员
            System.out.println("n1 = " + n1 + " name = " + name + " 外部类的n1=" + Outer08.this.n1);
            hi();
        }
    }
    //方法，返回一个Inner08实例
    public Inner08 getInner08Instance(){
        return new Inner08();
    }


    //写方法
    public void t1() {
        //使用成员内部类
        //创建成员内部类的对象，然后使用相关的方法
        Inner08 inner08 = new Inner08();
        inner08.say();
        System.out.println(inner08.sal);
    }
}

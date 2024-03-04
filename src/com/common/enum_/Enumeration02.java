package com.common.enum_;
/*
    枚举的二种实现方式
    1、自定义类实现枚举
    2、使用enum 关键字实现枚举

    自定义类实现枚举-应用案例
    1.不需要提供setXxx方法，因为枚举对象值通常为只读.
    2.对枚举对象/属性使用 final + static共同修饰，实现底层优化.
    （final 和 static 搭配使用可以不导致类加载,效率更高）
    3.枚举对象名通常使用全部大写，常量的命名规范.
    4.枚举对象根据需要,也可以有多个属性

    小结：
    1、构造器私有化
    2、本类内部创建一组对象[四个 春夏秋冬]
    3、对外暴露对象（通过为对象添加public final static 修饰符）
    4、可以提供get 方法，但是不要提供set
 */
public class Enumeration02 {
    public static void main(String[] args) {
        System.out.println(Season.AUTUMN);
        System.out.println(Season.SPRING);
    }
}
//演示自定义枚举实现
class Season {//类
    private String name;
    private String desc;//描述

    //定义了四个对象, 固定.
    public static final Season SPRING = new Season("春天", "温暖");
    public static final Season WINTER = new Season("冬天", "寒冷");
    public static final Season AUTUMN = new Season("秋天", "凉爽");
    public static final Season SUMMER = new Season("夏天", "炎热");


    //1. 将构造器私有化,目的防止 直接 new
    //2. 去掉setXxx方法, 防止属性被修改
    //3. 在Season 内部，直接创建固定的对象
    //4. 优化，可以在上面的四个对象加入 final 修饰符（static会导致类加载，防止这种情况， final 和 static 搭配使用可以不导致类加载,效率更高）
    private Season(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return "Season{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
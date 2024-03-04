package com.oop.centre.object;
/*
    Object类详解
    toString方法
    基本介绍
    1、默认返回：全类名(包名+类名)+@+哈希值的十六进制，【查看Object的toString方法】
    子类往往重写toString方法，用于返回对象的属性信息
    2、重写toString方法，打印对象或拼接对象时，都会自动调用该对象的toString形式。
    3、当直接输出一个对象时，toString方法会被默认调用
    System.out.println(monster);就会默认调用monster.toString();
 */
public class ToString {
    public static void main(String[] args) {
        /*
        getClass().getName()：全类名(包名+类名)
        Integer.toHexString(hashCode())：将对象的hashCode值转成16进制字符
        public String toString() {
            return getClass().getName() + "@" + Integer.toHexString(hashCode());
        }
         */
        Monster monster = new Monster("小妖怪", "巡山的", 1000);
        System.out.println(monster.toString() + " hashCode = " + monster.hashCode());
    }
}
class Monster{
    private String name;
    private String job;
    private double sal;

    public Monster(String name, String job, double sal) {
        this.name = name;
        this.job = job;
        this.sal = sal;
    }

    //重写toString方法，输出对象的属性
    @Override
    public String toString() {
        return "Monster{" +
                "name='" + name + '\'' +
                ", job='" + job + '\'' +
                ", sal=" + sal +
                '}';
    }
}
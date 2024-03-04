package com.common.enum_;
/*
    enum实现接口
    1、使用enum 关键字后，就不能再继承其它类了，因为enum 会隐式继承Enum，而 Java 是单继承机制。
    2、枚举类和普通类一样，可以实现接口，如下形式：
    enum 类名 implements 接口1，接口2{}
 */
public class EnumDetail {
    public static void main(String[] args) {
        Music.CLASSICMUSIC.playing();
    }
}
class A {

}

//1.使用enum关键字后，就不能再继承其它类了，因为enum会隐式继承Enum，而Java是单继承机制
//enum Season3 extends A {
//
//}
//2.enum实现的枚举类，仍然是一个类，所以还是可以实现接口的.
interface IPlaying {
    public void playing();
}
enum Music implements IPlaying {
    // 枚举类，CLASSICMUSIC相当于一个对象
    CLASSICMUSIC;
    @Override
    public void playing() {
        System.out.println("播放好听的音乐...");
    }
}

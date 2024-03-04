package com.annotation_;

public class Annotation01 {
    /*
        注解的理解
        1、注解(Annotation)也被称为元数据(Metadata)，用于修饰解释包、类、方法、属性、构造器、局部变量等数据信息。
        2、和注释一样，注解不影响程序逻辑，但注解可以被编译或运行，相当于嵌入在代码中的补充信息。
        3、在JavaSE 中，注解的使用目的比较简单，例如标记过时的功能，忽略警告等。在JavaEE 中注解占据了更重要的角色，
        例如用来配置应用程序的任何切面，代替java EE 旧版中所遗留的繁冗代码和XML 配置等。

        基本的Annotation介绍
        使用Annotation 时要在其前面增加 @ 符号, 并把该Annotation 当成一个修饰符使用。用于修饰它支持的程序元素。
        三个基本的Annotation:
        1、@Override: 限定某个方法，是重写父类方法, 该注解只能用于方法。
        2、@Deprecated: 用于表示某个程序元素(类, 方法等)已过时。
        3、@SuppressWarnings: 抑制编译器警告。
     */
}

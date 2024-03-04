package com.annotation_;

public class Annotation02 {
    /*
        基本的Annotation应用案例
        @Override
        @Override:限定某个方法，是重写父类方法,该注解只能用于方法。
        补充说明: 源码中@interface不是interface接口，是注解类是jdk5.0之后加入的，表示一个注解类。
        1.@Override 表示指定重写父类的方法(从编译层面验证)，如果父类没有fly方法，则会报错。
        2.如果不写@Override注解,而父类仍有public void fly，仍然构成重写。
        3.@Override只能修饰方法,不能修饰其它类，包，属性等等
        4.查看@Override注解源码为@Target(ElementType.METHOD), 说明只能修饰方法
        5.@Target是修饰注解的注解，称为元注解。

        @Deprecated
        @Deprecated: 用于表示某个程序元素(类, 方法等)已过时
        1.即不在推荐使用，但是仍然可以使用
        2.可以修饰方法，类，字段，包，参数等等
        3.@Target(value={CONSTRUCTOR, FIELD, LOCAL_VARIABLE, METHOD, PACKAGE,PARAMETER. TYPE})
        4.@Deprecated的作用可以做到新旧版本的兼容和过渡

        @SuppressWarnings
        @SuppressWarnings: 抑制编译器警告
        1.unchecked是忽略没有检查的警告
        2.rawtypes是忽略没有指定泛型的警告(传参时没有指定泛型的警告错误)
        3.unused是忽略没有使用某个变量的警告错误
        4.@SuppressWarnings可以修饰的程序元素为,查看@Target
        5.生成@SupperssWarnings时，不用背，直接点击左侧的黄色提示，就可以选择
        (注意可以指定生成的位置)
        属性介绍以及说明：
        all，抑制所有警告
        boxing，抑制与封装/拆装作业相关的警告
        cast，抑制与强制转型作业相关的警告
        dep-ann，抑制与淘汰注释相关的警告
        deprecation，抑制与淘汰的相关警告
        fallthrough，抑制与switch陈述式中遗漏break相关的警告
        finally，抑制与未传回finally区块相关的警告
        hiding，抑制与隐藏变数的区域变数相关的警告
        incomplete-switch，抑制与switch陈述式(enum case)中遗漏项目相关的警告
        javadoc，抑制与javadoc相关的警告
        nls，抑制与非nls字串文字相关的警告
        null，抑制与空值分析相关的警告
        rawtypes，抑制与使用raw类型相关的警告
        resource，抑制与使用Closeable类型的资源相关的警告
        restriction，抑制与使用不建议或禁止参照相关的警告
        serial，抑制与可序列化的类别遗漏serialVersionUID栏位相关的警告
        static-access，抑制与静态存取不正确相关的警告
        static-method，抑制与可能宣告为static的方法相关的警告
        super，抑制与置换方法相关但不含super呼叫的警告
        synthetic-access，抑制与内部类别的存取未最佳化相关的警告
        sync-override，抑制因为置换同步方法而遗漏同步化的警告
        unchecked，抑制与未检查的作业相关的警告
        unqualified-field-access，抑制与栏位存取不合格相关的警告
        unused，抑制与未用的程式码及停用的程式码相关的警告
     */
}

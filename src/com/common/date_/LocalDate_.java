package com.common.date_;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
/*
    第三代日期类
    前面两代日期类的不足分析
    JDK 1.0中包含了一个java.util.Date类，但是它的大多数方法已经在JDK 1.1引入Calendar类之后被弃用了。
    而Calendar也存在问题是:
    1、可变性:像日期和时间这样的类应该是不可变的。
    2、偏移性:Date中的年份是从1900开始的，而月份都从0开始。
    3、格式化:格式化只对Date有用，Calendar则不行。
    4、此外，它们也不是线程安全的;不能处理闰秒等(每隔2天，多出1s).

    LocalDate(日期/年月日)、LocalTime(时间/时分秒)、LocalDateTime(日期时间/年月日时分秒) JDK8加入：
        · LocalDate只包含日期，可以获取日期字段
        · LocalTime只包含时间，可以获取时间字段
        · LocalDateTime包含目期+时间，可以获取日期和时间字段
    LocalDateTime ldt = LocalDateTime.now(); //LocalDate.now();//LocalTime.now()
    System.out.println(ldt);
    ldt.getYear();
    ldt.getMonthValue();
    ldt.getMonth();
    ldt.getDayofMonth();
    ldt.getHour();
    ldt.getMinute();
    ldt.getSecond();
 */
public class LocalDate_ {
    public static void main(String[] args) {
        //第三代日期
        //1. 使用now() 返回表示当前日期时间的 对象
        LocalDateTime ldt = LocalDateTime.now(); //LocalDate.now();//LocalTime.now()
        System.out.println(ldt);

        //2. 使用DateTimeFormatter 对象来进行格式化
        // 创建 DateTimeFormatter对象
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String format = dateTimeFormatter.format(ldt);
        System.out.println("格式化的日期=" + format);

        System.out.println("年=" + ldt.getYear());
        System.out.println("月=" + ldt.getMonth());
        System.out.println("月=" + ldt.getMonthValue());
        System.out.println("日=" + ldt.getDayOfMonth());
        System.out.println("时=" + ldt.getHour());
        System.out.println("分=" + ldt.getMinute());
        System.out.println("秒=" + ldt.getSecond());

        LocalDate now = LocalDate.now(); //可以获取年月日
        LocalTime now2 = LocalTime.now();//获取到时分秒

        /*
        第三代日期类更多方法
        1、LocalDateTime类
        2、MonthDay类:检查重复事件
        3、是否是闰年
        4、增加日期的某个部分
        5、使用 plus 方法测试增加时间的某个部分
        6、使用 minus 方法测试查看一年前和一年后的日期
        7、使用的时候查看 API 即可
     */
        //提供 plus 和 minus 方法可以对当前时间进行加或者减
        //看看890天后，是什么时候 把 年月日-时分秒
        LocalDateTime localDateTime = ldt.plusDays(890);
        System.out.println("890天后=" + dateTimeFormatter.format(localDateTime));

        //看看在 3456分钟前是什么时候，把 年月日-时分秒输出
        LocalDateTime localDateTime2 = ldt.minusMinutes(3456);
        System.out.println("3456分钟前 日期=" + dateTimeFormatter.format(localDateTime2));

    }
}

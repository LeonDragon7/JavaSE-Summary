package com.common.stringbuffer_;
/*
    String 和 StringBuffer 相互转换
    1、String ——> StringBuffer
        · 使用构造器
        · 使用的是 append 方法
    2、StringBuffer ——> String
        · 使用 StringBuffer 提供的 toString 方法
        · 使用构造器来搞定
 */
public class StringAndStringBuffer {
    public static void main(String[] args) {

        // String——>StringBuffer
        String str = "hello tom";
        //方式1 使用构造器
        //注意：返回的才是StringBuffer对象，对 str 本身没有影响
        StringBuffer stringBuffer = new StringBuffer(str);
        //方式2：使用的是append方法
        StringBuffer stringBuffer1 = new StringBuffer();
        stringBuffer1 = stringBuffer1.append(str);

        // StringBuffer ->String
        StringBuffer stringBuffer3 = new StringBuffer("timerring");
        //方式1：使用StringBuffer提供的 toString方法
        String s = stringBuffer3.toString();
        //方式2：使用构造器来搞定
        String s1 = new String(stringBuffer3);
    }
}

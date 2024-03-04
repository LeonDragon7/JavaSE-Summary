package com.grammar.operator;
/*
1、
    1、运算符
    运算符是一种特殊的符号，用以表示数据的运算、赋值和比较等。
    算术运算符
    赋值运算符
    比较运算符（关系运算符）
    逻辑运算符
    位运算符
    三元运算符

    2、算术运算符
    运算符                 运算
    +                     正号
    -                     负号
    +                     加
    -                     减
    *                     乘
    /                     除
    %                   取模（取余）
    ++                  自增(前):先运算后取值
                        自增(后):先取值后运算
    --                  自减(前):先运算后取值
                        自减(后):先取值后运算
    +                   字符串连接
    注：%:取余运算 结果的符号与被模数的符号相同

    3、赋值运算符
    符号：=
    1.当“=”两侧数据类型不一致时，可以使用自动类型转换或使用强制类型转换原则进行处理。
    2.支持连续赋值。
    扩展赋值运算符：+=，-=，*=，/=，%=

    4、比较运算符(关系运算符)
    运算符             运算
     ==              相等于
     !=              不等于
     <               小于
     >               大于
     <=              小于等于
     >=              大于等于
    instanceof       检查是否是类的对象

    比较运算符的结果都是boolean型，也就是要么是true，要么是false。
    比较运算符“==”不能误写成“=”。

    5、逻辑运算符
    &-逻辑与 |-逻辑或 !-逻辑非
    &&-短路与 ||-短路或 ^-逻辑异或
    说明：
    1.逻辑运算符操作的都是boolean类型的变量
    2.开发中，推荐使用 && 和 ||(效率高)

    6、位运算符
    运算符         运算
    <<            左移
    >>            右移
    >>>         无符号右移
     &            与运算
     |            或运算
     ^            异或运算
     ~            取反运算
     注意：无<<<
     位运算符的细节：
        <<  空位补0，被移除的高位丢弃，空缺位补0。
        >>  被移位的二进制最高位是0，右移后，空缺位补0:最高位是1，空缺位补1。
        案例：
        int a = 1 >> 2;1 => 00000001 => 00000000本质 1 / 2 / 2 = 0
        int c = 1 << 2;1 => 00000001 => 00000100本质 1 * 2 * 2 = 4
        >>> 被移位二进制最高位无论是0或者是1，空缺位都用0补。
        特别说明：没有<<<符号
        &(按位与)   二进制位进行&运算，只有1&1时结果是1，否则是0;
        |(按位或)   二进制位进行|运算，只有0|0时结果是0，否则是1;
        ^(按位异或)   相同二进制位进行^运算，结果是0: 1^1=0，0^0=0
            不相同二进制位^运算结果是1。1^0=1，0^1=1
        ~(按位取反)   正数取反，各二进制码按补码各位取反
            负数取反，各二进制码按补码各位取反

     7、三元运算符
     (条件表达式) ? 表达式1:表达式2;
        ① 当为true是，运算后的结果是表达式1;
        ② 当为false是，运算后的结果是表达式2;
        表达式1和表达式2定义前需同种类型(统一类型)
        三元运算符可以嵌套使用
        三元运算符与if-else的联系与区别：
        ① 三元运算符可简化if-else
        ② 三元运算符要求必须返回一个结果
        ③ if后的代码块可有多个语句
        ④ 能用if-else，但是不一定能用三元运算符
        ⑤ 如果程序既可以使用三元运算符，又可以使用if-else 结构，那么优先选择三元运算符。原因：简洁、执行效率高


 */
public class Operator {
    public static void main(String[] args) {
        //% 取模，取余
        //在 % 的本质 看一个公式 a % b = a - a / b * b
        //-10 % 3 = -10 - (-10) / 3 * 3
        System.out.println(10 % 3);//1
        System.out.println(-10 % 3);//-1
        System.out.println(10 % -3);//1
        System.out.println(-10 % -3);//-1

        //赋值运算符
        int n1 = 10;
        n1 +=(n1++) + (++n1);
        System.out.println(n1);//32

        //复合赋值运算符会进行类型转换
        byte j = 3;
        j += 2;//等价 b = (byte)(b + 2);
        j++;//等价 b = (byte)(b + 1);
        //不能写成 b = b + 2;会报错误：不兼容类型：从int转换到byte可能会有损失

        //比较运算符
        boolean b3 = false;

        if(b3 == true)
            System.out.println("结果为真");
        else
            System.out.println("结果为假");//输出为假

        if(b3 = true)
            System.out.println("结果为真");//输出为真
        else
            System.out.println("结果为假");

        //逻辑运算符
        //区分& 与 &&
        /*
        相同点1：& 与 && 的运算结果相同
        相同点2：当符号左边是true时，二者都会执行符号右边的运算
        不同点：当符号左边是false时，&继续执行符号右边的运算，&&不再执行符号右边的运算
         */
        boolean b1 = true;
        b1 = false;
        int num1 = 10;
        if(b1 & (num1++ > 0))
            System.out.println("我现在在北京");
        else
            System.out.println("我现在在南京");
        System.out.println("num1 = " + num1);//11

        boolean b2 = true;
        b2 = false;
        int num2 = 10;
        if(b2 && (num2++ > 0))
            System.out.println("我现在在北京");
        else
            System.out.println("我现在在南京");
        System.out.println("num2 = " + num2);//10

        //区分| 与 ||
        /*
        相同点1：| 与 || 的运算结果相同
        相同点2：当符号左边是false时，二者都会执行符号右边的运算
        不同点：当符号左边是true时，|继续执行符号右边的运算，||									  不再执行符号右边的运算
         */
        boolean b4 = false;
        b4 = true;
        int num3 = 10;
        if(b4 | (num3++ > 0))
            System.out.println("我现在在北京");
        else
            System.out.println("我现在在南京");
        System.out.println("num3 = " + num3);//11

        boolean b5 = false;
        b5 = true;
        int num4 = 10;
        if(b5 || (num4++ > 0))
            System.out.println("我现在在北京");
        else
            System.out.println("我现在在南京");
        System.out.println("num4 = " + num4);//10

        //逻辑异或
        //a ^ b:当a和b不同时，则结果为true，否则为false
        boolean b = (10 > 1) ^ (3 > 5);
        System.out.println("b = " + b);//true

        /*
        位运算
        位运算是直接对整数的二进制进行的运算
         */
        int i = 21;
        System.out.println("i << 2 :" + (i << 2));//84

        int m = 12;
        int n = 5;
        System.out.println("m & n :" + (m & n));//4
        System.out.println("m | n :" + (m | n));//13
        System.out.println("m ^ n :" + (m ^ n));//9

        int k = 6;
        System.out.println("~6 : " + ~k);//-7

        //三元运算符
        int m2 = 12;
        int n2 = 5;

        //表达式1和表达式2要为可以赋给接收变量的类型（或可以自动转换、或者强制转换）
        double num = m2 > n2 ? 2 : 1.0;
        System.out.println(num);//2.0

        String maxStr = m2 > n2 ? "m2大" : "n2大";
        System.out.println(maxStr);//m2大
        //优化
        String maxStr1 = m2 > n2 ? "m2大" : m2 == n2 ? "m2和n2相等" : "n2大";
        System.out.println(maxStr1);


    }
}

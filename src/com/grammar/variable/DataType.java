package com.grammar.variable;
/*
2、
    对于每一种数据都定义了明确的具体数据类型（强类型语言），在内存中分配了不同大小的内存空间。

    1、整型类型：byte、short、int、long
    Java各整型类型有固定的表数范围和字段长度，不受具体OS的影响，以保证java程序的可移植性。
    java的整型常量默认为int型，声明long型常量后加‘l’或‘L’ (不加也不会报错把它看成int类型，但是不能超出int类型的数值范围)。
    java程序中变量通常声明为int型，除非不足以表示较大的数，才使用long。
    注意：bit：计算机中的最小存储单位。byte：计算机中基本存储单位。
    注：整型常量，默认类型为int型。

    2、浮点类型：float \ double
    与整型类型类型，java浮点类型也有固定的表数范围和字段长度，不受具体操作系统的影响。
    浮点型常量有两种表示形式：
    十进制数形式：如：5.12 210.0f .512(必须有小数点)
    科学计数法形式如：5.12e2 512E2 100E-2
    float：单精度，尾数可以精确到7位有效数字。很多情况下，精度很难满足需求。
    double：双精度，精度是float的两倍，通常采用此类型。
    Java的浮点型常量默认为double型，声明float型常量，须后加‘f’或‘F’。
    注：浮点型常量，默认类型为double型。

    3、字符类型：char
    char型数据用来表示通常意义上“字符”(2字节)
    Java中的所有字符都使用Unicode编码，故一个字符可以存储一个字母，一个汉子，或其他书面语的一个字符。
    字符型变量的三种表现形式：
    字符常量是用单引号(‘’)括起来的单个字符。例如：char c1 = ‘a’;char c2 = ‘中’;char c3 = ‘9’;
    Java中还允许使用转义字符 ''来将其后的字符转变为特殊字符型常量。例如：char c3 = ‘\n’; // '\n’表示换行符
    直接使用Unicode值来表示字符型常量：如：\u000a表示 \n

    4、乱码的情况和字符集的说明
    4.1 了解：ASCII码
    在计算机内部，所有数据都使用二进制表示。每一个二进制位(bit)有0和1两种状态，因此8个二进制位就可以组合出256种状态，这被称为一个字节(byte)。一个字节一共可以用来表示256种不同的状态，每一个状态对应一个符号，就是256个符号，从0000000和11111111。
    ASCII码：上个世纪60年代，美国制定了一套字符编码，对英语字符与二进制位之间的关系，做了统一规定。这被称为ASCII码。ASCII码一共规定了128个字符的编码，比如：空格“SPACE”是32(二进制00100000)，大写的字母A是65(二进制01000001)。这
    128个符号(包括32个不能打印出来的控制符号)，只占用了一个字节的后面7位，最前面
    的1位统一规定为0。
    缺点：
    不能表示所有字符。
    相同的编码表示的字符不一样。

    4.2 了解：Unicode编码
    乱码：世界上存在着多种编码方式，同一个二进制数字可以被解释成不同的符号。因此，要想打开一个文本文件，就必须知道它的编码方式，否则用错误的编码方式解读，就会出现乱码。
    Unicode：一种编码，将世界上所有的符号都纳入其中。每一个符号都给予一个独一无二的编码，使用Unicode没有乱码的问题。
    Unicode的缺点：Unicode只规定了符号的二进制代码，却没有规定这个二进制代码应该如何存储：无法区别Unicode和ASCII：计算机无法区分三个字节表示一个符号还是分别表示三个符号。另外，我们知道，英文字母只用一个字节表示就够了，如果Unicode统一规定，每个符号用三个或四个字节表示，那么每个英文字母前都必然有二到三个字节是0，这对于存储空间来说是极大的浪费。

    4.3 了解：UTF-8
    UTF-8是在互联网上使用最广的一种Unicode的实现方式。
    UTF-8是一种变长的编码方式。它可以使用1-6个字节表示一个符号 ，根据不同的符号而变化字节长度。
    UTF-8的编码规则：
    对于单字节的UTF-8编码，该字节的最高位为0，其余7位用来对字符进行编码（等同于ASCII码）。
    对于多字节的UTF-8编码，如果编码包含n个字节，那么第一个字节的前n位为1，第一个字节的第n+1位为0，该字节的剩余各位用来对字符进行编码。在第一个字节之后的所有的字节，都是最高两位为“10”，其余6位用来对字符进行编码。

    5、boolean类型
    只能取两个值之一：true、false
    常常在条件判断、循环结构中使用

    6、基本数据类型转换
    6.1 自动类型转换：容量小的类型自动转换为容量大的数据类型。数据类型按容量大小排序为：
    byte、char、short->int->long->float->double
    有很多类型的数据混合运算时，系统首先自动将所有数据转换成容量最大的那种数据类型，然后再进行计算。
    byte，short，char之间不会相互转换，他们三者在计算时首先转换为int类型。
    boolean类型不能与其它数据类型运算。
    当把任何基本数据类型的值和字符串(String)进行连接运算时(+),基本数据类型的值将自动转换为字符串(String)类型。

    6.2 强制类型转换
    自动类型转换的逆过程，将容量大的数据类型转换为容量小的数据类型。使用时要加上强制转换符：(),但可能造成精度降低或溢出，格外要注意。
    通常，字符串不能直接转换为基本类型，但通过基本类型对应的包装类则可以实现把字符串转换成基本类型。
    如：String a = “43”;int i = Integer.parseInt(a);
    boolean类型不可以转化为其他数据类型。
    int n1 = (int)1.9;精度损失
    int n2 = 2000;byte b1 = (byte)n2;数据溢出

    说明：此时的容量大小指的是表示数的范围的大和小，不是内存空间(占多少字节)。例如：float容量要大于long的容量。

    7、字符串类型：String
    String不是基本数据类型，属于引用数据类型
    使用方式与基本数据类型一致。例如：String str = “abcd”;
    一个字符串可以串接另一个字符串，也可以直接串接其他类型的数据。例如：
    str = str + “xyz”;
    int n = 100;
    str = str + n;


 */
public class DataType {
    public static void main(String[] args) {
//浮点数细节
        //浮点数使用陷阱：2.7和8.1 / 3 比较
        double num1 = 2.7;
        double num2 = 8.1 / 3;
        System.out.println(num1);//2.7
        System.out.println(num2);//接近2.7的一个数，而不是2.7
        //得到一个重要使用点：当我们对运算结果是小数的进行相等判断时，要小心！！
        //应该是以两个数的差值的绝对值，在某个精度范围判断

        //输出不相等
        if(num1 == num2){
            System.out.println("相等");
        }
        else{
            System.out.println("不相等");
        }
        //解决：
        if(Math.abs(num1 - num2) < 0.000001){//Math.abs(num1 - num2):计算num1和num2的差值的绝对值
            System.out.println("差值非常小，到我的规定精度，认为相等...");
        }
        //细节：如果是直接查询得到的小数或者直接赋值，是可以判断相等

        //强制类型转化的细节
        //强转符号只针对于最近的操作数有效，往往会使用小括号提升优先级
        //int x = (int)10 * 3.5 + 6 * 1.5;编译错误：double -> int
        int y = (int)(10 * 3.5 + 6 * 1.5);//(int)44.0 -> 44
        //char类型可以保存int的常量值，但不能保存int的变量值，需要强转
        int m = 100;
        //char c2 = m;错误
        char c3 = (char)m;//正确
    }
}

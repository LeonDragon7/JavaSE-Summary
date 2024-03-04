package com.grammar.flow;

/*
    switch(表达式){
    case 常量1:
        语句1;
        //break;
    case 常量2:
        语句2;
        //break;
    .......
    default:
        语句1;
        //break;
    }
   说明：
   ① 根据switch表达式的值，依次匹配各个case中的常量，一旦匹配成功，则进入相应case结构中，调用其执行语句。
   当调用完执行语句以后，则仍然继续向下执行其他case结构中的执行语句，直到遇到break关键字或default。
   ② break：可以使用在switch-case结构中，表示一旦执行到此关键字，就跳出switch-case结构（可选）
   ③ switch结构中的表达式，只能是如下的6种数据类型之一：byte、short、char、int、枚举类型（JDK5.0新增）、String类型（JDK7.0新增）
   ④ case之后只能声明常量。不能声明范围。
   ⑤ default：相当于if-else结构中的else，位置灵活。（可选）
 */
public class SwitchCase {
    public static void main(String[] args) {
        int num = 2;
        switch (num){
            case 0:
                System.out.println("zero");
            case 1:
                System.out.println("one");
            case 2:
                System.out.println("two");
            case 3:
                System.out.println("three");
                break;
            default:
                System.out.println("other");
        }
    }
}

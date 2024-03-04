package com.grammar.flow;

public class Select {
    /*
    1.凡是可以使用switch-case的结构，都可以转换为if-else。反之，不成立。
    2.我们写分支结构时，当发现既可以使用switch-case，（同时，switch中表
    达式的取值情况不太多），又可以使用if-else时，我们优先选择使用switch-case。
    原因：switch-case执行效稍高。
     */
    /*
		switch和if的比较
			1.如果判断的具体数值不多，而且符合byte、short、int、char、enum[枚举]、String
			这6种类型。虽然两个语句都可以使用，建议使用switch语句。
			2.其他情况：对区间判断，对结果为boolean类型判断，使用if，if的使用范围更广

	*/
    public static void main(String[] args) {

    }
}
package com.grammar.operator.test;

public class OperatorTest02 {
    public static void main(String[] args) {
        //1.假如还有59天放假，问:合xx个星期零xx天
        int toHoliday = 59;
        int week = 59 / 7;
        int day = 59 % 7;
        System.out.println("假如还有59天放假，合"+ week +"个星期零"+ day +"天");

		/*2.定义一个变量保存华氏温度，华氏温度转换为摄氏温度的公式为：5 / 9 *(华氏温度 - 100),
			请求出华氏温度对应的摄氏温度。[234.5]
		*/
        double fahrenheit = 234.5;
        double celsius = 5 / 9.0 * (fahrenheit - 100);
        System.out.println("摄氏温度：" + fahrenheit + ",对应的摄氏温度为：" + celsius);
    }
}

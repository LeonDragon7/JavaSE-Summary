package com.stream;


import org.junit.Test;

import java.util.List;
import java.util.stream.Stream;

/**
 * 测试Stream的中间操作
 */
public class StreamAPI02 {
    //1-筛选与切片
    @Test
    public void test(){
        List<Employee> list = EmployeeData.getEmployees();
//        filter(Predicate p)——接收 Lambda ， 从流中排除某些元素。
        Stream<Employee> stream = list.stream();
        //练习：查询员工表中薪资大于7000的员工信息
        stream.filter(e -> e.getSalary() > 7000).forEach(System.out::println);

        System.out.println("+++++++++++++++++++++++");
//        limit(n)——截断流，使其元素不超过给定数量。
        list.stream().limit(3).forEach(System.out::println);
        System.out.println("+++++++++++++++++++++++");

//        skip(n) —— 跳过元素，返回一个扔掉了前 n 个元素的流。若流中元素不足 n 个，则返回一个空流。与 limit(n) 互补
        list.stream().skip(3).forEach(System.out::println);

        System.out.println("+++++++++++++++++++++++");
//        distinct()——筛选，通过流所生成元素的 hashCode() 和 equals() 去除重复元素

        list.add(new Employee(1013,"李飞",42,8500));
        list.add(new Employee(1013,"李飞",41,8200));
        list.add(new Employee(1013,"李飞",28,6000));
        list.add(new Employee(1013,"李飞",39,7800));
        list.add(new Employee(1013,"李飞",40,8000));

//        System.out.println(list);

        list.stream().distinct().forEach(System.out::println);
    }
}

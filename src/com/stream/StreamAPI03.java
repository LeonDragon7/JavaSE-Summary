package com.stream;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 测试Stream的中间操作
 */
public class StreamAPI03 {
    //2-映射
    @Test
    public void test2(){
//        map(Function f)——接收一个函数作为参数，将元素转换成其他形式或提取信息，该函数会被应用到每个元素上，并将其映射成一个新的元素。
        List<String> list = Arrays.asList("aa", "bb", "cc", "dd");
        list.stream().map(str -> str.toUpperCase()).forEach(System.out::println);

//        练习1：获取员工姓名长度大于3的员工的姓名。
        List<Employee> employees = EmployeeData.getEmployees();
        Stream<String> namesStream = employees.stream().map(Employee::getName);
        namesStream.filter(name -> name.length() > 3).forEach(System.out::println);
        System.out.println();

        //练习2：
        Stream<Stream<Character>> streamStream = list.stream().map(StreamAPI03::fromStringToStream);

        streamStream.forEach(s ->{
            s.forEach(System.out::println);
        });
        System.out.println("++++++++++++++++++++++");
//        flatMap(Function f)——接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流。
        Stream<Character> characterStream = list.stream().flatMap(StreamAPI03::fromStringToStream);

        characterStream.forEach(System.out::println);
    }

    //将字符串中的多个字符构成的集合转换为对应的Stream的实例
    public static Stream<Character> fromStringToStream(String str){//aa
        ArrayList<Character> list = new ArrayList<>();
        for(Character c : str.toCharArray()){
            list.add(c);
        }
        return list.stream();
    }

    @Test
    public void test3(){
        ArrayList list1 = new ArrayList();
        list1.add(25);
        list1.add(33);
        list1.add(14);

        ArrayList list2 = new ArrayList();
        list2.add(51);
        list2.add(23);
        list2.add(61);

//        list1.add(list2);//相当于map
        list1.addAll(list2);//相当于flatmap
        System.out.println(list1);
    }
}

package com.lambda;



import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * java内置的4大函数式接口
 *
 * 1.消费型接口 Consumer<T>  void accept(T t)
 * 2.供给型接口 Supplier<T>  T get()
 * 3.函数型接口 Function<T,R>    R apply(T t)
 * 4.断定型接口 Predicate<T>     boolean test(T t)
 */
public class Lambda03 {
    @Test
    public void test1(){
        happyTime(500, new Consumer <Double>() {
            @Override
            public void accept(Double aDouble) {
                System.out.println("学习太累了，去天上人间买了瓶矿泉水，价格为"+aDouble);
            }
        });

        System.out.println("*********************");
        happyTime(400,money -> {
            System.out.println("学习太累了，去天上人间买了瓶矿泉水，价格为"+money);
        });
    }

    public void happyTime(double money,Consumer<Double> consumer){
        consumer.accept(money);
    }

    @Test
    public void test2(){
        List <String> list = Arrays.asList("北京", "南京", "天津", "东京", "吴京", "普京", "牛津");

        List <String> filterString1 = filterString(list, new Predicate <String>() {
            @Override
            public boolean test(String s) {
                return s.contains("京");
            }
        });
        System.out.println(filterString1);

        System.out.println("*****************************");

        List<String> filterString = filterString(list, s -> s.contains("京"));
        System.out.println(filterString);
    }

    //根据给定的规则，过滤集合中的字符串。此规则由Predicate的方法决定
    public List <String> filterString(List<String> list, Predicate<String> pre){
        List <String> filterList = new ArrayList<>();

        for (String s : list) {
            if(pre.test(s)){
                filterList.add(s);
            }
        }

        return filterList;
    }
}

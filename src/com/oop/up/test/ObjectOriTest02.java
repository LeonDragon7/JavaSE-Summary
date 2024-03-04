package com.oop.up.test;

public class ObjectOriTest02 {
    public static void main(String[] args) {
        /*
        2.编写类A02，定义方法find，实现查找某字符串是否在数组中，并返回索引，
        如果找不到返回-1
         */
        String[] arr = {"张三","李四","王五","老六"};
        A02 a02 = new A02();
        int index = a02.find("王五",arr);
        if(index != -1){
            System.out.println("找到了，index = " + index);
        }else {
            System.out.println("没找到");
        }
    }
}
class A02{
    public Integer find(String findStr,String[] strs){
        if (strs != null && strs.length > 0) {
            for (int i = 0; i < strs.length; i++) {
                if (findStr.equals(strs[i])) {
                    return i;
                }
            }
            return -1;
        }else{
            return null;
        }
    }
}

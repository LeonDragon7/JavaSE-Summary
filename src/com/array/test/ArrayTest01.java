package com.array.test;

public class ArrayTest01 {
    public static void main(String[] args) {
        /*
         1.创建一个char类型的26个元素的数组，分别放置'A'-'Z'。使用for循环访问
         所有元素并打印出来。提示：char类型数据运算'A' + 1->'B'
         */
        char letters[] = new char[26];
        for(int i = 0;i < letters.length;i++){
            letters[i] = (char)('A' + i);//'A' + i 是int类型，需要强制转换
        }
        for(int i = 0;i < letters.length;i++){
            System.out.print(letters[i] + " ");
        }
    }
}

package com.common.enum_;

public class EnumTest {
    public static void main(String[] args) {
        Gender boy1 = Gender.BOY;
        Gender boy2 = Gender.BOY;
        //本质就是调用Gender的父类Enum的toString()
        /*
        Enum的toString():
        public String toString(){
            return name;
        }
         */
        System.out.println(boy1);//输出BOY
        System.out.println(boy2 == boy1);
    }
}
enum Gender{
    BOY,GIRL;
}

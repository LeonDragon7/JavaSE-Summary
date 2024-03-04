package com.oop.up.recursion.test;
/*
    方法递归调用
    汉诺塔
    汉诺塔(又称河内塔)问题是源于印度一个古老传说的益智玩具。大梵天创造世界的时候做了三根金刚石柱子，
    在一根柱子上从下往上按照大小循序摞着64片圆盘。大梵天命令婆罗门把圆盘从下面开始按照大小循序重新
    摆放在另一根柱子上。并且规定，从小圆盘上不能放大圆盘，在三根柱子之间一次只能移动一个圆盘。

    假如每秒钟移动一次，共需要多长时间呢？移完这些金片需要5845.54亿年以上，太阳系的预期寿命据说也
    就是数百亿年。真的过了5845.54亿年，地球上的一切生命，连同梵塔、庙宇等，都早已飞灰烟灭了。
 */
public class RecursionTowerOfHanoi {
    public static void main(String[] args) {
        TowerOfHanoi tower = new TowerOfHanoi();
        tower.move(5,'A','B','C');
    }
}
class TowerOfHanoi{
    //num：表示盘子数，a、b、c：表示A塔、B塔、C塔
    public void move(int num,char a,char b,char c){
        //如果只有一个盘 num = 1
        if(num == 1){
            System.out.println(a + "-->" + c);
        }else{
            //如果有多个盘，可以看成两个，最下面的(num)和上面的所有(num - 1)
            //(1) 先移动上面的所有盘到b，借助c
            move(num - 1,a,c,b);
            //(2) 将最下面的这个盘，移动到c
            System.out.println(a + "-->" + c);
            //(3) 再把b塔的所有盘，移动到c，借助a
            move(num - 1,b,a,c);
        }
    }
}
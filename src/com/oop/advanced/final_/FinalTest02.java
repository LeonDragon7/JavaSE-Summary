package com.oop.advanced.final_;

public class FinalTest02 {
    public int addOne(final int x){
        //++x;错误，原因是不能修改final的值
        return x + 1;//正确，x没有发生变化
    }
}

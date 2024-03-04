package com.oop.up.test;

public class MethodTest02 {
    public static void main(String[] args) {
        /*
        2、根据行、列、字符打印，对应行数和列数的字符，比如：行：4，列：4，字符
        #，则打印相应的效果
         */
        BB bb = new BB();
        bb.printChar(4,4,'#');
    }
}
class BB{
    public void printChar(int row,int col,char c){
        for(int i = 0;i < row;i++){
            for(int j = 0;j < col;j++){
                System.out.print(c);
            }
            System.out.println();
        }
    }
}
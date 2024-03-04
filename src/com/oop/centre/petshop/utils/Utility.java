package com.oop.centre.petshop.utils;

import java.util.Scanner;

public class Utility {
    private static Scanner scanner = new Scanner(System.in);
    /**
     * 读取键盘输入的一个字符
     * @return 一个字符
     */
    public static char readChar(){
        String str = readKeyBoard(1, false);
        return str.charAt(0);
    }

    /**
     * 读取键盘输入的浮点型，长度小于等于2
     * @return 浮点数
     */
    public static int readInt(){
        int n;
        for (; ; ){
            String str = readKeyBoard(2, false);
            try {
                n = Integer.parseInt(str);
                break;
            } catch (NumberFormatException e) {
                System.out.println("你输入的数字有误！");
            }
        }
        return n;
    }


    /**
     * 读取键盘输入的确认选项，Y或N
     * 将小的功能，封装到一个方法中.
     * @return Y或N
     */
    public static char readConfirmSelection(){
        System.out.println("请输入你的选择(Y/N)");
        char n;
        for (; ; ){
            String str = readKeyBoard(1, false).toUpperCase();
            n = str.charAt(0);
            if(n == 'Y' || n == 'N'){
                break;
            }else {
                System.out.println("选择错误，请重新输入！");
            }
        }
        return n;
    }

    /**
     * 读取键盘输入的浮点型，长度小于等于10
     * @return 浮点数
     */

    public static double readDouble(){
        double n;
        for (; ; ){
            String str = readKeyBoard(10, false);
            try {
                n = Double.parseDouble(str);
                break;
            } catch (NumberFormatException e) {
                System.out.println("你输入的数字有误，请重新输入！");
            }
        }
        return n;
    }

    /**
     * 读取键盘输入的指定长度的字符串
     * @param limit 限制的长度
     * @return 指定长度的字符串
     */
    public static String readString(int limit){
        return readKeyBoard(limit,false);
    }

    /**
     * 读取一个字符串
     * @param limit 读取的长度
     * @param blankReturn 如果为true，表示 可以读空字符串
     *                    如果为false，表示 不能读空字符串
     *
     * 如果输入为空，或者输入大于或小于limit的长度，就会提示重新输入。
     */
    private static String readKeyBoard(int limit,boolean blankReturn){
        String line = " ";

        while (scanner.hasNext()) {
            line =  scanner.nextLine();
            if(line.length() == 0){
                if(blankReturn){
                   return line;
                }else {
                    continue;
                }
            }
            if(line.length() < 1 || line.length() > limit){
                System.out.println("输入的值大于或小于" + limit + "的长度,请重新输入");
                continue;
            }
            break;
        }
        return line;
    }
}

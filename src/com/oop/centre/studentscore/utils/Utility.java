package com.oop.centre.studentscore.utils;

import java.util.Scanner;

//工具类
public class Utility {
    private static Scanner scanner = new Scanner(System.in);

    /**
     * 读取键盘输入的一个字符
     * @return 一个字符
     */
    public static char readChar(){
        String str = readKeyBoard(1,false);
        return str.charAt(0);
    }

    /**
     * 读取键盘输入的整形，长度小于等于10
     * @return 浮点数
     */
    public static int readInt(){
        int n;
        for (; ; ){
            String str = readKeyBoard(10,false);
            try {
                n = Integer.parseInt(str);
                break;
            } catch (NullPointerException e) {
                System.out.print("数字输入错误，请重新输入：");
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
            String str = readKeyBoard(10,false);
            try {
                n = Double.parseDouble(str);
                break;
            } catch (NullPointerException e) {
                System.out.print("数字输入错误，请重新输入：");
            }
        }
        return n;
    }

    /**
     * 读取键盘输入的指定长度的字符串或默认值，如果直接回车，返回默认值，否则返回字符串
     * @param limit 限制的长度
     * @param defaultValue 指定的默认值
     * @return 指定长度的字符串
     */
    public static double readDouble(int limit,double defaultValue){
        double n;
        String str = readKeyBoard(limit,true);
        n = Double.parseDouble(str);
        return n == 0 ? defaultValue : n;
    }


    /**
     * 读取键盘输入的指定长度的字符串或默认值，如果直接回车，返回默认值，否则返回字符串
     * @param limit 限制的长度
     * @param defaultValue 指定的默认值
     * @return 指定长度的字符串
     */
    public static String readString(int limit,String defaultValue){
        String str = readKeyBoard(limit,true);
        return str.equals("") ? defaultValue : str;
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
     * 读取键盘输入的确认选项，Y或N
     * 将小的功能，封装到一个方法中.
     * @return Y或N
     */
    public static char readConfirmSelection(){
        System.out.println("请输入你的选择(Y/N)");
        char c;
        for (; ; ){
            String str = readKeyBoard(1,false).toUpperCase();
            c = str.charAt(0);
            if(c == 'Y' || c == 'N'){
                break;
            }else {
                System.out.println("选择错误，请重新输入！");
            }
        }
        return c;
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
        String line = "";

        while(scanner.hasNextLine()){
            line = scanner.nextLine();
            if(line.length() == 0){
                if(blankReturn)
                    return line;
                else
                    continue;
            }
            if(line.length() < 1 || line.length() > limit){
                System.out.print("输入长度（不能大于或小于" + limit + "）错误，请重新输入：");
                continue;
            }
            break;
        }
        return line;
    }
}

package com.qq.utils;
/**
 工具类的作用:
 处理各种情况的用户输入，并且能够按照程序员的需求，得到用户的控制台输入。
 */

import java.util.Scanner;
@SuppressWarnings({"all"})
public class Utility {
    //静态属性
    private static Scanner scanner = new Scanner(System.in);

    /**
     * 功能：读取键盘输入的一个菜单选项，值：1-5的范围
     * @return 1-5
     */
    public static char readMenuSelection(){
        char c;
        for (; ; ){
            String s = readKeyBoard(1, false);//包含一个字符的字符串
            c = s.charAt(0);//将字符串转换成字符char类型
            if(c != '1' && c != '2' && c != '3' &&
                    c != '4' && c != '5') System.out.print("选择错误，请重新输入：");
            else break;
        }
        return c;
    }

    /**
     * 功能：读取键盘输入的一个字符
     * @return 一个字符
     */
    public static char readChar(){
        String s = readKeyBoard(1,false);
        return s.charAt(0);
    }

    /**
     * 功能：读取键盘输入的一个字符，如果直接按回车，则返回指定的默认值；否则返回输入的那个字符
     * @param defaultValue 指定的默认值
     * @return 默认值或输入的字符
     */
    public  static char readChar(char defaultValue){
        String s = readKeyBoard(1, true);//要么是空字符串，要么是一个字符
        return (s.length() == 0) ? defaultValue : s.charAt(0);
    }

    /**
     * 功能：读取键盘输入的整型，长度小于10位
     * @return 整数
     */
    public static int readInt(){
        int i;
        for (; ; ){
            String s = readKeyBoard(10, false);//一个整数，长度<=10位
            try {
                i = Integer.parseInt(s);//将字符串转换成整数
                break;
            } catch (NumberFormatException e) {
                System.out.print("数字输入错误，请重新输入：");
            }
        }
        return i;
    }

    /**
     * 功能：读取键盘输入的 整数或默认值，如果直接回车，则返回默认值，否则返回输入的整数
     * @param defaultValue 指定的默认值
     * @return 整数或默认值
     */
    public static int readInt(int defaultValue){
        int i;
        for (; ; ){
            String s = readKeyBoard(10,true);
            if(s.equals("")){
                return defaultValue;
            }
            try {
                i = Integer.parseInt(s);
                break;
            } catch (NumberFormatException e) {
                System.out.print("数字输入错误，请重新输入：");
            }
        }
        return i;
    }

    /**
     * 功能：读取键盘输入的指定长度的字符串
     * @param limit 限制的长度
     * @return 指定长度的字符串
     */

    public static String readString(int limit) {
        return readKeyBoard(limit, false);
    }

    /**
     * 功能：读取键盘输入的指定长度的字符串或默认值，如果直接回车，返回默认值，否则返回字符串
     * @param limit 限制的长度
     * @param defaultValue 指定的默认值
     * @return 指定长度的字符串
     */

    public static String readString(int limit, String defaultValue) {
        String str = readKeyBoard(limit, true);
        return str.equals("")? defaultValue : str;
    }

    /**
     * 功能：读取键盘输入的确认选项，Y或N
     * 将小的功能，封装到一个方法中.
     * Y或N
     * @return
     */
    public static char readConfirmSelection(){
        System.out.println("请输入你的选择(Y/N): 请小心选择");
        char c;
        for (; ; ){
            String s = readKeyBoard(1,false).toUpperCase();
            c = s.charAt(0);
            if(c == 'Y' || c == 'N'){
                break;
            }else{
                System.out.print("选择错误，请重新输入：");
            }
        }
        return c;
    }

    /**
     * 功能：读取一个字符串
     * @param limit 读取的长度
     * @param blankReturn 如果为true，表示可以读空字符串
     *                    如果false表示，不能读空字符串
     *
     * 如果输入为空，或者输入大于limit的长度，就会提示重新输入
     * @return
     */
    private static String readKeyBoard(int limit,boolean blankReturn){
        //定义字符串
        String line = "";
        //scanner.hasNextLine() 判断有没有下一行
        while (scanner.hasNextLine()){
            line = scanner.nextLine();//读取这一行

            //如果line.length=0, 即用户没有输入任何内容，直接回车
            if(line.length() == 0){
                if(blankReturn) return line;//如果blankReturn=true,可以返回空串
                else continue;//如果blankReturn=false,不接受空串，必须输入内容
            }

            //如果用户输入的内容大于了 limit，就提示重写输入
            //如果用户如的内容 >0 <= limit ,我就接受
            if(line.length() < 1 || line.length() > limit){
                System.out.print("输入长度（不能大于" + limit + "）错误，请重新输入：");
                continue;
            }
            break;
        }
        return line;
    }
}

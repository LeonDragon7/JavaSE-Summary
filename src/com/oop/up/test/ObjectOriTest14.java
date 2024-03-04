package com.oop.up.test;

import java.util.Random;
import java.util.Scanner;

public class ObjectOriTest14 {
    public static void main(String[] args) {
        /*
        14.扩展题
        有个人Tom设计他的成员变量、成员方法，可以电脑猜拳。
        电脑每次都会随机生成0,1,2
        0表示石头 1表示剪刀 2表示布
        并要可以显示Tom的输赢次数（清单）
         */
        //创建一个玩家对象
        Tom tom = new Tom();
        //用来记录最后输赢的次数
        int isWinCount = 0;

        //创建一个二维数组，用来接收局数，Tom出拳情况以及电脑出拳情况
        int[][] arr1 = new int[3][3];
        int j = 0;

        //创建一个一维数组，用来接收输赢情况
        String[] arr2 = new String[3];

        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {//比赛3次
            //获取玩家出的拳
            System.out.println("请输入你要出的拳（0-拳头，1-剪刀，2-布）：");
            int num = scanner.nextInt();
            tom.setTomGuessNum(num);
            int tomGuess = tom.getTomGuessNum();
            arr1[i][j + 1] = tomGuess;

            //获取电脑出的拳
            int comGuess = tom.computerNum();
            arr1[i][j + 2] = comGuess;

            //将玩家猜的拳与电脑做比较
            String isWin = tom.vsComputer();
            arr2[i] = isWin;
            arr1[i][j] = tom.count;

            //对每一局的情况进行输出
            System.out.println("=======================================");
            System.out.println("局数\t\t玩家的出拳\t电脑的出拳\t输赢情况");
            System.out.println(tom.count + "\t\t" + tomGuess + "\t\t\t" + comGuess + "\t\t\t" + isWin);
            System.out.println("=======================================");
            System.out.println("\n\n");
            isWinCount = tom.winCount(isWin);
        }

        //对游戏的最终结果进行输出
        System.out.println("局数\t\t玩家的出拳\t电脑的出拳\t\t输赢情况");
        for (int a = 0; a < arr1.length; a++) {
            for (int b = 0; b < arr1[a].length; b++) {
                System.out.print(arr1[a][b] + "\t\t\t");
            }
            System.out.print(arr2[a]);
            System.out.println();
        }
        System.out.println("你赢了" + isWinCount + "次");
        /*
        Tom t1 = new Tom();
        System.out.println("赢\t\t平\t\t输");
        int random = 0;
        do {
            random = (int)(Math.random() * 2 + 0.8);
            t1.printWinAndLos(random);
            System.out.println(t1.wincount + "\t\t" + t1.flatcount+ "\t\t" + t1.loscount);
        }while (true);
         */
    }
}

class Tom {
    //玩家出拳的类型
    int tomGuessNum;//0,1,2
    //电脑出拳的类型
    int comGuessNum;//0,1,2
    //玩家赢的次数
    int winCountNum;
    //比赛的次数
    int count = 1;//一共比赛3次


    public void showInfo() {
    }

    /**
     * 电脑随机生成猜拳的数字的方法
     *
     * @return
     */
    public int computerNum() {
        Random random = new Random();
        comGuessNum = random.nextInt(3);//方法 返回0-2的随机数
        //System.out.println(comGuessNum);
        return comGuessNum;
    }

    /**
     * 设置玩家猜拳的数字的方法
     *
     * @param tomGuessNum
     */
    public void setTomGuessNum(int tomGuessNum) {
        if (tomGuessNum > 2 || tomGuessNum < 0) {
            //抛出一个异常
            throw new IllegalArgumentException("数字输入错误");
        }
        this.tomGuessNum = tomGuessNum;
    }

    public int getTomGuessNum() {
        return tomGuessNum;
    }

    /**
     * 比较猜拳的结果
     *
     * @return 玩家赢返回true，否则返回false
     */
    public String vsComputer() {
        if (tomGuessNum == 0 && comGuessNum == 1) {
            return "你赢了";
        } else if (tomGuessNum == 1 && comGuessNum == 2) {
            return "你赢了";
        } else if (tomGuessNum == 2 && comGuessNum == 0) {
            return "你赢了";
        } else if (tomGuessNum == comGuessNum) {
            return "平手";
        } else {
            return "你输了";
        }
    }

    /**
     * 记录玩家赢的次数
     *
     * @return
     */
    public int winCount(String s) {
        count++;//控制玩的次数
        if (s.equals("你赢了")) { //统计赢的次数
            winCountNum++;
        }
        return winCountNum;
    }
}
/*
class Tom{
    int flatcount = 0;
    int wincount = 0;
    int loscount = 0;
    public void printWinAndLos(int ran){
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        if((i == 0 && ran == 1) || (i == 1 && ran == 2) || (i == 2 && ran == 0)){
            wincount++;
        }else if(i == ran){
            flatcount++;
        } else{
            loscount++;
        }
    }
}
 */
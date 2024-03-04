package com.tank.game;

import java.io.*;
import java.util.Vector;

/**
 * 该类用于记录相关信息的和文件交互的
 */
public class Recorder {
    //定义变量，记录我方击毁敌人坦克数
    private static int allEnemyTankNum = 0;
    //定义IO对象，准备写数据到文件中
    private static BufferedWriter bw = null;
    //定义IO对象，文件数据到程序中
    private static BufferedReader br = null;
    private static String recordFile = "d:\\BackEnd\\Java\\JavaSE\\Project\\Basic\\src\\myRecord.txt";
    //定义Vector，指向MyPanel对象的 敌人坦克Vector
    private static Vector<EnemyTank> enemyTanks = null;
    //定义一个Node的Vector，用于保存敌人的信息node
    private static  Vector<Node> nodes = new Vector<>();

    //增加一个方法，当游戏退出时，我们将allEnemyTankNum保存到recordFile
    //对keepRecord进行升级，保存敌人坦克的坐标和方向
    public static void keepRecord(){
        try {
            bw = new BufferedWriter(new FileWriter(recordFile));
            bw.write(allEnemyTankNum + "\r\n");//"\r\n"：换行 或者bw.newLine();
            //遍历敌人坦克的Vector，然后根据情况保存即可
            //OOP，定义一个属性，然后通过setXxx得到，敌人坦克的Vector
            for (int i = 0; i < enemyTanks.size(); i++) {
                //取出敌人坦克
                EnemyTank enemyTank = enemyTanks.get(i);
                if(enemyTank.isLive){
                    //保存该enemyTank的信息
                    String record = enemyTank.getX() + " " + enemyTank.getY() + " " + enemyTank.getDirect();
                    //写入到文件
                    bw.write(record + "\r\n");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if(bw != null){
                    bw.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    //增加一个方法，用于读取recordFile文件，恢复相关信息
    //该方法，再继续上局的时候调用即可
    public static Vector<Node> getNodesAndEnemyTankRecord(){
        try {
            br = new BufferedReader(new FileReader(recordFile));
            allEnemyTankNum = Integer.parseInt(br.readLine());
            //循环读取文件，生成nodes集合
            String line = "";
            while ((line = br.readLine()) != null){
                String[] xyd = line.split(" ");
                Node node = new Node(Integer.parseInt(xyd[0]), Integer.parseInt(xyd[1]),
                        Integer.parseInt(xyd[2]));
                nodes.add(node);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(br != null){
                    br.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return nodes;
    }

    //返回记录文件的路径
    public static String getRecordFile() {
        return recordFile;
    }

    public static void setEnemyTanks(Vector<EnemyTank> enemyTanks) {
        Recorder.enemyTanks = enemyTanks;
    }

    public static int getAllEnemyTankNum() {
        return allEnemyTankNum;
    }

    public static void setAllEnemyTankNum(int allEnemyTankNum) {
        Recorder.allEnemyTankNum = allEnemyTankNum;
    }

    //当我方坦克击毁一个敌人坦克，就应当allEnemyTankNum++
    public static void addAllEnemyTankNum(){
        allEnemyTankNum++;
    }


}
/*
    增加功能3
    1、防止敌人坦克重叠运动
    2、记录玩家的总成绩(累积击毁敌方坦克数)，存盘退出【io流】
    3、记泉退出游戏时敌人坦克坐标/方向,存盘退出【io流】
    4、玩游戏时，可以选择是开新游戏还是继续上局游戏
 */
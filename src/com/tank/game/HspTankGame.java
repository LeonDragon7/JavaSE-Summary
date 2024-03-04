package com.tank.game;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Scanner;

public class HspTankGame extends JFrame {

    //定义MyPanel
    MyPanel mp = null;
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        new HspTankGame();
    }

    public HspTankGame(){
        System.out.println("请输入选择 1：新游戏 2：继续上局");
        String key = sc.next();
        //初始化面板
        mp = new MyPanel(key);
        //把面板放入到窗口(画框)
        this.add(mp);
        //设置窗口的大小
        this.setSize(1300, 950);
        this.addKeyListener(mp);
        //当点击窗口的小×，程序完全退出.
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //将mp放入到Thread，并启动
        new Thread(mp).start();
        this.setVisible(true);//可以显示

        //在JFrame中增加相应关闭窗口的处理
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Recorder.keepRecord();
                System.exit(0);
            }
        });
    }
}

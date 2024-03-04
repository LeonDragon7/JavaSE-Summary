package com.tank.event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class BallMove extends JFrame{
    //定义一个面板
    private MyPanel mp = null;

    public static void main(String[] args) {
        new BallMove();
    }

    public BallMove() {
        mp = new MyPanel();
        this.add(mp);
        this.setSize(400, 300);
        //窗口JFrame对象可以监听键盘事件，即可以监听到面板发生的键盘事件
        this.addKeyListener(mp);//接口的引用可以实现该接口的对象
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);//可以显示
    }
}
//KeyListener:监听器，可以监听键盘事件
class MyPanel extends JPanel implements KeyListener {

    //为了让小球可以移动，把他的左上角的坐标设置变量
    int x = 10;
    int y = 10;
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillOval(x,y,20,20);
    }

    //有字符输出时，该方法就会触发
    @Override
    public void keyTyped(KeyEvent e) {

    }

    //当某个键按下，该方法会触发
    @Override
    public void keyPressed(KeyEvent e) {
        //System.out.println((char) e.getKeyCode() + "被按下...");

        //根据用户按下的不同键，来处理小球的移动（上下左右的键）
        if(e.getKeyCode() == KeyEvent.VK_DOWN){//KeyEvent.VK_DOWN：就是向下的箭头对应的code
            y++;
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            y--;
        }else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            x--;
        }else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            x++;
        }

        //让面板重绘
        this.repaint();
    }

    //当某个键释放（松开），该方法会触发
    @Override
    public void keyReleased(KeyEvent e) {

    }
}

package com.tank.game;
public class Tank {
    private int x;//坦克的横坐标
    private int y;//坦克的纵坐标
    private int direct;//direct 表示方向(0：向上 1：向右 2：向下 3：向左)
    private int speed = 1;//控制坦克的速度
    boolean isLive = true;//判断是否被击中
    public Tank(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDirect() {
        return direct;
    }

    public void setDirect(int direct) {
        this.direct = direct;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    //上右下左移动方法
    public void moveUp(){
        y -= speed;
    }
    public void moveRight(){
        x += speed;
    }
    public void moveDown(){
        y += speed;
    }
    public void moveLeft(){
        x -= speed;
    }
}
/*
    增加功能1
    1、让敌人的坦克也能够发射子弹(可以有多颗子弹)
    在敌人坦克类，使用Vector(多线程安全)保存多个Shot
    当每创建一个敌人坦克对象，给该敌人坦克对象初始化一个Shot对象，同时启动Shot
    在绘制敌人坦克时，需要遍历敌人坦克对象Vector,绘制所有的子弹,当子弹isLive == false时，就从Vector移除
    2、当我方坦克击中敌人坦克时，敌人的坦克就消失,如果能做出爆炸效果更好.
    3、让敌人的坦克也可以自由随机的上下左右移动
    因为要求敌人的坦克，可以自由移动，因此需要将敌人坦克当做线程使用
    我们需要Enemy Tank implements Runnable
    在run方法写上我们相应的业务代码.
    在创建敌人坦克对象时，启动线程
    4、控制我方的坦克和敌人的坦克在规定的范围移动分析->解决

    增加功能2
    1、我方坦克在发射的子弹消亡后，才能发射新的子弹.=>扩展(发多颗子弹怎么办,控制在我们的面板上,最多只有5颗)-》在课后完善
        1.在按下J键,我们判断当前hero对象的子弹,是否已经销毁
        2.如果没有销毁，就不去触发shotEnemyTank
        3.如果已经销毁,才去触发shotEnemyTank
        4.如果要发射多颗子弹，就使用Vector保存
        5.在绘制我方子弹时,需要遍历该Vector集合
    2、让敌人坦克发射的子弹消亡后，可以再发射子弹
    3、当敌人的坦克击中我方坦克时,我方坦克消失，并出现爆炸效果 思路:编写方法，判断敌人的坦克是否击中我的坦克
    4、课后练习:让敌人坦克可以最多发射3颗(在面板E)，我们的坦克可以发射3颗.并且能够出现正常的爆炸效果即可.
 */
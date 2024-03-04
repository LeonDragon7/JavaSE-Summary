package com.tank.game;

import java.util.Vector;

@SuppressWarnings("all")
public class EnemyTank extends Tank implements Runnable{
    //在敌人坦克类，使用Vector(多线程安全)保存多个Shot
    Vector<Shot> shots = new Vector<>();
    //增加成员，EnemyTank 可以得到敌人坦克的Vector
    //分析
    //1、Vector<EnemyTank>
    Vector<EnemyTank> enemyTanks = new Vector<>();
    public EnemyTank(int x, int y) {
        super(x, y);
    }

    //这里提供一个set方法，可以将MyPanel成员的Vector<EnemyTank> enemyTanks = new Vector<>();
    //设置到 EnemyTank的成员enemyTanks
    public void setEnemyTanks(Vector<EnemyTank> enemyTanks) {
        this.enemyTanks = enemyTanks;
    }

    //编写方法，判断当前的这个敌人坦克，是否和enemyTanks中的其他坦克发生的重叠或者碰撞
    public boolean isTouchEnemyTank(){
        //判断当前敌人坦克(this)方向
        switch (getDirect()){
            case 0://向上
                //让当前坦克和其他所有敌人的坦克进行比较
                for (int i = 0; i < enemyTanks.size(); i++) {
                    //从Vector中取出一个敌人坦克
                    EnemyTank enemyTank = enemyTanks.get(i);
                    //不和自己比较
                    if(enemyTank != this){
                        //如果敌人坦克是上或下方向
                        //分析
                        //1、如果敌人坦克是上或下方向 x的范围[enemyTank.getX(),enemyTank.getX() + 40]
                        //2、如果敌人坦克是上或下方向 y的范围[enemyTank.getY(),enemyTank.getY() + 60]
                        //3、当前坦克左上角的坐标[getX(),getY()]
                        //4、当前坦克右上角的坐标[getX() + 40,getY()]
                        if(enemyTank.getDirect() == 0 || enemyTank.getDirect() == 2){
                            if(getX() >= enemyTank.getX() && getX() <= enemyTank.getX() + 40
                            && getY() >= enemyTank.getY() && getY() <= enemyTank.getY() + 60){
                                return true;
                            }

                            if(getX() + 40 >= enemyTank.getX() && getX() + 40 <= enemyTank.getX() + 40
                                    && getY() >= enemyTank.getY() && getY() <= enemyTank.getY() + 60){
                                return true;
                            }
                        }
                        //如果敌人坦克是左或右方向
                        //分析
                        //1、如果敌人坦克是右或左方向 x的范围[enemyTank.getX(),enemyTank.getX() + 60]
                        //2、如果敌人坦克是上或下方向 y的范围[enemyTank.getY(),enemyTank.getY() + 40]
                        //3、当前坦克左上角的坐标[getX(),getY()]
                        //4、当前坦克右上角的坐标[getX() + 40,getY()]
                        if(enemyTank.getDirect() == 1 || enemyTank.getDirect() == 3){
                            if(getX() >= enemyTank.getX() && getX() <= enemyTank.getX() + 60
                                    && getY() >= enemyTank.getY() && getY() <= enemyTank.getY() + 40){
                                return true;
                            }

                            if(getX() + 40 >= enemyTank.getX() && getX() + 40 <= enemyTank.getX() + 60
                                    && getY() >= enemyTank.getY() && getY() <= enemyTank.getY() + 40){
                                return true;
                            }
                        }
                    }
                }
                break;
            case 1://向右
                //让当前坦克和其他所有敌人的坦克进行比较
                for (int i = 0; i < enemyTanks.size(); i++) {
                    //从Vector中取出一个敌人坦克
                    EnemyTank enemyTank = enemyTanks.get(i);
                    //不和自己比较
                    if(enemyTank != this){
                        //如果敌人坦克是上或下方向
                        //分析
                        //1、如果敌人坦克是上或下方向 x的范围[enemyTank.getX(),enemyTank.getX() + 40]
                        //2、如果敌人坦克是上或下方向 y的范围[enemyTank.getY(),enemyTank.getY() + 60]
                        //3、当前坦克右上角的坐标[getX() + 60,getY()]
                        //4、当前坦克右下角的坐标[getX() + 60,getY() + 40]
                        if(enemyTank.getDirect() == 0 || enemyTank.getDirect() == 2){
                            if(getX() + 60 >= enemyTank.getX() && getX() + 60 <= enemyTank.getX() + 40
                                    && getY() >= enemyTank.getY() && getY() <= enemyTank.getY() + 60){
                                return true;
                            }

                            if(getX() + 60 >= enemyTank.getX() && getX() + 60 <= enemyTank.getX() + 40
                                    && getY() + 40 >= enemyTank.getY() && getY() + 40 <= enemyTank.getY() + 60){
                                return true;
                            }
                        }
                        //如果敌人坦克是左或右方向
                        //分析
                        //1、如果敌人坦克是右或左方向 x的范围[enemyTank.getX(),enemyTank.getX() + 60]
                        //2、如果敌人坦克是上或下方向 y的范围[enemyTank.getY(),enemyTank.getY() + 40]
                        //3、当前坦克左上角的坐标[getX() + 60,getY()]
                        //4、当前坦克右下角的坐标[getX() + 60,getY() + 40]
                        if(enemyTank.getDirect() == 1 || enemyTank.getDirect() == 3){
                            if(getX() + 60 >= enemyTank.getX() && getX() + 60 <= enemyTank.getX() + 60
                                    && getY() >= enemyTank.getY() && getY() <= enemyTank.getY() + 40){
                                return true;
                            }

                            if(getX() + 60 >= enemyTank.getX() && getX() + 60 <= enemyTank.getX() + 60
                                    && getY() + 40 >= enemyTank.getY() && getY() + 40 <= enemyTank.getY() + 40){
                                return true;
                            }
                        }
                    }
                }
                break;
            case 2://向下
                //让当前坦克和其他所有敌人的坦克进行比较
                for (int i = 0; i < enemyTanks.size(); i++) {
                    //从Vector中取出一个敌人坦克
                    EnemyTank enemyTank = enemyTanks.get(i);
                    //不和自己比较
                    if(enemyTank != this){
                        //如果敌人坦克是上或下方向
                        //分析
                        //1、如果敌人坦克是上或下方向 x的范围[enemyTank.getX(),enemyTank.getX() + 40]
                        //2、如果敌人坦克是上或下方向 y的范围[enemyTank.getY(),enemyTank.getY() + 60]
                        //3、当前坦克左下角的坐标[getX(),getY() + 60]
                        //4、当前坦克右下角的坐标[getX() + 40,getY() + 60]
                        if(enemyTank.getDirect() == 0 || enemyTank.getDirect() == 2){
                            if(getX() >= enemyTank.getX() && getX() <= enemyTank.getX() + 40
                                    && getY() + 60 >= enemyTank.getY() && getY() + 60 <= enemyTank.getY() + 60){
                                return true;
                            }

                            if(getX() + 40 >= enemyTank.getX() && getX() + 40 <= enemyTank.getX() + 40
                                    && getY() + 60 >= enemyTank.getY() && getY() + 60 <= enemyTank.getY() + 60){
                                return true;
                            }
                        }
                        //如果敌人坦克是左或右方向
                        //分析
                        //1、如果敌人坦克是右或左方向 x的范围[enemyTank.getX(),enemyTank.getX() + 60]
                        //2、如果敌人坦克是上或下方向 y的范围[enemyTank.getY(),enemyTank.getY() + 40]
                        //3、当前坦克左下角的坐标[getX(),getY() + 60]
                        //4、当前坦克右下角的坐标[getX() + 40,getY() + 60]
                        if(enemyTank.getDirect() == 1 || enemyTank.getDirect() == 3){
                            if(getX() >= enemyTank.getX() && getX() <= enemyTank.getX() + 60
                                    && getY() + 60 >= enemyTank.getY() && getY() + 60 <= enemyTank.getY() + 40){
                                return true;
                            }

                            if(getX() + 40 >= enemyTank.getX() && getX() + 40 <= enemyTank.getX() + 60
                                    && getY() + 60 >= enemyTank.getY() && getY() + 60 <= enemyTank.getY() + 40){
                                return true;
                            }
                        }
                    }
                }
                break;
            case 3://向左
                //让当前坦克和其他所有敌人的坦克进行比较
                for (int i = 0; i < enemyTanks.size(); i++) {
                    //从Vector中取出一个敌人坦克
                    EnemyTank enemyTank = enemyTanks.get(i);
                    //不和自己比较
                    if(enemyTank != this){
                        //如果敌人坦克是上或下方向
                        //分析
                        //1、如果敌人坦克是上或下方向 x的范围[enemyTank.getX(),enemyTank.getX() + 40]
                        //2、如果敌人坦克是上或下方向 y的范围[enemyTank.getY(),enemyTank.getY() + 60]
                        //3、当前坦克左上角的坐标[getX(),getY()]
                        //4、当前坦克左下角的坐标[getX(),getY() + 40]
                        if(enemyTank.getDirect() == 0 || enemyTank.getDirect() == 2){
                            if(getX() >= enemyTank.getX() && getX() <= enemyTank.getX() + 40
                                    && getY() >= enemyTank.getY() && getY() <= enemyTank.getY() + 60){
                                return true;
                            }

                            if(getX() >= enemyTank.getX() && getX() <= enemyTank.getX() + 40
                                    && getY() + 40 >= enemyTank.getY() && getY() + 40 <= enemyTank.getY() + 60){
                                return true;
                            }
                        }
                        //如果敌人坦克是左或右方向
                        //分析
                        //1、如果敌人坦克是右或左方向 x的范围[enemyTank.getX(),enemyTank.getX() + 60]
                        //2、如果敌人坦克是上或下方向 y的范围[enemyTank.getY(),enemyTank.getY() + 40]
                        //3、当前坦克左上角的坐标[getX(),getY()]
                        //4、当前坦克左下角的坐标[getX(),getY() + 40]
                        if(enemyTank.getDirect() == 1 || enemyTank.getDirect() == 3){
                            if(getX() >= enemyTank.getX() && getX() <= enemyTank.getX() + 60
                                    && getY() >= enemyTank.getY() && getY() <= enemyTank.getY() + 40){
                                return true;
                            }

                            if(getX() >= enemyTank.getX() && getX() <= enemyTank.getX() + 60
                                    && getY() + 40 >= enemyTank.getY() && getY() + 40 <= enemyTank.getY() + 40){
                                return true;
                            }
                        }
                    }
                }
                break;
        }
        return false;
    }

    @Override
    public void run() {
        while (true){
            //判断如果shots.size() < 3,创建3颗子弹，放入到shots集合，并启动
            if(isLive && shots.size() < 3){
                Shot s = null;
                //判断坦克的方向，创建对应的子弹
                switch (getDirect()){
                    case 0://向上
                        s = new Shot(getX() + 20,getY(),0);
                        break;
                    case 1://向右
                        s = new Shot(getX() + 60,getY() + 20,1);
                        break;
                    case 2://向下
                        s = new Shot(getX() + 20,getY() + 60,2);
                        break;
                    case 3://向左
                        s = new Shot(getX(),getY() + 20,3);
                        break;
                }
                shots.add(s);
                new Thread(s).start();
            }
            //根据坦克的方向来继续移动
            switch (getDirect()){
                case 0://向上
                    //让坦克保持一个方向，走30步 不然坦克走一步就要换个方向 不合理
                    for (int i = 0; i < 30; i++) {
                        if(getY() > 0 && !isTouchEnemyTank()){
                            moveUp();
                        }
                        //休眠50毫秒 防止过快走完 没有过程
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
                case 1://向右
                    //让坦克保持一个方向，走25步
                    for (int i = 0; i < 25; i++) {
                        if(getX() + 60 < 1000 && !isTouchEnemyTank()){
                            moveRight();
                        }
                        //休眠50毫秒 防止过快走完 没有过程
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
                case 2://向下
                    //让坦克保持一个方向，走15步
                    for (int i = 0; i < 15; i++) {
                        if(getY() + 60 < 750 && !isTouchEnemyTank()){
                            moveDown();
                        }
                        //休眠50毫秒 防止过快走完 没有过程
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
                case 3://向左
                    //让坦克保持一个方向，走10步
                    for (int i = 0; i < 10; i++) {
                        if(getX() > 0 && !isTouchEnemyTank()){
                            moveLeft();
                        }
                        //休眠50毫秒 防止过快走完 没有过程
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
            }

            //然后随机的改变坦克方向 0 - 3
            setDirect((int)(Math.random() * 4));

            //说明，写并发程序，一定要考虑清楚，该线程什么时候结束
            if(!isLive){
                break;//退出线程
            }
        }
    }
}

package com.tank.game;


import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.Vector;

/**
 * 坦克大战的绘图区域
 */
public class MyPanel extends JPanel implements KeyListener,Runnable {
    //定义我的坦克
    Hero hero = null;
    //定义敌人坦克，放入到Vector
    Vector<EnemyTank> enemyTanks = new Vector<>();
    //定义一个存放Node对象的Vector，用于恢复敌人坦克的坐标和方向
    Vector<Node> nodes = null;
    //定义一个Vector，用于存放炸弹
    //说明，当子弹击中坦克时，加入一个Bomb对象到bombs
    Vector<Bomb> bombs = new Vector<>();
    //定义三张炸弹图片，用于存放炸弹
    Image image1 = null;
    Image image2 = null;
    Image image3 = null;
    int enemyTankSize = 3;
    public MyPanel(String key){
        //先判断记录的文件是否存在
        //如果存在，就正常执行，如果文件不存在，提示，只能开启新游戏，key = "1"
        File file = new File(Recorder.getRecordFile());
        if(file.exists()){
            nodes = Recorder.getNodesAndEnemyTankRecord();
        }else{
            System.out.println("文件不存在，只能开启新的游戏！");
            key = "1";
        }
        nodes = Recorder.getNodesAndEnemyTankRecord();
        //将MyPanel对象的enemyTanks设置给Recorder的enemyTanks
        Recorder.setEnemyTanks(enemyTanks);
        hero = new Hero(500,100);//初始化自己的坦克
        hero.setSpeed(3);
        switch (key){
            case "1":
                //初始化敌人坦克
                for (int i = 0; i < enemyTankSize; i++) {
                    //创建一个敌人的坦克
                    EnemyTank enemyTank = new EnemyTank((100 * (i + 1)), 0);
                    //设置方向
                    enemyTank.setDirect(2);
                    //启动敌人坦克线程，让他动起来
                    new Thread(enemyTank).start();
                    //给该enemyTank 加入一颗子弹
                    Shot shot = new Shot(enemyTank.getX() + 20,enemyTank.getY() + 60,enemyTank.getDirect());
                    //加入enemyTank的Vector成员
                    enemyTank.shots.add(shot);
                    //启动shot对象
                    new Thread(shot).start();
                    //加入
                    enemyTanks.add(enemyTank);
                }
                break;
            case "2"://继续上局游戏
                //初始化敌人坦克
                for (int i = 0; i < nodes.size(); i++) {
                    nodes = new Vector<>();
                    //取出上局剩余坦克数
                    Node node = nodes.get(i);
                    //创建一个敌人的坦克
                    EnemyTank enemyTank = new EnemyTank(node.getX(), node.getY());
                    //设置方向
                    enemyTank.setDirect(node.getDirect());
                    //启动敌人坦克线程，让他动起来
                    new Thread(enemyTank).start();
                    //给该enemyTank 加入一颗子弹
                    Shot shot = new Shot(enemyTank.getX() + 20,enemyTank.getY() + 60,enemyTank.getDirect());
                    //加入enemyTank的Vector成员
                    enemyTank.shots.add(shot);
                    //启动shot对象
                    new Thread(shot).start();
                    //加入
                    enemyTanks.add(enemyTank);
                }
                break;
            default:
                System.out.println("你的输入有误...");
                break;
        }
        //初始化图片对象
        image1 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_1.gif"));
        image2 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_2.gif"));
        image3 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_3.gif"));

        //播放指定的音乐
        new AePlayWave("src\\111.wav").start();
    }

    //编写方法，显示我方击毁敌方坦克的信息
    public void showInfo(Graphics g){
        //画出玩家的总成绩
        g.setColor(Color.BLACK);
        Font font = new Font("宋体", Font.BOLD, 25);
        g.setFont(font);

        g.drawString("你累计击毁敌方坦克",1020,30);
        drawTank(1020,60,g,0,1);//画出一个敌方坦克
        g.setColor(Color.BLACK);//要重置画笔颜色，否则上面创建的坦克颜色会覆盖最初的黑色
        g.drawString(Recorder.getAllEnemyTankNum() + "",1080,100);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0,0,1000,750);//填充矩形，默认黑色
        showInfo(g);
        //画出自己坦克-封装方法
        //判断自己坦克是否被销毁
        if(hero != null && hero.isLive){
            drawTank(hero.getX(),hero.getY(),g,hero.getDirect(),0);
        }

        //画出敌人的坦克, 遍历Vector
        for (int i = 0; i < enemyTanks.size(); i++) {
            //取出坦克
            EnemyTank enemyTank = enemyTanks.get(i);
            //将enemyTanks设置给enemyTank
            enemyTank.setEnemyTanks(enemyTanks);
            //判断当前坦克是否被击中
            if(enemyTank.isLive){//当敌人坦克是存活的，才绘制该坦克
                drawTank(enemyTank.getX(), enemyTank.getY(), g, enemyTank.getDirect(), 1);
                //画出 enemyTank 所有子弹
                for (int j = 0; j < enemyTank.shots.size(); j++) {
                    //取出子弹
                    Shot shot = enemyTank.shots.get(j);
                    //绘制
                    if(shot.isLive){
                        g.draw3DRect(shot.x,shot.y,2,2,false);
                    }else{
                        //移除子弹
                        enemyTank.shots.remove(shot);
                    }
                }
            }
        }

        //画出hero射击的子弹
        //为了让Panel不停地重绘子弹，需要将MyPanel实现Runnable，当做一个线程使用，否则只能调用一次
        //将hero的子弹集合shots，遍历取出绘制
        for (int i = 0; i < hero.shots.size(); i++) {
            Shot shot = hero.shots.get(i);
            if(shot != null && shot.isLive){
                System.out.println("子弹被重绘...");
                g.draw3DRect(shot.x,shot.y,2,2,false);
            }else {//如果该shot对象已经无效,就从shots集合中取出
                hero.shots.remove(shot);
            }
        }
        //如果bombs集合中有对象，就绘制
        for (int i = 0; i < bombs.size(); i++) {
            //取出炸弹
            Bomb bomb = bombs.get(i);
            //根据当前这个bomb对象的life值去画出对应图片
            if(bomb.life > 8){
                g.drawImage(image1, bomb.x, bomb.y, 60,60,this);
            } else if (bomb.life > 4) {
                g.drawImage(image2, bomb.x, bomb.y, 60,60,this);
            }else {
                g.drawImage(image3, bomb.x, bomb.y, 60,60,this);
            }
            //让这个炸弹的生命值减少
            bomb.lifeDown();
            //如果bomb.life为0，就从bombs的集合中删除
            if(bomb.life == 0){
                bombs.remove(bomb);
            }
        }
    }

    /**
     * 编写绘画坦克方法
     * @param x 坦克的左上角x坐标
     * @param y 坦克的左上角y坐标
     * @param g 画笔
     * @param direct 坦克的方向(上下左右)
     * @param type 坦克类型
     */
    public void drawTank(int x,int y,Graphics g,int direct,int type){
        //根据不同类型坦克，设置不同颜色
        switch (type){
            case 0: //我们的坦克
                g.setColor(Color.cyan);
                break;
            case 1: //敌人的坦克
                g.setColor(Color.yellow);
                break;
        }

        //根据坦克方向，来绘制对于形状的坦克
        //direct 表示方向(0：向上 1：向右 2：向下 3：向左)
        switch (direct){
            case 0: //表示向上
                g.fill3DRect(x,y,10,60,false);//画出坦克左边轮子
                g.fill3DRect(x + 30,y,10,60,false);//画出坦克右边轮子
                g.fill3DRect(x + 10,y + 10,20,40,false);//画出坦克的中间矩形
                g.fillOval(x + 10,y + 20,20,20);//画出坦克的中间圆形
                g.drawLine(x + 20,y + 30,x + 20,y);//画出坦克的炮筒
                break;
            case 1: //表示向右
                g.fill3DRect(x,y,60,10,false);//画出坦克上边轮子
                g.fill3DRect(x,y + 30,60,10,false);//画出坦克下边轮子
                g.fill3DRect(x + 10,y + 10,40,20,false);//画出坦克的中间矩形
                g.fillOval(x + 20,y + 10,20,20);//画出坦克的中间圆形
                g.drawLine(x + 30,y + 20,x + 60,y + 20);//画出坦克的炮筒
                break;
            case 2: //表示向下
                g.fill3DRect(x,y,10,60,false);//画出坦克左边轮子
                g.fill3DRect(x + 30,y,10,60,false);//画出坦克右边轮子
                g.fill3DRect(x + 10,y + 10,20,40,false);//画出坦克的中间矩形
                g.fillOval(x + 10,y + 20,20,20);//画出坦克的中间圆形
                g.drawLine(x + 20,y + 30,x + 20,y + 60);//画出坦克的炮筒
                break;
            case 3: //表示向左边
                g.fill3DRect(x,y,60,10,false);//画出坦克上边轮子
                g.fill3DRect(x,y + 30,60,10,false);//画出坦克下边轮子
                g.fill3DRect(x + 10,y + 10,40,20,false);//画出坦克的中间矩形
                g.fillOval(x + 20,y + 10,20,20);//画出坦克的中间圆形
                g.drawLine(x + 30,y + 20,x,y + 20);//画出坦克的炮筒
                break;
            default:
                System.out.println("暂时没有处理！");
        }
    }

    //如果我们的坦克可以发射多个子弹
    //在判断我方子弹是否击中敌人坦克时，就需要把我们的子弹集合中所有子弹
    //都取出和敌人的所有坦克，进行判断
    public void hitEnemyTank(){
        //遍历我们所有子弹
        for (int i = 0; i < hero.shots.size(); i++) {
            Shot shot = hero.shots.get(i);
            //判断是否击中了敌人坦克 要先判断空值 一开始没子弹
            if(shot != null && shot.isLive){//当我的子弹还存在
                //遍历敌人所有坦克
                for (int j = 0; j < enemyTanks.size(); j++) {
                    EnemyTank enemyTank = enemyTanks.get(j);
                    hitTank(shot,enemyTank);
                }
            }
        }
    }

    //编写方法，判断敌人坦克是否击中我的坦克
    public void hitHero(){
        //遍历所有的敌人坦克
        for (int i = 0; i < enemyTanks.size(); i++) {
            //取出敌人坦克
            EnemyTank enemyTank = enemyTanks.get(i);
            //遍历enemyTank对象的所有子弹
            for (int j = 0; j < enemyTank.shots.size(); j++) {
                //取出子弹
                Shot shot = enemyTank.shots.get(j);
                //判断shot是否击中我的坦克
                if(hero.isLive && shot.isLive){
                    hitTank(shot,hero);
                }
            }
        }
    }


    //编写方法，判断我方的子弹是否击中敌人坦克
    //什么时候判断 我方的子弹是否击中敌人坦克 ？ run方法
    public void hitTank(Shot s,Tank tank){
        //判断s击中坦克 子弹是否落在坦克的区域内
        switch (tank.getDirect()){
            case 0://坦克向上
            case 2://坦克向下
                if(s.x > tank.getX() && s.x < tank.getX() + 40
                && s.y > tank.getY() && s.y < tank.getY() + 60){
                    s.isLive = false;
                    tank.isLive = false;
                    //当我的子弹击中坦克后，将tank从Vector删除
                    enemyTanks.remove(tank);
                    //当我方击毁一个敌人坦克时，就对数据allEnemyTankNum++
                    //因为tank可以是Hero 也可以是EnemyTank
                    if(tank instanceof EnemyTank){
                        Recorder.addAllEnemyTankNum();
                    }
                    //创建Bomb对象，加入到bombs集合
                    Bomb bomb = new Bomb(tank.getX(), tank.getY());
                    bombs.add(bomb);
                }
                break;
            case 1://坦克向右
            case 3://坦克向左
                if(s.x > tank.getX() && s.x < tank.getX() + 60
                        && s.y > tank.getY() && s.y < tank.getY() + 40){
                    s.isLive = false;
                    tank.isLive = false;
                    //当我的子弹击中坦克后，将tank从Vector删除
                    enemyTanks.remove(tank);
                    //当我方击毁一个敌人坦克时，就对数据allEnemyTankNum++
                    //因为tank可以是Hero 也可以是EnemyTank
                    if(tank instanceof EnemyTank){
                        Recorder.addAllEnemyTankNum();
                    }
                    //创建Bomb对象，加入到bombs集合
                    Bomb bomb = new Bomb(tank.getX(), tank.getY());
                    bombs.add(bomb);
                }
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        //改变移动坦克方向和移动坐标 封装
        if(e.getKeyCode() == KeyEvent.VK_W){
            hero.setDirect(0);
            if(hero.getY() > 0){
                hero.moveUp();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            hero.setDirect(1);
            if(hero.getX() + 60 < 1000){
                hero.moveRight();
            }
        }else if (e.getKeyCode() == KeyEvent.VK_S) {
            hero.setDirect(2);
            if(hero.getY() + 60 < 750){
                hero.moveDown();
            }
        }
        else if (e.getKeyCode() == KeyEvent.VK_A) {
            hero.setDirect(3);
            if(hero.getX() > 0 ){
                hero.moveLeft();
            }
        }
        //如果用户按下的是J,就发射
        if(e.getKeyCode() == KeyEvent.VK_J){
            //判断hero的子弹是否销毁
            //hero.shot == null:在刚入界面还没有子弹，按下j键的时候，创建子弹(shot)
            //!hero.shot.isLive:碰到墙壁或者打到敌人 生命周期销毁情况，创建子弹(shot)
//            if(hero.shot == null || !hero.shot.isLive){
//                hero.shotEnemyTank();
//            }
            //发射多颗子弹
            hero.shotEnemyTank();
        }

        this.repaint();//让面板重绘
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {//每隔100毫秒，重绘区域,刷新绘图区域，子弹就移动
        while (true){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            //判断是否击中了敌人的坦克
            hitEnemyTank();
            //判断敌人是否击中了你的坦克
            hitHero();
            this.repaint();
        }
    }
}

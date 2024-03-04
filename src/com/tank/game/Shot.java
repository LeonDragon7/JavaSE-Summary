package com.tank.game;
/*
    分析如何实现当用户按下J键,我们的坦克就发射一颗子弹，思路：
    1、当发射一颗子弹后，就相当于启动一个线程
    2、Hero有子弹的对象,当按下J时,我们就启动一个发射行为(线程),让子弹不停的移动,形成一个射击的效果
    3、我们MyPanel需要不停的重绘子弹,才能出现该效果.
    4、当子弹移动到面板的边界时，就应该销毁(把启动的子弹的线程销毁)
 */
public class Shot implements Runnable{
    int x;//子弹x坐标
    int y;//子弹y坐标
    int direct = 0;//子弹方向
    int speed = 2;//子弹速度
    boolean isLive = true;//子弹是否还存活

    public Shot(int x, int y, int direct) {
        this.x = x;
        this.y = y;
        this.direct = direct;
    }

    @Override
    public void run() {//射击 线程-不停改变坐标的位置
        while (true){
            try {
                Thread.sleep(50);//休眠 50毫秒
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            //根据方向改变x和y坐标
            switch (direct){
                case 0://子弹朝上
                    y -= speed;
                    break;
                case 1://子弹朝右
                    x += speed;
                    break;
                case 2://子弹朝下
                    y += speed;
                    break;
                case 3://子弹朝左
                    x -= speed;
                    break;
            }
            //这里我们输出x,y的坐标
            System.out.println("子弹 x=" + x + " y=" + y);
            //当子弹移动到面板的边界时，就应该销毁（把启动的子弹的线程销毁)
            //当子弹碰到敌人坦克时，也应该结束线程
            if(!(x >= 0 && x <= 1000 && y >= 0 && y <= 750 && isLive)){
                System.out.println("子弹线程退出");
                isLive = false;
                break;
            }
        }
    }
}

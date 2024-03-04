package com.oop.up.recursion.test;
/*
    方法递归调用
    迷宫问题
    1、小球的得到的路径，和程序员设置的找路策略有关
    即：找路的上下左右的顺序相关
    2、再得到小球路径时，可以先使用（下右上左），在
    改成（上右下左），看看路径是不是有变化
    3、测试回溯现象
    4、如何求出最短路径？图
 */
public class RecursionLabyrinth {
    public static void main(String[] args) {
        /*
        思路：
        1、先创建迷宫，用二维数组
        2、先规定 map 数组的元素值：0：表示可以走，1：表示障碍物
         */
        int[][] map = new int[8][7];
        //3、将最上面的一行和最下面的一行，全部设置为1
        for(int i = 0;i < 7;i++){//i为列
            map[0][i] = 1;
            map[7][i] = 1;
        }
        //4、将最右面的一行和最左面的一行，全部设置为1
        for(int i = 0;i < 8;i++){//i为行
            map[i][0] = 1;
            map[i][6] = 1;
        }
        //设置障碍物
        map[3][1] = 1;
        map[3][2] = 1;
        //输出当前的地图
        for(int i = 0;i < map.length;i++){
            for(int j = 0;j < map[i].length;j++){
                System.out.print(map[i][j] + "\t");
            }
            System.out.println();
        }
        //使用findWay01给老鼠找路 下->右->上->左
        Labyrinth l = new Labyrinth();
        l.findWay01(map,1,1);
        System.out.println("\n======找路的情况如下01=======");
        for(int i = 0;i < map.length;i++){
            for(int j = 0;j < map[i].length;j++){
                System.out.print(map[i][j] + "\t");
            }
            System.out.println();
        }
        /*使用findWay01给老鼠找路 上->右->下->左
        l.findWay02(map,1,1);
        System.out.println("\n======找路的情况如下02=======");
        for(int i = 0;i < map.length;i++){
            for(int j = 0;j < map[i].length;j++){
                System.out.print(map[i][j] + "\t");
            }
            System.out.println();
        }
         */
    }
}
class Labyrinth{
    /*
    使用递归回溯的思想来解决老鼠出迷宫
    1、findWay方法就是专门来找出迷宫的路径
    2、如果找到，就返回true，否则返回false
    3、map 就是二维数组，即表示迷宫
    4、i，j就是老鼠的位置，初始化的位置为(1,1)
    5、因为我们是递归的找路，所以我先规定 map 数组的各个值的含义
        0：表示可以走 1：表示障碍物 2：表示可以走 3、表示走过，但是走不通是死路
    6、当map[6][5] = 2 就说明找到通路，就可以结束，否则就继续找
    7、先确定老鼠找路策略 下->右->上->左
     */
    public boolean findWay01(int[][] map,int i,int j){
        if(map[6][5] == 2){//说明已经找到
            return true;
        }else{
            if(map[i][j] == 0){//当前这个位置0,说明表示可以走
                //假定可以走通
                map[i][j] = 2;
                //使用找路策略，来确定该位置是否真的可以走通
                //下->右->上->左
                if(findWay01(map,i + 1,j)){//走下
                    return true;
                }else if (findWay01(map,i,j + 1)){//走右
                    return true;
                } else if (findWay01(map,i - 1,j)) {//走上
                    return true;
                } else if (findWay01(map,i,j - 1)) {//走左
                    return true;
                }else{
                    map[i][j] = 3;
                    return false;
                }
            }else{//当前 map[i][j] == 1\2\3; 表明是障碍物\表示可以走(但是0已经测试了，已经走过)\表示走过，但是走不通是死路
                return false;
            }
        }
    }

    //修改找路策略，看看路径是否有变化
    //上>右->下->左
    public boolean findWay02(int[][] map,int i,int j){
        if(map[6][5] == 2){//说明已经找到
            return true;
        }else{
            if(map[i][j] == 0){//当前这个位置0,说明表示可以走
                //假定可以走通
                map[i][j] = 2;
                //使用找路策略，来确定该位置是否真的可以走通
                //下->右->上->左
                if(findWay02(map,i - 1,j)){//走上
                    return true;
                }else if (findWay02(map,i,j + 1)){//走右
                    return true;
                } else if (findWay02(map,i + 1,j)) {//走下
                    return true;
                } else if (findWay02(map,i,j - 1)) {//走左
                    return true;
                }else{
                    map[i][j] = 3;
                    return false;
                }
            }else{//当前 map[i][j] == 1\2\3; 表明是障碍物\表示可以走(但是0已经测试了，已经走过)\表示走过，但是走不通是死路
                return false;
            }
        }
    }
}

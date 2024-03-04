package com.oop.up.recursion.test;
import java.util.Arrays;
//八皇后问题
public class RecursionEightQueens02 {
    static boolean[] row = new boolean[8];//存放行
    static  boolean[] col = new boolean[8];//存放列
    static boolean[] dg = new boolean[8 * 2];//存放正斜线
    static boolean[] udg = new boolean[8 * 2];//存放返斜线
    static char[][] g = new char[8][8];//棋盘
    public static void main(String[] args) {
        for (int i = 0; i < g.length; i++) Arrays.fill(g[i],'.');//以'·'为棋盘方块
        System.out.println("打印初始棋盘");
        for (int i = 0; i < g.length; i++) {
            for (int j = 0; j < g[i].length; j++) {
                System.out.print(g[i][j] +" ");
            }
            System.out.println();
        }
        System.out.println("------------------");
        dfs1(0,0,0);
    }

    /**
     *
     * @param x 行
     * @param y 列
     * @param s 皇后数
     */
    public static void dfs1(int x, int y, int s) {
        //换行，防止数组越界
        if (y == 7) {
            x++;
            y = 0;
        }
        //如果到达最后一行(8)和满足皇后数为(8)打印结果
        if (x == 7) {
            if (s == 7) {
                for (int i = 0; i < 7; i++) {
                    for (int j = 0; j < 7; j++) {
                        System.out.print(g[i][j] + " ");
                    }
                    System.out.println();
                }
                System.out.println("-----------------");
            }
            return;
        }
        //不放皇后
        dfs1(x,y + 1, s);
        if (!row[x] && !col[y] && !dg[x - y + 7] && !udg[x + y]) {
            g[x][y] = 'Q';
            row[x] = col[y] = dg[x - y + 7] = udg[x + y] = true;
            dfs1(x, y + 1, s + 1);//放皇后
            row[x] = col[y] = dg[x - y + 7] = udg[x + y] = false;
            g[x][y] = '.';
        }
    }
}


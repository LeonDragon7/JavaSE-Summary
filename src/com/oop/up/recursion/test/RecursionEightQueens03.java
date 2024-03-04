package com.oop.up.recursion.test;

import java.util.Arrays;

public class RecursionEightQueens03 {
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
        dfs2(8, 0);
    }
    /**
     *
     * @param n n * n
     * @param row 记录行
     */
    public static void dfs2(int n, int row) {
        if (row == n) {
            //初始化棋盘
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    System.out.print(g[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println("---------------------");
        }
        // 处理
        /**
         * i是列
         * row是行
         */
        for (int i = 0; i < n; i++) {
            if(!col[i] && !dg[row - i + n] && !udg[row + i]) {
                g[row][i] = 'O';
                col[i] = dg[row - i + n] = udg[row + i] = true;
                dfs2(n, row + 1);
                col[i] = dg[row - i + n] = udg[row + i] = false;
                g[row][i] = '.';
            }
        }
    }
}

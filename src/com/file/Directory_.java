package com.file;



import org.junit.Test;

import java.io.File;

/*
    目录的操作和文件删除
    mkdir创建一级目录、mkdirs创建多级目录、delete删除空目录或文件

    应用案例演示
    判断 d:\\news1.txt是否存在，如果存在就删除
    判断 D:\\demo02是否存在，存在就删除,否则提示不存在.
    判断 D:\\demo\\a\\b\\c目录是否存在，如果存在就提示已经存在，否则就创建
 */
public class Directory_ {

    //判断 d:\\news1.txt 是否存在，如果存在就删除
    @Test
    public void m1() {

        String filePath = "e:\\news1.txt";
        File file = new File(filePath);
        if (file.exists()) {
            if (file.delete()) {
                System.out.println(filePath + "删除成功");
            } else {
                System.out.println(filePath + "删除失败");
            }
        } else {
            System.out.println("该文件不存在...");
        }

    }

    //判断 D:\\demo02 是否存在，存在就删除，否则提示不存在
    //这里我们需要体会到，在java编程中，目录也被当做文件
    @Test
    public void m2() {

        String filePath = "D:\\demo02";
        File file = new File(filePath);
        if (file.exists()) {
            if (file.delete()) {
                System.out.println(filePath + "删除成功");
            } else {
                System.out.println(filePath + "删除失败");
            }
        } else {
            System.out.println("该目录不存在...");
        }

    }

    //判断 D:\\demo\\a\\b\\c 目录是否存在，如果存在就提示已经存在，否则就创建
    @Test
    public void m3() {

        String directoryPath = "D:\\demo\\a\\b\\c";
        File file = new File(directoryPath);
        if (file.exists()) {
            System.out.println(directoryPath + "存在..");
        } else {
            if (file.mkdirs()) { //创建一级目录使用mkdir() ，创建多级目录使用mkdirs()
                System.out.println(directoryPath + "创建成功..");
            } else {
                System.out.println(directoryPath + "创建失败...");
            }
        }


    }
}

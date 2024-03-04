package com.file.stream.writer_.node;

import java.io.FileWriter;
import java.io.IOException;

/*
    FileWriter 相关方法
    1、new FileWriter(File/String):覆盖模式，相当于流的指针在首端
    2、new FileWriter(File/String,true):追加模式，相当于流的指针在尾端
    3、write(int):写入单个字符
    4、write(char[]):写入指定数组
    5、write(char[],off,len):写入指定数组的指定部分
    6、write (string):写入整个字符串
    7、write(string,off,len):写入字符串的指定部分

    相关APl: String类: toCharArray:将String转换成char[]

    注意: **FileWriter使用后，必须要关闭(close)或刷新(flush)，否则写入不到指定的文件!**因为仅仅到了Java程序内存中。
 */
public class FileWriter_ {
    public static void main(String[] args) {
        /**
         * 使用FileWriter 将“风雨之后，定见彩虹” 写入到note.txt 文件中, 注意细节.
         */
        String filePath = "e:\\note.txt";
        //创建FileWriter对象
        FileWriter fileWriter = null;
        char[] chars = {'a', 'b', 'c'};
        try {
            fileWriter = new FileWriter(filePath);//默认是覆盖写入
//            3) write(int):写入单个字符
            fileWriter.write('H');
//            4) write(char[]):写入指定数组
            fileWriter.write(chars);
//            5) write(char[],off,len):写入指定数组的指定部分
            fileWriter.write("教育".toCharArray(), 0, 3);
//            6) write（string）：写入整个字符串
            fileWriter.write(" 你好北京~");
            fileWriter.write("风雨之后，定见彩虹");
//            7) write(string,off,len):写入字符串的指定部分
            fileWriter.write("上海天津", 0, 2); // 输出上海，因为从offset0开始，写入两个字符
            //在数据量大的情况下，可以使用循环操作.


        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            // 对应FileWriter , 一定要关闭流，或者flush才能真正的把数据写入到文件
            // 看源码就知道原因.
            /*
                看看代码
                private void writeBytes() throws IOException {
                    this.bb.flip();
                    int var1 = this.bb.limit();
                    int var2 = this.bb.position();

                    assert var2 <= var1;

                    int var3 = var2 <= var1 ? var1 - var2 : 0;
                    if (var3 > 0) {
                        if (this.ch != null) {
                            assert this.ch.write(this.bb) == var3 : var3;
                        } else {
                            this.out.write(this.bb.array(), this.bb.arrayOffset() + var2, var3);
                        }
                 }
                    this.bb.clear();
                }
             */
            try {
                //fileWriter.flush();
                //关闭文件流，等价于 flush() + 关闭
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        System.out.println("程序结束...");
    }
}

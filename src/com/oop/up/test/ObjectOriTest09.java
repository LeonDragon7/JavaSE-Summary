package com.oop.up.test;

public class ObjectOriTest09 {
    public static void main(String[] args) {
        /*
        9.定义Music类，里面有音乐名name、音乐时长times属性，并有播放play功能和返
        回本身属性信息的功能方法getInfo.
         */
        Music music = new Music("笑傲江湖",300);
        music.play();
        String message = music.getInfo();
        System.out.println(message);

    }
}
class Music{
    String name;
    int times;
    public Music(String name,int times){
        this.name = name;
        this.times = times;
    }
    public void play(){
        System.out.println("音乐 " + name + "正在播放中..... 时长为" + times + "秒");
    }
    public String getInfo(){
        return "音乐 " + name + " 播放时间为" + times;
    }
}
/*
class Music{
    String name;
    double times;
    Scanner scanner = new Scanner(System.in);
    public void play(){
        String input = scanner.next();
        double tmp = 0;
        if(name.equals(input)){
            while (true){
                if(times > tmp + 0.01) {
                    tmp += 0.01;
                    System.out.println("正在播放" + name + "的歌词...还剩下时长" + String.format("%.2f",times - tmp));
                }else {
                    break;
                }
            }
        }
    }
    public String getInfo(){
        name = "鸡你太美";
        times = 3.12;
        return name + "," + times;
    }
}
 */

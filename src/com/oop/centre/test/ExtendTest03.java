package com.oop.centre.test;

public class ExtendTest03 {
    public static void main(String[] args) {
        /*
        编写Computer类，包含CPU、内存、硬盘等属性，getDetails方法用于返回
        Computer的详细信息
        编写PC子类，继承Computer类，添加特有属性【品牌brand】
        编写NotePad子类，继承Computer类，添加特有属性【演示color】
        编写ExtendTest03类，在main方法中创建PC和NotePad对象，分别给对象中特有的属性
        赋值，以及从Computer类继承的属性赋值，并使用方法并打印输出信息
         */
        PC pc = new PC("Inter",167,500,"IBM");
        pc.printInfo();
    }
}
class Computer{
    private String cpu;
    private int memory;
    private int disk;

    public Computer(String cpu, int memory, int disk) {
        this.cpu = cpu;
        this.memory = memory;
        this.disk = disk;
    }

    public String getDetails(){
        return "cpu = " + cpu + ",memory = " + memory + ",disk = " + disk;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public int getDisk() {
        return disk;
    }

    public void setDisk(int disk) {
        this.disk = disk;
    }

}
class PC extends Computer{
    private String brand;

    public PC(String cpu, int memory, int disk, String brand) {
        super(cpu, memory, disk);
        this.brand = brand;
    }

    public void printInfo(){
        System.out.println("PC信息:");
        System.out.println(getDetails() + ",brand = " + brand);
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
class NotePad extends Computer{
    String color;
    public NotePad(String cpu, int memory, int disk, String color) {
        super(cpu, memory, disk);
        this.color = color;
    }

    public void printInfo(){
        System.out.println("NotePad信息:");
        System.out.println(getDetails() + ",color = " + color);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
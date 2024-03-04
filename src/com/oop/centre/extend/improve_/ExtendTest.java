package com.oop.centre.extend.improve_;

import com.oop.centre.extend.Graduate;
import com.oop.centre.extend.Pupil;

public class ExtendTest {
    public static void main(String[] args) {
        com.oop.centre.extend.Pupil pupil = new Pupil();
        pupil.name = "小红";
        pupil.age = 13;
        pupil.testing();
        pupil.setScore(50);
        pupil.showInfo();

        System.out.println("=================");

        com.oop.centre.extend.Graduate graduate = new Graduate();
        graduate.name = "银角大王";
        graduate.age = 21;
        graduate.testing();
        graduate.setScore(80);
        graduate.showInfo();
    }
}

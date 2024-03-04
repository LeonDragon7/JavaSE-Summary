package com.collection.Test;

import java.util.HashSet;
import java.util.Objects;

/*
    6.下面的代码输出什么?这道题很有意思,稍不注意就掉进陷阱.
    已知: Person2类按照id和name重写了hashCode和equals方法（id和name相同的话就认定为同一个对象）,
    问下面代码输出什么?
 */
public class CollectionTest06 {
    public static void main(String[] args) {
        HashSet set = new HashSet();
        Person2 p1 = new Person2(1001,"AA");
        Person2 p2 = new Person2(1002,"BB");
        set.add(p1);
        set.add(p2);
        p1.name = "CC";
        set.remove(p1);
        System.out.println(set);
        set.add(new Person2(1001,"CC"));
        System.out.println(set);
        set.add(new Person2(1001,"AA"));
        System.out.println(set);
    }
}
class Person2 {
    public String name;
    public int id;

    public Person2(int id, String name) {
        this.name = name;
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person2 person = (Person2) o;
        return id == person.id &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
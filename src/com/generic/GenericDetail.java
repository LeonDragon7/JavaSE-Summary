package com.generic;

import com.oop.centre.poly.Pig;

import java.util.ArrayList;
import java.util.List;

/*
    泛型使用的注意事项和细节
    interface List{} , public class HashSet{}..等等
    说明:T,E只能是引用类型，看看下面语句是否正确?
    List<Integer> list = new ArrayList<Integer>()://OK
    List<int> list2 = new ArrayList<int>();//错误

    在给泛型指定具体类型后，可以传入该类型或者其子类类型
    泛型使用形式
    List<Integer> list1 =new ArrayList<Integer>();
    List<Integer> list2 = new ArrayList<>(); // 推荐省略写法
    如果我们这样写List list3 = new ArrayList();默认给它的泛型是<E> E就是Object。如果是这样写 泛型默认是 Object
 */
@SuppressWarnings({"all"})
public class GenericDetail {
    public static void main(String[] args) {
        //1.给泛型指向数据类型是，要求是引用类型，不能是基本数据类型
        List<Integer> list = new ArrayList<Integer>(); //OK
        //List<int> list2 = new ArrayList<int>();//错误

        //2. 说明
        //因为 E 指定了 A 类型, 构造器传入了 new A()
        //在给泛型指定具体类型后，可以传入该类型或者其子类类型
        Pig1<A> aPig = new Pig1<A>(new A());
        aPig.f();
        Pig1<A> aPig2 = new Pig1<A>(new B());
        aPig2.f();

        //3. 泛型的使用形式
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        List<Integer> list2 = new ArrayList<Integer>();
        //在实际开发中，我们往往简写
        //编译器会进行类型推断, 老师推荐使用下面写法
        ArrayList<Integer> list3 = new ArrayList<>();
        List<Integer> list4 = new ArrayList<>();
        ArrayList<Pig> pigs = new ArrayList<>();

        //4. 如果是这样写 泛型默认是 Object
        ArrayList arrayList = new ArrayList();//等价 ArrayList<Object> arrayList = new ArrayList<Object>();

        /*
            public boolean add(Object e) {
                ensureCapacityInternal(size + 1);  // Increments modCount!!
                elementData[size++] = e;
                return true;
            }
         */
        Tiger tiger = new Tiger();
        /*

            class Tiger {//类
                Object e;

                public Tiger() {}

                public Tiger(Object e) {
                    this.e = e;
                }
            }

         */

    }
}
class Tiger<E> {//类
    E e;

    public Tiger() {}

    public Tiger(E e) {
        this.e = e;
    }
}

class A {}
class B extends A {}

class Pig1<E> {//
    E e;

    public Pig1(E e) {
        this.e = e;
    }

    public void f() {
        System.out.println(e.getClass()); //运行类型
    }
}

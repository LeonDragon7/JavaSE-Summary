package com.reflection.class_;
/*
    获取Class 类对象
    1.前提：已知一个类的全类名，且该类在类路径下，可通过Class类的静态方法 forName() 获取，可能抛出 ClassNotFoundException，实例:
    Class cls1 = Class.forName("java.lang.Cat");
    应用场景：多用于配置文件,读取类全路径,加载类.
    2.前提：若已知具体的类，通过类的 class 获取，该方式最为安全可靠，程序性能最高，实例：
    Class cls2 = Cat.class
    应用场景:多用于参数传递，比如通过反射得到对应构造器对象.
    3.前提:已知某个类的实例，调用该实例的 getClass() 方法获取Class对象，实例:
    Class clazz =对象.getClass();//运行类型
    应用场景:通过创建好的对象，获取Class对象.
    4.其他方式
    ClassLoader cls =对象.getClass(.getClassLoader);
    Class clazz4 = cl.loadClass(“类的全类名”);
    5.基本数据 (int, char,boolean.float,double,byte,long,short) 按如下方式得到Class类对象：
    Class cls =基本数据类型.class
    6.基本数据类型对应的包装类,可以通过.TYPE得到Class类对象：
    Class cls = 包装类.TYPE
 */
/**
 * 演示得到Class对象的各种方式(6)
 */
public class GetClass_ {
    public static void main(String[] args) throws ClassNotFoundException {

        //1. Class.forName
        String classAllPath = "com.reflection.Car"; //通过读取配置文件获取
        Class<?> cls1 = Class.forName(classAllPath);
        System.out.println(cls1);

        //2. 类名.class , 应用场景: 用于参数传递（例如前面通过反射得到构造器对象 传入参数就是 类名.class）
        Class cls2 = Car.class;
        System.out.println(cls2);

        //3. 对象.getClass(), 应用场景，有对象实例
        Car car = new Car();
        Class cls3 = car.getClass();
        System.out.println(cls3);

        //4. 通过类加载器【有4种类加载器】来获取到类的Class对象
        //(1)先得到类加载器 car
        ClassLoader classLoader = car.getClass().getClassLoader();
        //(2)通过类加载器得到Class对象
        Class cls4 = classLoader.loadClass(classAllPath);
        System.out.println(cls4);

        //cls1 , cls2 , cls3 , cls4 其实是同一个对象，因为一个类只能有一个class对象
        System.out.println(cls1.hashCode());
        System.out.println(cls2.hashCode());
        System.out.println(cls3.hashCode());
        System.out.println(cls4.hashCode());

        //5. 基本数据(int, char,boolean,float,double,byte,long,short) 按如下方式得到Class类对象
        Class<Integer> integerClass = int.class;
        Class<Character> characterClass = char.class;
        Class<Boolean> booleanClass = boolean.class;
        System.out.println(integerClass);//int

        //6. 基本数据类型对应的包装类，可以通过 .TYPE 得到Class类对象
        Class<Integer> type1 = Integer.TYPE;
        Class<Character> type2 = Character.TYPE; //其它包装类BOOLEAN, DOUBLE, LONG,BYTE类似
        System.out.println(type1);

        System.out.println(integerClass.hashCode());// 是同一个
        System.out.println(type1.hashCode());// 是同一个
    }
}

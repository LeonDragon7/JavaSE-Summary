package com.oop.centre;

import com.oop.centre.polyparameter.Employee;
import com.oop.centre.polyparameter.Manager;
import com.oop.centre.polyparameter.Worker;

/*
    面向对象编程-多态
    多态的应用
    2）多态参数
    方法定义的形参类型为父类类型，实参类型允许为子类类型
 */
public class PolyParameter {
    public static void main(String[] args) {
        /*
        应用实例1：前面的主人喂动物
        应用实例2：
        定义员工Employee，包含姓名和月工资[private]，以及计算年工资getAnnual
        的方法。普通员工和经理继承了员工，经理类多了奖金bonus属性和管理manage方
        法，普通员工类多了work方法，普通员工和经理类要求分别重写getAnnual方法

        测试类中添加了一个方法showEmpAnnual(Employee e),实现获取任何员工对象的年
        工资，并在Main方法中调用该方法[e.getAnnual()]

        测试类中添加一个方法，testWork，如果是普通员工，则调用work方法，如果是经
        理，则调用manage方法

        转到package com.objectoriented.centre.polyparameter;
         */
        Worker tom = new Worker("汤姆", 2500);
        Manager milan = new Manager("milan", 5000, 200000);
        PolyParameter parameter = new PolyParameter();
        parameter.showEmpAnnual(tom);
        parameter.showEmpAnnual(milan);

        parameter.testWork(tom);
        parameter.testWork(milan);
    }
    public void showEmpAnnual(Employee e){
        System.out.println(e.getAnnual());
    }
    public void testWork(Employee e){
        if(e instanceof Worker){
            ((Worker) e).work();
        } else if (e instanceof Manager) {
            ((Manager) e).manage();
        }else{
            System.out.println("预处理");
        }
    }
}

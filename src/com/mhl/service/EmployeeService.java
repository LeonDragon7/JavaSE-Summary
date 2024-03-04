package com.mhl.service;

import com.mhl.dao.EmployeeDAO;
import com.mhl.domain.Employee;

/**
 * 该类完成对employee表的各种操作（通过调用employeeDAO对象完成）
 */
public class EmployeeService {
    //定义一个EmployeeDAO属性
    private EmployeeDAO employeeDAO = new EmployeeDAO();

    //根据empId和pwd返回一个Employee对象
    //如果查询不到，就返回null
    public Employee getEmployeeByIdPwd(String empId,String pwd){
        return employeeDAO.querySingle("select * from employee where empId = ? and pwd = md5(?)", Employee.class, empId, pwd);
    }
}

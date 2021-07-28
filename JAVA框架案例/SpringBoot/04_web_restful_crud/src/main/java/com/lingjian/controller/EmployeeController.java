package com.lingjian.controller;

import com.lingjian.dao.DepartmentDao;
import com.lingjian.dao.EmployeeDao;
import com.lingjian.domain.Department;
import com.lingjian.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * @description: 员工的表现层
 * @author: Ling Jian
 * @date: 2020-03-19 16:10
 **/
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private DepartmentDao departmentDao;

    //查询所有员工返回列表页面
    //thymeleaf默认会拼串
//    public static final String DEFAULT_PREFIX = "classpath:/templates/";
//    public static final String DEFAULT_SUFFIX = ".html";
    @GetMapping("/emps")
    public String list(Model model) {
        Collection<Employee> employees = employeeDao.getAll();
        //放在请求域中
        model.addAttribute("emps", employees);
        return "emp/list";

    }

    //来到员工添加页面
    @GetMapping("/emp")
    public String toAddPage(Model model) {
        //查出所有的部门 在页面显示
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);
        return "emp/add";
    }

    //添加员工
    //SpringMvc自动将请求参数和入参对象的属性进行一一绑定
    //要求请求参数的名字和javaBean入参的对象里面的属性名是一样的
    @PostMapping("/emp")
    public String addEmp(Employee employee) {
        System.out.println(employee);
        //保存员工
        employeeDao.save(employee);
        //来到员工列表页面
        //redirect 表示重定向一个地址 //代表当前项目路径
        //forward 表示转发到一个地址
        return "redirect:/emps";
    }

    //修改页面
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id, Model model) {
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp", employee);

        //查出所有的部门 在页面显示
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);
        //回到修改页面
        return "emp/add"; //add页面是一个修改添加二合一的页面
    }

    //员工修改
    @PutMapping("/emp")
    public String updateEmployee(Employee employee) {
        System.out.println(employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    //员工删除
    @DeleteMapping("/emp/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id) {
        employeeDao.delete(id);
        return "redirect:/emps";
    }

}

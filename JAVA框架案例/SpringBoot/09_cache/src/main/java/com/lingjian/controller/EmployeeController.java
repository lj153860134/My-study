package com.lingjian.controller;

import com.lingjian.domain.Employee;
import com.lingjian.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 员工的表现层
 * @author: Ling Jian
 * @date: 2020-03-23 21:42
 **/
@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService ;

    @GetMapping("/emp/{id}")
    public Employee getEmp(@PathVariable("id") Integer id){
        Employee employee = employeeService.getEmp(id);
        return employee;
    }

    @GetMapping("/emp")
    public Employee update(Employee employee){
        return employeeService.updateEmp(employee);
    }

    @GetMapping("delete")
    public String deleteEmp(Integer id) {
        employeeService.deleteEmp(id);
        return "delete successfully";
    }

    @GetMapping("/emp/lastName/{lastName}")
    public Employee getEmpByLastName(@PathVariable("lastName") String lastName) {
        return employeeService.getEmpByLastName(lastName);
    }

}

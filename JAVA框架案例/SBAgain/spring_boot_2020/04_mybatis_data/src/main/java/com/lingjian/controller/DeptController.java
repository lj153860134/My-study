package com.lingjian.controller;

import com.lingjian.dao.IDepartmentDao;
import com.lingjian.domain.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description: 部门的表现层
 * @author: Ling Jian
 * @date: 2020-06-30 10:39
 **/
@RestController
public class DeptController {

    @Autowired
    IDepartmentDao departmentDao;


    @GetMapping("/dept/{id}")
    public Department getDepartment(@PathVariable("id") Integer id) {
        return departmentDao.getDeptById(id);
    }

    @GetMapping("/dept")
    public Department insertDept(Department department) {
        Integer id = departmentDao.insertDept(department);
        return department;
    }
}

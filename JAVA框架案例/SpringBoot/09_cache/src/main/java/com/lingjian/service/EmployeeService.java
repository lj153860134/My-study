package com.lingjian.service;

import com.lingjian.domain.Employee;
import com.lingjian.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @description: 员工的业务层
 * @author: Ling Jian
 * @date: 2020-03-23 21:33
 **/
@Service
public class EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;


    @Cacheable(cacheNames = {"emps"})
    //将方法的运行的结果进行缓存 以后要用相同的数据
    // 直接从缓存中获取 不用调用方法
    public Employee getEmp(Integer id) {
        System.out.println("查询"+id+"号员工：");
        Employee employee = employeeMapper.getEepById(id);
        return employee;
    }

    @CachePut(value = "emps",key = "#result.id")
    public Employee updateEmp(Employee employee) {
        System.out.println("updateEmp:"+employee);
        employeeMapper.updateEmp(employee);
        return employee;
    }

    @CacheEvict(value = "emps",key="#id",beforeInvocation = true)
    public void deleteEmp(Integer id) {
        System.out.println("删除"+id+"号员工信息");
//        int a =10/0;
//        employeeMapper.deleteEmpById(id);
    }

    @Caching(
            cacheable = {
                    @Cacheable(value="emps",key="#lastName")
            },
            put = {
                    @CachePut(value="emps",key="#result.id"),
                    @CachePut(value="emps",key="#result.gender")
            }
    )
    public Employee getEmpByLastName(String lastName) {
        System.out.println("查询"+lastName+"的员工信息");
        Employee employee = employeeMapper.getEmpByName(lastName);
        return employee;
    }
}

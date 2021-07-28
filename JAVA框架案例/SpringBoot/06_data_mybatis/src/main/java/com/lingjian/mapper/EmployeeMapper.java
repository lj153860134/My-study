package com.lingjian.mapper;

import com.lingjian.domain.Employee;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Component;

/**
 * @description: 对数据库员工的操作类mapper
 * @author: Ling Jian
 * @date: 2020-03-22 20:06
 **/
//@Component
public interface EmployeeMapper {
//    @Select("select * from employee where id=#{id}")
    Employee getEmpById(Integer id);

//    @Insert("insert into employee(lastName,email,gender,d_id) values(#{lastName},#{email},#{gender},#{d_id})")
    void insertEmp(Employee employee);
}

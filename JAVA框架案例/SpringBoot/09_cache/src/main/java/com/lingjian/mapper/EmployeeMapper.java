package com.lingjian.mapper;

import com.lingjian.domain.Employee;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

/**
 * @description: 数据库员工的操作类
 * @author: Ling Jian
 * @date: 2020-03-23 16:30
 **/
//@Mapper
    @Repository
public interface EmployeeMapper {

    @Select("select * from employee where id=#{id}")
    Employee getEepById(Integer id);

    @Update("update employee set lastName=#{lastName},email=#{email},gender=#{gender},d_id=#{dId} where id=#{id}")
    void updateEmp(Employee employee);

    @Delete("delete from employee where id=#{id}")
    void deleteEmpById(Integer id);

    @Insert("insert into employee(lastName,email,gender,d_id) values(#{lastName},#{email},#{gender},#{dId})")
    void insertEmp(Employee employee);

    @Select("select * from employee where lastName=#{lastName}")
    Employee getEmpByName(String lastName);
}

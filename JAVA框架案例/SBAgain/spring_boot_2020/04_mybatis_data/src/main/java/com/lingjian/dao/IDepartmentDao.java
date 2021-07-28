package com.lingjian.dao;

import com.lingjian.domain.Department;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

/**
 * @description: 部门的持久层接口
 * @author: Ling Jian
 * @date: 2020-06-30 10:30
 **/
@Mapper
public interface IDepartmentDao {

    @Select("select * from department where id=#{id}")
    Department getDeptById(Integer id);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Delete("delete from department where id=#{id}")
    int deleteDeptById(Integer id);

    @Insert("insert into department(department_name) values(#{departmentName})")
    int insertDept(Department department);

    @Update("update department set department_name=#{departmentName} where id=#{id}")
    int updateDept(Department department);

}

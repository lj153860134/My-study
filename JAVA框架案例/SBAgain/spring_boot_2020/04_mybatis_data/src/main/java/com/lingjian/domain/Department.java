package com.lingjian.domain;

/**
 * @description: 部门的实体类
 * @author: Ling Jian
 * @date: 2020-06-30 10:28
 **/
public class Department {
    private Integer id;
    private String departmentName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}

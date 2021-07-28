package com.lingjian.domain;

/**
 * @description: 部门的实体类
 * @author: Ling Jian
 * @date: 2020-03-23 16:25
 **/
public class Department {

    private Integer id;
    private String departmentName;


    public Department() {
        super();

    }

    public Department(Integer id, String departmentName) {
        super();
        this.id = id;
        this.departmentName = departmentName;
    }

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

    @Override
    public String toString() {
        return "Department [id=" + id + ", departmentName=" + departmentName + "]";
    }
}

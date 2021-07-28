package com.lingjian_1.dao;

import com.lingjian_1.domain.Role;

import java.util.List;

/**
 * @description:
 * @author: Ling Jian
 * @date: 2020-02-08 19:27
 **/
public interface IRoleDao {

    /**
     * 查询所有角色
     * @return
     */
    List<Role> findAll();
}

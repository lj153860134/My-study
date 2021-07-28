package com.lingjian.repository;

import com.lingjian.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @description: 用户的操作类 就是以前用的Dao类
 * @author: Ling Jian
 * @date: 2020-03-23 10:11
 **/

//继承JpaRepository 完成对数据库的操作
public interface UserRepository extends JpaRepository<User,Integer> {

}

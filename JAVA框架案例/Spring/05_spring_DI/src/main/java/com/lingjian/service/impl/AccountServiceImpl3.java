package com.lingjian.service.impl;

import com.lingjian.service.IAccountService;

import java.util.*;


/**
 * @description: 账户业务层实现类
 * @author: Ling Jian
 * @date: 2020-02-10 11:04
 **/
public class AccountServiceImpl3 implements IAccountService {

    private String[] myStrs;
    private List<String> list;
    private Set<String> set;
    private Map<String,String> map;
    private Properties props;

    public void setMyStrs(String[] myStrs) {
        this.myStrs = myStrs;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public void setProps(Properties props) {
        this.props = props;
    }

    public void saveAccount() {
        System.out.println(Arrays.toString(myStrs));
        System.out.println(list);
        System.out.println(set);
        System.out.println(map);
        System.out.println(props);
    }


}
package com.lingjian_1.domain;

import java.util.List;

/**
 * @description:
 * @author: Ling Jian
 * @date: 2020-02-08 14:56
 **/
public class QueryVo {
    private User user;

    private List<Integer> ids;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }



    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }
}

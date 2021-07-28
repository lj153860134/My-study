package com.lingjian_1.mybatis.cfg;

/**
 * @description: 用于封装SQL语句和结果类型的全限定类名
 * @author: Ling Jian
 * @date: 2020-01-13 17:11
 **/
public class Mapper {
    private String queryString; //SQL语句
    private String resultType;  //实体类的全限定类名

    public String getQueryString() {
        return queryString;
    }

    public void setQueryString(String queryString) {
        this.queryString = queryString;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }
}

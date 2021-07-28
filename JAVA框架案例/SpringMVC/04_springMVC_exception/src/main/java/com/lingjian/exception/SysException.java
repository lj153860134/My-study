package com.lingjian.exception;

/**
 * @description: 自定义异常类
 * @author: Ling Jian
 * @date: 2020-02-24 16:35
 **/
public class SysException extends Exception {

    //存储提示信息
    private String message;

    public SysException() {
    }

    public SysException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

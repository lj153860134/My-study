package com.lingjian.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @description: 字符串转换成日期
 * @author: Ling Jian
 * @date: 2020-02-22 15:59
 **/
public class StringToDateConverter implements Converter<String, Date> {
    /**
     *
     * @param source 传入的字符串
     * @return
     */
    @Override
    public Date convert(String source) {
        if(source==null){
            throw new RuntimeException("请传入数据");
        }
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        //把字符串转换日期
        try {
            Date date = df.parse(source);
            return date;
        } catch (ParseException e) {
            throw new RuntimeException("数据类型转换错误");

        }

    }
}

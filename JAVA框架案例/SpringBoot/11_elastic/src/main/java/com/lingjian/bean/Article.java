package com.lingjian.bean;

/**
 * @description: 文章的实体类
 * @author: Ling Jian
 * @date: 2020-03-27 09:27
 **/
public class Article {
    private Integer id;
    private String author;
    private String title;
    private String content;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

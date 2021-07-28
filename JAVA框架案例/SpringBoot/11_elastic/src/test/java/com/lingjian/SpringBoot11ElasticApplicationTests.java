package com.lingjian;

import com.lingjian.bean.Article;
import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class SpringBoot11ElasticApplicationTests {


    @Autowired
    JestClient jestClient ;
    @Test
    void contextLoads() {
        //给Es中索引（保存）一个文档
        Article article = new Article();
        article.setId(1);
        article.setTitle("凌健爱徐小萌");
        article.setAuthor("凌健");
        article.setContent("依然爱你");

        //构建一个索引
        Index index =  new Index.Builder(article).index("lingjian").type("news").id("1").build();

        try {
            jestClient.execute(index);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    //测试搜索
    @Test
    public void test1(){

    }

}

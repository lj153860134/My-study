package com.lingjian;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.internet.MimeMessage;
import java.io.File;

@SpringBootTest
class SpringBoot12TaskApplicationTests {
    @Autowired
    JavaMailSender javaMailSender;

    @Test
    void contextLoads() {
        SimpleMailMessage message = new SimpleMailMessage();
        //邮件设置
        message.setSubject("凌健❤️徐小萌");
        message.setText("凌健最爱的人是徐小萌哦");
        message.setTo("220181593@seu.edu.cn");
        message.setFrom("153860134@qq.com");
        javaMailSender.send(message);
    }

    @Test
    public void test1() throws Exception{
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        //邮件设置
        helper.setSubject("凌健❤️徐小萌");
        helper.setText("<b style='color:red'>凌健最爱的人是徐小萌哦</b>",true);
        helper.setTo("220181593@seu.edu.cn");
        helper.setFrom("153860134@qq.com");

        //上传文件
        helper.addAttachment("IMG_5447.jpeg",new File("/Users/lingjian/Desktop/IMG_5447.jpeg"));
        javaMailSender.send(message);

    }

}

package cn.lingjian_6;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author lingjian
 * @date 2019/10/24 - 7:43 下午
 */
/*
* 在文本框里面只能输入数字字符案例
* 若输入非数字 取消你键盘录入的效果
* */
public class FrameDemo {
    public static void main(String[] args) {
        //设置窗体对象并设置属性
        Frame f=new Frame("不能输入非数字字符");
        f.setBounds(200,200,400,400);
        f.setLayout(new FlowLayout());

        //创建Label标签对象
        Label l=new Label("输入你的QQ号 你输入非数字试试看");
        TextField tf=new TextField(40);

        //添加到窗体上
        f.add(l);
        f.add(tf);

        //给文本框添加键盘事件
        tf.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                //如果字符不是数字字符 就取消事件
                //思路：获取字符 判断字符 取消事件
                char ch=e.getKeyChar();
                if(ch<'0'||ch>'9'){
                   e.consume();
                }
            }
        });
        //设置窗体关闭
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        //设置窗体可见
        f.setVisible(true);
    }
}

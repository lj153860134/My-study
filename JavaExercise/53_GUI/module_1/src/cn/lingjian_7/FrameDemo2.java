package cn.lingjian_7;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

/**
 * @author lingjian
 * @date 2019/10/24 - 8:44 下午
 */
/*
* 多级菜单案例
* */
public class FrameDemo2 {
    public static void main(String[] args) {
        //设置窗体大小和属性
        Frame f=new Frame("多级菜单");
        f.setBounds(200,200,300,400);
        f.setLayout(new FlowLayout());
        String s=f.getTitle();

        //设置菜单
        //创建菜单条
        MenuBar mb=new MenuBar();
        //创建菜单
        Menu m=new Menu("文件");
        //创建一级菜单
        Menu mi1=new Menu("更改名称");

        //创建二级菜单栏
        MenuItem mi11=new MenuItem("好好学习");
        MenuItem mi12=new MenuItem("天天向上");
        MenuItem mi13=new MenuItem("恢复标题");

        MenuItem mi2=new MenuItem("打开记事本");
        MenuItem mi3=new MenuItem("退出系统");

        //将二级菜单栏添加到一级菜单
        mi1.add(mi11);
        mi1.add(mi12);
        mi1.add(mi13);



        //各级菜单添加进去
        m.add(mi1);
        m.add(mi2);
        m.add(mi3);
        mb.add(m);

        //设置菜单栏到窗体
        f.setMenuBar(mb);

        //设置窗体关闭
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        mi2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Runtime r=Runtime.getRuntime();
                try {
                    r.exec("date");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        mi3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });


        mi11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setTitle(mi11.getLabel());
            }
        });

        mi12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setTitle(mi12.getLabel());
            }
        });

        mi13.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setTitle(s);
            }
        });

        //设置窗体可见
        f.setVisible(true);
    }
}

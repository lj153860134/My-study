package cn.lingjian_7;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author lingjian
 * @date 2019/10/24 - 8:29 下午
 */
/*
* 一级菜单
* */
public class FrameDemo {
    public static void main(String[] args) {
        //设置窗体大小和属性
        Frame f=new Frame("一级菜单");
        f.setBounds(200,200,400,400);
        f.setLayout(new FlowLayout());

        //设置菜单
        //创建菜单条
        MenuBar mb=new MenuBar();
        //创建菜单
        Menu m=new Menu("文件");
        //创建菜单栏
        MenuItem mi1=new MenuItem("哈哈");
        MenuItem mi2=new MenuItem("呵呵");
        MenuItem mi3=new MenuItem("嘿嘿");

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

        mi1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        //设置窗体可见
        f.setVisible(true);
    }
}

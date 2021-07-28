package cn.lingjian_3;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author lingjian
 * @date 2019/10/24 - 9:42 上午
 */
/*
 * 需求：把按钮添加到窗体 并对按钮添加一个点击事件
 *
 * */
public class FrameDemo {
    public static void main(String[] args) {
        Frame f = new Frame("按钮点击");
        f.setBounds(200, 400, 300, 300);

        //设置布局为流式布局
        f.setLayout(new FlowLayout());

        //创建按钮对象
        Button bu = new Button("凌健");
//        bu.setSize(40,10);


        //把按钮添加到窗体
        f.add(bu);

        //设置窗体可以关闭
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        bu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("爱徐小萌");
            }
        });
        f.setVisible(true);

    }
}

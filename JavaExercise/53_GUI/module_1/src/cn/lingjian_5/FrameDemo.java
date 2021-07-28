package cn.lingjian_5;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author lingjian
 * @date 2019/10/24 - 10:53 上午
 */
/*
* 通过鼠标移动到按钮上更改背景色
* */
public class FrameDemo {
    public static void main(String[] args) {
        Frame f=new Frame("colour");
        f.setBounds(300,300,500,500);
        f.setLayout(new FlowLayout());

        Button bu1=new Button("red");
        Button bu2=new Button("green");
        Button bu3=new Button("blue");
        Button bu4=new Button("recovery");

        f.add(bu1);
        f.add(bu2);
        f.add(bu3);
        f.add(bu4);

        bu1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            f.setBackground(Color.RED);
            }
        });

        bu2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setBackground(Color.GREEN);
            }
        });

        bu3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setBackground(Color.BLUE);
            }
        });

        bu4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setBackground(Color.WHITE);
            }
        });

        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        f.setVisible(true);
    }
}

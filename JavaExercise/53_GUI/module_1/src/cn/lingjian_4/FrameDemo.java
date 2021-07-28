package cn.lingjian_4;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author lingjian
 * @date 2019/10/24 - 10:09 上午
 */
public class FrameDemo {
    public static void main(String[] args) {
        //创建窗体对象
        Frame f=new Frame("哈哈");

        //设置窗体属性和布局
        f.setBounds(400,200,600,300);
        f.setLayout(new FlowLayout());

        //设置文本框
        TextField tf=new TextField(20);

        //创建按钮
        Button bu=new Button("数据转移");

        //创建文本域
        TextArea ta=new TextArea(10,40);

        //把组件添加到窗体
        f.add(tf);
        f.add(bu);
        f.add(ta);

        //设置窗体可以关闭
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        //对按钮添加事件
        bu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //获取文本框的值
                String tf_str=tf.getText().trim();
                //清空数据（就是把数据设置为空）
                tf.setText("");

                //设置给文本域
//                ta.setText(tf_str); //自动替换前面
                ta.append(tf_str+"\n");    //后面自动添加和换行
                //获取光标
                tf.requestFocus();
            }
        });

        //设置窗体可见
        f.setVisible(true);

    }
}

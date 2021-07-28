package cn.lingjian_1;

/**
 * @author lingjian
 * @date 2019/10/16 - 7:39 下午
 */
/*
 *
 * 实现多线程程序
 * */
public class MyThreadDemo1 {
    public static void main(String[] args) {
        //无参构造+setName()
        MyThread my1 = new MyThread();
        MyThread my2 = new MyThread();
        my1.setName("凌健");
        my2.setName("徐小萌");
        System.out.println(my1.getName());
        System.out.println(my2.getName());

        //带参构造给线程起名字
        MyThread my3=new MyThread("王杰");
        MyThread my4=new MyThread("凌立宏");

        //返回该main方法所在线程对象的名称
        System.out.println(Thread.currentThread().getName());

//     my1.start();
//     my2.start();
    }
}


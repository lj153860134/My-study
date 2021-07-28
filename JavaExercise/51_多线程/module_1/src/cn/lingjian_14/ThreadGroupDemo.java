package cn.lingjian_14;

/**
 * @author lingjian
 * @date 2019/10/22 - 3:53 下午
 */
public class ThreadGroupDemo {
    public static void main(String[] args) {
//        method1();
        method2();
    }

    private static void method2() {
        ThreadGroup tg=new ThreadGroup("新组");
        MyRunable mr=new MyRunable();
        //Thread的第三种构造方法
        Thread t1=new Thread(tg,mr,"凌健");
        Thread t2=new Thread(tg,mr,"王杰");

        System.out.println(t1.getThreadGroup().getName());
        System.out.println(t2.getThreadGroup().getName());




    }

    private static void method1() {
        MyRunable mr=new MyRunable();
        Thread t1=new Thread(mr,"凌健");
        Thread t2=new Thread(mr,"王杰");

        ThreadGroup tg1=t1.getThreadGroup();
        ThreadGroup tg2=t2.getThreadGroup();
        System.out.println(tg1.getName());
        System.out.println(tg2.getName());
        System.out.println(Thread.currentThread().getThreadGroup().getName());

    }
}

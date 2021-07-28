package cn.lingjian_2;

/**
 * @author lingjian
 * @date 2019/10/21 - 4:38 下午
 */
public class ThreadPriorityDemo1 {
    public static void main(String[] args) {

        ThreadPriority tp1 = new ThreadPriority();
        ThreadPriority tp2 = new ThreadPriority();
        ThreadPriority tp3 = new ThreadPriority();

        //设置线程优先级
        tp1.setPriority(1000); //只能设置1--10之间

        //获取默认优先级
        System.out.println(tp1.getPriority());
//        System.out.println(tp2.getPriority());
//        System.out.println(tp3.getPriority());

//        tp1.start();
//        tp2.start();
//        tp3.start();
    }

}

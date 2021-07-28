package cn.lingjian_4;

/**
 * @author lingjian
 * @date 2019/10/21 - 7:44 下午
 */
public class ThreadJoinDemo {
    public static void main(String[] args) throws InterruptedException {
        ThreadJoin tj1=new ThreadJoin("凌健");
        ThreadJoin tj2=new ThreadJoin("凌立宏");
        ThreadJoin tj3=new ThreadJoin("王小龙");

        tj1.start();
        tj1.join();
        tj2.start();
        tj3.start();
    }

}

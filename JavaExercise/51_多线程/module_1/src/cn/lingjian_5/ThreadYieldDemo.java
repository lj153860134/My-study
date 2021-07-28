package cn.lingjian_5;

/**
 * @author lingjian
 * @date 2019/10/21 - 7:48 下午
 */
public class ThreadYieldDemo {
    public static void main(String[] args) {
        ThreadYield ty1=new ThreadYield("凌健");
        ThreadYield ty2=new ThreadYield("凌立宏");
        ThreadYield ty3=new ThreadYield("A哥");

        ty1.start();
        ty2.start();
        ty3.start();

    }
}

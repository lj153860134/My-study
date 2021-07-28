package cn.lingjian_11;

/**
 * @author lingjian
 * @date 2019/10/22 - 10:47 上午
 */
public class DieLockDemo {
    public static void main(String[] args) {
        DieLock dl1=new DieLock(true);
        DieLock dl2=new DieLock(false);

        dl1.start();
        dl2.start();
    }
}

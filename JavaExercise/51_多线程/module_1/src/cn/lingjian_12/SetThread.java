package cn.lingjian_12;

/**
 * @author lingjian
 * @date 2019/10/22 - 11:07 上午
 */
public class SetThread implements Runnable {

    private Student s;
    private int x=0;

    public SetThread(Student s) {
        this.s = s;
    }

    @Override
    public void run() {
        while(true) {
            synchronized (s) {
                if (x % 2 == 0) {
                    s.name = "凌健";
                    s.age = 25;
                } else {
                    s.name = "徐小萌";
                    s.age = 24;
                }
                x++;
            }
        }

    }
}

package cn.lingjian_15;

/**
 * @author lingjian
 * @date 2019/10/22 - 11:07 上午
 */
public class SetThread implements Runnable {

    private Student s;
    private int x = 0;

    public SetThread(Student s) {
        this.s = s;
    }

    @Override
    public void run() {
        while (true) {

            if (x % 2 == 0) {
                s.set("凌健",25);

            } else {
                s.set("徐小萌",24);
            }
            x++;

        }

    }
}




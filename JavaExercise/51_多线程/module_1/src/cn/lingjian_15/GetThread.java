package cn.lingjian_15;

/**
 * @author lingjian
 * @date 2019/10/22 - 11:07 上午
 */
public class GetThread implements Runnable {

    private Student s;

    public GetThread(Student s) {
        this.s = s;
    }

    @Override
    public void run() {
        while (true) {

            s.get();
        }
    }
}

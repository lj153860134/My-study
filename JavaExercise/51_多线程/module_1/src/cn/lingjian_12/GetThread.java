package cn.lingjian_12;

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
        while(true) {
            synchronized (s) {
                System.out.println(s.name + "----" + s.age);
            }
        }
    }
}

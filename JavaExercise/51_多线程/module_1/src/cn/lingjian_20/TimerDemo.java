package cn.lingjian_20;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author lingjian
 * @date 2019/10/22 - 8:38 下午
 */
public class TimerDemo {
    public static void main(String[] args) {
        Timer t=new Timer();
        t.schedule(new MyTask(t),3000);
    }
}

//做一个任务
class MyTask extends TimerTask{
    private Timer t;

    public MyTask(Timer t) {
        this.t = t;
    }

    @Override
    public void run() {
        System.out.println("boom");
        t.cancel();
    }
}

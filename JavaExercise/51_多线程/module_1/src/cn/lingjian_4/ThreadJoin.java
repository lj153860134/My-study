package cn.lingjian_4;

/**
 * @author lingjian
 * @date 2019/10/21 - 7:43 下午
 */
public class ThreadJoin extends Thread{
    public ThreadJoin() {
    }

    public ThreadJoin(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i <100 ; i++) {
            System.out.println(getName()+":"+i);
        }
    }
}

package cn.lingjian_18;

import java.util.concurrent.Callable;

/**
 * @author lingjian
 * @date 2019/10/22 - 7:46 下午
 */
public class MyCallable implements Callable<Integer> {
    private int number;

    public MyCallable(int number) {
        this.number = number;
    }

    @Override
    public Integer call() throws Exception {
        int sum=0;
        for (int i = 1; i <=number ; i++) {
            sum+=i;
        }
        return sum;
    }
}

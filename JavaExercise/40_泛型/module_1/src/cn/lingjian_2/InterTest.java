package cn.lingjian_2;

/**
 * @author lingjian
 * @date 2019-09-17 - 19:31
 */
public class InterTest<T> implements Inter<T> {
    @Override
    public void show(T t) {
        System.out.println(t);
    }
}

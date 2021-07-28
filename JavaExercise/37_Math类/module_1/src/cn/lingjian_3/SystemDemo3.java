package cn.lingjian_3;

/**
 * @author lingjian
 * @date 2019-09-11 - 16:11
 */
public class SystemDemo3 {
    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
        long start=System.currentTimeMillis();
        for (int i = 0; i <100000 ; i++) {
            System.out.println(i);
        }
        long end=System.currentTimeMillis();
        System.out.println((end-start)+"ms");
    }

}

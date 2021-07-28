package cn.lingjian_3;

/**
 * @author lingjian
 * @date 2019/11/5 - 10:07 上午
 */
public class PrintableDemo {
    public static void main(String[] args) {
//        usePrintable((s)->{
//            System.out.println(s);
//        });

        //最优 最简化版
//        usePrintable(s->
//                System.out.println(s)
//        );

        //方法引用符
        usePrintable(System.out::println);
    }

    private static void usePrintable(Printable p){
        System.out.println("我爱徐小萌");
    }

}

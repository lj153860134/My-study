package cn.lingjian_10;

import java.util.function.Function;

/**
 * @author lingjian
 * @date 2019/11/5 - 7:59 下午
 */
public class FunctionDemo {
    public static void main(String[] args) {
        convert(100, i-> String.valueOf(i));

        method("100",s->Integer.parseInt(s),i->String.valueOf(i+566) );
    }

    private static void convert(int i, Function<Integer,String> fun){
        String s=fun.apply(i);
        System.out.println(s);
    }

    private static void method(String str,Function<String,Integer> fun1,Function<Integer,String> fun2){
        String s=fun1.andThen(fun2).apply(str);
        System.out.println(s);
    }
}

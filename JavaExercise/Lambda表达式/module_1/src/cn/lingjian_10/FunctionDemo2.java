package cn.lingjian_10;

import java.util.function.Function;

/**
 * @author lingjian
 * @date 2019/11/5 - 8:30 下午
 */
public class FunctionDemo2 {
    public static void main(String[] args) {
        method("凌健,25",s->Integer.parseInt(s.split(",")[1]),i -> i+70);

    }

    private static void method(String str, Function<String,Integer> fun1,Function<Integer,Integer> fun2){
        int i=fun1.andThen(fun2).apply(str);
        System.out.println(i);
    }
}

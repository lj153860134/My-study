package cn.lingjian_8;

import java.util.function.Consumer;

/**
 * @author lingjian
 * @date 2019/11/5 - 4:02 下午
 */
public class ConsumerDemo {
    public static void main(String[] args) {
        //定义一个字符串数组
        String[] strArray={"凌健,25","徐小萌,24","王杰,26"};
        printInfo(strArray,s -> {
            System.out.print("姓名: "+s.substring(0,s.indexOf(",")));
        },s -> {
                System.out.println(",年龄: "+s.substring(s.indexOf(",")+1,s.length()));
        });

    }

    private static void printInfo(String[] strArray, Consumer<String> con1, Consumer<String> con2){
        for (String s : strArray) {
            con1.andThen(con2).accept(s);
        }
    }
}

package cn.lingjian_2;

import java.util.*;
import java.util.stream.Stream;

/**
 * @author lingjian
 * @date 2019/11/6 - 11:01 上午
 */
public class StreamDemo {
    public static void main(String[] args) {
        //Collection集合的两个儿子可以使用默认方法stream()生成流
        List<String> list=new ArrayList<>();
        Stream<String> listStream = list.stream();

        Set<String> set=new HashSet<>();
        Stream<String> setStream = set.stream();

        //Map体系的集合间接生成流
        Map<String,Integer> map=new HashMap<String,Integer>();
        //键
        Stream<String> keyStream = map.keySet().stream();
        //值
        Stream<Integer> valueStream = map.values().stream();
        //键值对对象
        Stream<Map.Entry<String, Integer>> entryStream = map.entrySet().stream();

        //数组可以通过Stream接口的静态方法of（T...values）生成流
        String[] strArray={"12","34","56"};
        Stream<String> strArrayStream = Stream.of(strArray);

        Stream<String> strArrayStream2 = Stream.of("10,20,30");

        Stream<Integer> strArrayStream3 = Stream.of(10,20,30);

    }
}

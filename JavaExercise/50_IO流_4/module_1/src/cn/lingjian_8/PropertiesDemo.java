package cn.lingjian_8;

import java.util.Properties;
import java.util.Set;

/**
 * @author lingjian
 * @date 2019/10/15 - 10:56 上午
 */
public class PropertiesDemo {
    public static void main(String[] args) {
        Properties prop=new Properties();

        prop.put("凌健","徐小萌");
        prop.put("王杰","凌立宏");
        prop.put("王小龙","陈旭");

        //遍历集合
        Set<Object> set=prop.keySet();
        for (Object key : set) {
           Object value=prop.get(key);
            System.out.println(key+"----"+value);
        }

        System.out.println(prop);

    }
}

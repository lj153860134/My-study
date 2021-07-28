package cn.lingjian_8;

import java.util.Properties;
import java.util.Set;

/**
 * @author lingjian
 * @date 2019/10/15 - 5:03 下午
 */
public class PropertiesDemo2 {
    public static void main(String[] args) {
        Properties prop=new Properties();
        prop.setProperty("凌健","徐小萌");
        prop.setProperty("王杰","凌立宏");
        prop.setProperty("陈旭","王小龙");

        Set<String> set=prop.stringPropertyNames();
        for (String key : set) {
            String value=prop.getProperty(key);
            System.out.println(key+"------"+value);
        }

    }
}

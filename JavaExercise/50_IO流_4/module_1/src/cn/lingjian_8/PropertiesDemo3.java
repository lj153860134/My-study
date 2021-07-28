package cn.lingjian_8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

/**
 * @author lingjian
 * @date 2019/10/15 - 5:58 下午
 */
public class PropertiesDemo3 {
    public static void main(String[] args) throws IOException {
//       myLoad();
        myStore();

    }


    private static void myLoad() throws IOException {
        Properties prop = new Properties();
        prop.load(new FileReader("prop.txt"));
        Set<String> set = prop.stringPropertyNames();
        for (String key : set) {
            String value = prop.getProperty(key);
            System.out.println(key + "------" + value);
        }
    }

    private static void myStore() throws IOException {
        Properties prop = new Properties();
        prop.setProperty("凌健最爱的人", "徐小萌");
        prop.setProperty("王杰的儿子", "凌立宏");
        prop.setProperty("王杰的孙子", "王小龙");

        prop.store(new FileWriter("prop_write.txt"), "lover");

    }
}


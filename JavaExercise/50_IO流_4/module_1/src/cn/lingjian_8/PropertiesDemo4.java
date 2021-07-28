package cn.lingjian_8;

import java.io.*;
import java.util.Properties;
import java.util.Set;

/**
 * @author lingjian
 * @date 2019/10/15 - 6:29 下午
 */
/*
* 需求: 在user.txt中知道数据是键值对形式的，但不知道内容
*      写一个程序是否有“凌健”这样的键存在，有就将其值改为"徐小萌"
*
* */
public class PropertiesDemo4 {
    public static void main(String[] args) throws IOException {
        //把文件中的数据加载到集合中
        Reader r=new FileReader("user.txt");
        Properties prop=new Properties();
        prop.load(r);
        r.close();

        //遍历集合，获取得到每一个键
        Set<String> set=prop.stringPropertyNames();
        for (String key : set) {
            //判断
            if(key.equals("凌健")){
                prop.setProperty(key,"徐小萌");
                break;
            }
        }

        //把集合中的数据重新存储到文件中
        Writer w=new FileWriter("user.txt");
        prop.store(w,null);
        w.close();


    }
}

package cn.lingjian_2;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @author lingjian
 * @date 2019/10/31 - 11:09 上午
 */
/*
* 通过配置文件运行类中的方法
* */
public class Test {
    public static void main(String[] args) throws Exception {
        //加载键值对数据
        Properties prop=new Properties();
        FileReader fr=new FileReader("class.txt");
        prop.load(fr);
        fr.close();

        //获取数据
        String className=prop.getProperty("className");
        String methodName=prop.getProperty("methodName");

        //运用反射
        //获取字节码对象
        Class c=Class.forName(className);
        //创建对象
        Constructor con=c.getConstructor();
        Object obj=con.newInstance();

        //调用该对象的love的方法
        Method method=c.getMethod(methodName);
        method.invoke(obj);
    }
}

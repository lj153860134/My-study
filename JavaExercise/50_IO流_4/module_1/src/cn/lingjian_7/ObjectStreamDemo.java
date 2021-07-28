package cn.lingjian_7;

import java.io.*;

/**
 * @author lingjian
 * @date 2019/10/15 - 9:37 上午
 */
public class ObjectStreamDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //序列化数据就是把对象写到文本文件中
//        write();
        read();

    }


    private static void write() throws IOException {
        //创建序列化流对象
        ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("oos.txt"));

        //创建对象
        Person p1=new Person("凌健",25);
        Person p2=new Person("徐小萌",24);
        oos.writeObject(p1);
        oos.writeObject(p2);

        oos.flush();
        //释放资源
        oos.close();

    }

    private static void read() throws IOException, ClassNotFoundException {
        //创建反序列化对象
        ObjectInputStream ois=new ObjectInputStream(new FileInputStream("oos.txt"));
        //还原对象
        Object obj=null;
        obj=ois.readObject();
            System.out.println(obj);

        //释放资源
        ois.close();

    }
}

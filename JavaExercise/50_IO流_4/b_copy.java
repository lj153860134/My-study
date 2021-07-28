package cn.lingjian_1;

import java.io.*;

/**
 * @author lingjian
 * @date 2019/10/11 - 3:44 下午
 */
public class DateStreamDemo {
    public static void main(String[] args) throws IOException {
        DataOutputStream dos=new DataOutputStream(new FileOutputStream("a.txt"));
        DataInputStream dis=new DataInputStream(new FileInputStream("a.txt"));
        dos.writeByte(10);
        dos.writeShort(100);
        dos.writeInt(1000);
        dos.writeLong(1000000);
        dos.writeFloat(12.34F);
        dos.writeDouble(12.56);
        dos.writeChar('a');
        dos.writeBoolean(true);
        dos.close();

        System.out.println(dis.readByte());
        System.out.println(dis.readShort());
        System.out.println(dis.readInt());
        System.out.println(dis.readLong());
        System.out.println(dis.readFloat());
        System.out.println(dis.readDouble());
        System.out.println(dis.readChar());
        System.out.println(dis.readBoolean());
        dis.close();




    }
}

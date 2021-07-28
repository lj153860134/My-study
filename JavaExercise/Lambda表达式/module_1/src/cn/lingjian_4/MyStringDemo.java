package cn.lingjian_4;

/**
 * @author lingjian
 * @date 2019/11/5 - 10:59 上午
 */
public class MyStringDemo {
    public static void main(String[] args) {
        //Lambda
        useMyString((String s,int x,int y)->{
            return s.substring(x,y);
        });

        //Lambda简化版
        useMyString((s,x,y)-> s.substring(x,y));

        //引用类的实例方法
        useMyString(String::substring);

    }

    private static void useMyString(MyString my){
        String s=my.mySubString("lingjian",2,5);
        System.out.println(s);
    }
}

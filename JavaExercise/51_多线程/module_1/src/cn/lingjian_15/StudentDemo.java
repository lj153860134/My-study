package cn.lingjian_15;

/**
 * @author lingjian
 * @date 2019/10/22 - 11:07 上午
 */
public class StudentDemo {
    public static void main(String[] args) {

        //创建资源
        Student s=new Student();
        SetThread st=new SetThread(s);
        GetThread gt=new GetThread(s);

        Thread t1=new Thread(st);
        Thread t2=new Thread(gt);


        t1.start();
        t2.start();

    }
}

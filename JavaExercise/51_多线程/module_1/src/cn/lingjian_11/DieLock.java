package cn.lingjian_11;

/**
 * @author lingjian
 * @date 2019/10/22 - 10:50 上午
 */
public class DieLock extends Thread{

    private boolean flag;

    public DieLock(boolean flag){
        this.flag=flag;
    }
    @Override
    public void run() {
        if(flag){
            synchronized (MyLock.obj1){
                System.out.println("if obj1");
                synchronized (MyLock.obj2){
                    System.out.println("if obj2");
                }
            }
        }else{
            synchronized (MyLock.obj2){
                System.out.println("else obj2");
                synchronized (MyLock.obj1){
                    System.out.println("else obj1");
                }
            }
        }
    }
}

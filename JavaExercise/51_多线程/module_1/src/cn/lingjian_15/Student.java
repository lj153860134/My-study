package cn.lingjian_15;

/**
 * @author lingjian
 * @date 2019/10/22 - 11:06 上午
 */
public class Student {
    private String name;
    private int age;
    private boolean flag;//默认情况是没有数据的 如果是true  就有数据

    public synchronized void set(String name,int age){
        if(flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.name=name;
        this.age=age;
        //修改标记
        flag=true;
        this.notify();
    }

    public synchronized void get(){
        if(!flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(this.name+"----"+this.age);
        flag=false;
        this.notify();
    }
}

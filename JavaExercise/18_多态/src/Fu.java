public class Fu {
    public int num=10;
    public void show(){
        System.out.println("This is father");
    }
    public static void function(){
        System.out.println("function fu");
    }
}
class Zi extends Fu{
    public int num=100;
    public int num2=200;
    @Override
    public void show() {
        System.out.println("This is son");
    }
    public void method(){
        System.out.println("method Zi");
    }
    public static void function(){
        System.out.println("function zi");// 父类中静态方法 子类必须通过静态方法重写
                                          // 这个算不上方法重写 但是现象如此
    }
}
class DuoTaiDemo{
    public static void main(String[] args){
        Fu f=new Zi(); //多态要有父类的引用指向子类的对象
        System.out.println(f.num);
       // System.out.println(f.num2);  报错 找不到符号
        // 成员变量 编译看左边 运行看左边
        f.show();
        f.function();
        //f.method();   报错 还是找不符号
        //成员方法 编译看左边 运行看右边 因为存在方法重写
        Zi z=(Zi) f;
        z.method();
    }
}
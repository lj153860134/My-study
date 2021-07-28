//形式参数是数据类型
class Demo{
    public int sum(int a,int b){
        return a+b;
    }
}
//形式参数是引用类型
class Student1{
    public void show(){
        System.out.println("I love studying");
    }
}
class Student1Demo{
    //一个方法的形式参数是一个类类型（引用类型），这里其实需要的是该类的对象
    public void method(Student1 s){
        //调用的时候，把main方法的中的s地址传递到了这里
        s.show();
    }
}
class ArgsDemo {
    public static void main(String[] args){
        //形式参数是基本类型的调用
        Demo d=new Demo();
        int result=d.sum(10,20);
        System.out.println("result:"+result);
        //形式参数是引用类型的调用

        Student1Demo s1=new Student1Demo();
        //创建学生对象
        Student1 s=new Student1 ();
        s1.method(s);//把s的地址给盗了这里
    }
}

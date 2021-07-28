/*
* 静态代码块>>>        构造代码块          >>>构造方法
*（只调用一次） （构造一个对象都调用一次）
*
* */
class Student {
    static{
        System.out.println("静态代码块");
    }

    {
        System.out.println("构造代码块");
    }
    public Student(){
        System.out.println("构造方法 ");
    }
}

class StudentDemo{
    static{
        System.out.println("呵呵");
    }
    public static void main(String[] args){
        Student s1=new Student();
        Student s2=new Student();
        System.out.println("我是main方法");

    }
    static{
        System.out.println("哈哈");
    }
}
/*(结果）
* 呵呵
  哈哈
  静态代码块
  构造代码块
  构造方法
  构造代码块
  构造方法
  我是main方法
*/

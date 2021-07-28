public abstract class Person {

    public Person(){}

    public abstract void study();
}

class Student extends Person{
    public Student(){}

    @Override
    public void study() {
        System.out.println("good good study, day day up");
    }

}

class StudentDemo{
    public void method(Person p){
        p.study();
    }
}

class StudentDemo1{
    public Student function(){
        return  new Student();  //返回值为类名 直接用匿名对象
    }

}

class PersonTest{
    public static void main(String[] args){
        Person p=new Student();
        p.study();
        StudentDemo sd=new StudentDemo();
        sd.method(p);
        //调用study方法 不要用创建Student的对象
        StudentDemo1 sd1=new StudentDemo1();
        sd1.function().study();
    }
}
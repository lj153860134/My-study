interface Person{
    public abstract void study();
}

class PersonDemo{
    //接口名作为形式参数
    //其实这里需要的不是接口，而是该节后实现类的对象
    public void method(Person p){
        p.study();
    }
}

class Student implements Person{
    @Override
    public void study() {
        System.out.println("good good study,day day up");
    }
}

public class  InnerClass2 {
    public static void main(String[] args){
        PersonDemo pd=new PersonDemo();
        Person p=new Student();
        pd.method(p);
        System.out.println("--------");
        pd.method(new Person(){
            @Override
            public void study() {
                System.out.println("hehe");
            }
        });
    }
}

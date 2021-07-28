public class ExtendsDemo {
    public static void main(String[] args){
        Person p=new Person();
        p.eat();
        p.sleep();
        System.out.println("------");
        Student s=new Student();
        s.eat();
        s.sleep();
        s.study();
        System.out.println("------");
        Teacher t=new Teacher();
        t.eat();
        t.sleep();
        t.teach();

    }
}

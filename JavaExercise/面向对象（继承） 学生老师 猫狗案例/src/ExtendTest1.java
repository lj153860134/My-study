public class ExtendTest1 {
    public static void main(String[] args){
        Student s1=new Student();
        s1.setAge(24);
        s1.setName("徐小萌");
        System.out.println(s1.getName()+" "+s1.getAge());
        Student s2=new Student("凌健",25);
        System.out.println(s2.getName()+" "+s2.getAge());
    }
}

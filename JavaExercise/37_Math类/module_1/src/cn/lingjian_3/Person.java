package cn.lingjian_3;

/**
 * @author lingjian
 * @date 2019-09-11 - 15:20
 */
public class Person {
    private String name;
    private int age;

    public Person(){
        super();
    }

    public Person(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    public void setName(String name){
        this.name=name;
    }

    public String getName(){
        return name;
    }

    public void setAge(int age){
        this.age=age;
    }

    public int getAge(){
        return age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
    protected void finalize() throws Throwable{
        System.out.println("当前对象被回收了"+this);
        System.out.println("haha");
        super.finalize();
    }
}

package cn.lingjian_7;

/**
 * @author lingjian
 * @date 2019-09-15 - 12:38
 */
public class Student {
    private String name;
    private int age;

    public Student(){
        super();
    }
    public Student(String name, int age){
        super();
        this.name=name;
        this.age=age;
    }

    public void setName(String name){
        this.name=name;
    }

    public String getName(){
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

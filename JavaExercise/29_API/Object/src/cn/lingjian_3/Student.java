package cn.lingjian_3;

import java.util.Objects;

/**
 * @author lingjian
 * @date 2019-07-24 - 09:54
 */
public class Student {
    private String name;
    private int age;

    public Student() {
        super();
    }

    public Student(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    /*public String toString(){
        return super.toString();
        return "hello";
        return "name: "+name+",age: "+age;
    }*/

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }


    /*public boolean equals(Object obj) {
       // return super.equals(obj); 这里虽然是方法重写 但还是调用的父类的该方法
        if(this==obj){  //这里是直接调用了toString方法
            System.out.println("地址相同");
            return true;
        }
         if(!(obj instanceof Student)) {
             return false;
         }
        Student s=(Student) obj;
        //我们要使用的是学生类的特有成员变量，所以要向下转型
        return (this.name.equals(s.name)&&(this.age==s.age));
        }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age &&
                Objects.equals(name, student.name);
    }

    
}


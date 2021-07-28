package cn.itcast;
class Teacher{
    private String name;
    private int age;

}

public class Student {
    private String name;
    private int age;
    public int num = 10;
    public final int num2 = 100;
    public static int num3 = 1000;
    public static final int num4 = 10000;

    public Student() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}

class Test {
    public static void main(String[] args) {
        System.out.println();
        Math.random();
    }
}


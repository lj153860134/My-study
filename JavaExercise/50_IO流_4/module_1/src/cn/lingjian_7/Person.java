package cn.lingjian_7;

import java.io.Serializable;

/**
 * @author lingjian
 * @date 2019/10/15 - 9:45 上午
 */
public class Person implements Serializable {
    private static final long serialVersionUID = 1528666286348372600L;
    private String name;
     int age;

    public Person() {
        super();
    }

    public Person(String name, int age) {
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

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

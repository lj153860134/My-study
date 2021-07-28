package cn.lingjian_1;

import javax.sound.midi.Soundbank;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author lingjian
 * @date 2019/10/30 - 4:18 下午
 */
public class Person {
    private String name;
    int age;
    public String address;

    public Person() {
    }

    private Person(String name){
        this.name=name;
    }

     Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public void show(){
        System.out.println("show");
    }

    public void method(String s){
        System.out.println("method "+s);
    }

    public String getString(String s,int i){
        return s+"----"+i+"hehe";
    }

    private void function(){
        System.out.println("function");
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}

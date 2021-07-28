package cn.lingjian_3;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author lingjian
 * @date 2019-09-17 - 19:45
 */
public class GenericDemo {
    public static void main(String[] args) {
        Collection<?> c1=new ArrayList<Object>();
        Collection<?> c2=new ArrayList<Animal>();

//        Collection<? extends Animal> c3=new ArrayList<Object>();
        Collection<? extends Animal> c4=new ArrayList<Animal>();
        Collection<? extends Animal> c5=new ArrayList<Dog>();
        Collection<? extends Animal> c6=new ArrayList<Cat>();



    }
}
class Animal{

}

class Dog extends Animal{

}

class Cat extends Animal{

}
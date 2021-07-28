package cn.lingjian_3;

/**
 * @author lingjian
 * @date 2019/10/31 - 3:05 下午
 */
public class ToolDemo {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Person p=new Person();
        Tool t=new Tool();
        t.setProperty(p,"name","凌健");
        t.setProperty(p,"age",25);
        t.setProperty(p,"address","盐城");
        System.out.println(p);
    }
}

class Person{
    private String name;
    int age;
    public String address;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}

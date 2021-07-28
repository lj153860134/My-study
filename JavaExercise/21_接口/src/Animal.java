/*
  定义一个抽象动物类  成员变量 name age
                   构造方法 无参 有参
                   成员方法 睡觉 抽象吃饭
  接口跳高类         成员变量 默认修饰符 public final abstract
                   构造方法 无
                   成员方法 跳高（默认修饰符public abstract）
  猫类继承动物类 扩展跳高类（部分猫有跳高功能）
  狗类继承动物类 扩展跳高类（部分狗有跳高功能）
 */
abstract class Animal {
    private String name;
    private int age;

    public Animal() {
    }

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
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

    public abstract void eat();

    public void sleep(){
        System.out.println("sleep");
    }
}

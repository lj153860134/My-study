public class Person {
    private String name;
    private int age;
    public Person(){}                    //无参构造方法
    public Person(String name,int age){  //有参构造方法
        this.name=name;
        this.age=age;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age){
        this.age=age;
    }
    public int getAge(){
        return age;
    }
}

public class Animal {
    private String name;
    private int age;
    private String colour;
    Animal(){}
    Animal(String name,int age,String colour){
        this.name=name;
        this.age=age;
        this.colour=colour;
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

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getColour() {
        return colour;
    }
}

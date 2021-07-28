class Student {
    /*对对象的成员变量赋值时，会出现一些非法的数据，这是不合理的
    应该在赋值之前，先对数据进行判断
    StudentDemo是一个测试类，一般只创建对象，调用方法
    所以这个判断定义在Student类中
    而在成员变量的位置是不可以进行数据判断的
    做数据校验，需要一些逻辑语句，而逻辑语言是应该定义在方法中
    所以我们局等在Student类中提供一个 方法对数据校验
    * */
    private String name;
    private int age;
    //获取值（无形式参数）
    public int getAge(){
        return age;       //这里其实隐含了this
    }
    //写一个方法对数据进行校验（也相当于赋值）
    public void setAge(int age){
        if(age<0||age>125){
            System.out.println("The age is wrong");
        }else{
            this.age=age;  //this代表当前类的对象
        }
    }
    //姓名获取值（无形式参数）
    public String getName(){
        return name;
    }
    //姓名赋值
    public void setName(String name){
        this.name =name;
    }
    //show方法显示所有的成员变量值
    public void show(){
        System.out.println(name+"   "+age);
    }
}
class StudentDemo{
    public static void main(String[] args){
        Student s=new Student();
        s.show();
        //s.show()与下一句功能一样
        System.out.println(s.getName()+"   "+s.getAge());
        System.out.println("--------");
        //给通过方法对成员变量赋值
        s.setAge(25);
        s.setName("凌健");
        s.show();
        System.out.println(s.getName()+"   "+s.getAge());
        System.out.println("--------");
        //给age赋值
        s.setAge(-27);  //数据不合理
        s.show();
    }
}

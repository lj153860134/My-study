/*  一个标准代码的最终版。
	学生类：
		成员变量：
			name，age
		构造方法：
			无参，带两个参
		成员方法：
			getXxx()/setXxx()
			show()：输出该类的所有成员变量值
	给成员变量赋值：
		A:setXxx()方法
		B:构造方法
	输出成员变量值的方式：
		A:通过getXxx()分别获取然后拼接
		B:通过调用show()方法搞定
*/
class Student {
    //成员变量
    private String name;
    private int age;
    //无参构造方法
    public Student(){
    }
    //双参构造方法
    public Student(String name,int age){
        this.name=name;
        this.age=age;
    }
    //成员方法
    //获取姓名
    public String getName(){
        return name;
    }
    //赋值姓名
    public void setName(String name){
        this.name=name;
    }
    //获取年龄
    public int getAge() {
        return age;
    }
    //赋值年龄
    public void setAge(int age) {
        this.age = age;
    }
    public void show(){
        System.out.println(name+"----"+age);
    }
}


class StudentTest{
    public static void main(String[] args){
        //方式1给成员变量赋值
        Student s1=new Student();
        s1.setName("凌健");
        s1.setAge(25);
        System.out.println(s1.getName()+"----"+s1.getAge());
        s1.show();
        //方式2给成员变量赋值
        Student s2=new Student("徐小萌",24);
        System.out.println(s2.getName()+"----"+s2.getAge());
        s2.show();
    }
}
package cn.lingjian_1;

/**
 * @author lingjian
 * @date 2019-09-15 - 12:32
 */
/*
* 将5个学生的信息存储到数组中，并遍历数组，获取得到每一个学生信息
*  学生：   Student
*  成员变量：name  age
*  构造方法：无参 有参
*  成员方法：getXXX（）/setXXX（）
*
* */
public class ObjectArrayDemo {
    public static void main(String[] args) {
        Student[] studentArray=new Student[5];
        studentArray[0]=new Student("凌健",25);
        studentArray[1]=new Student("徐小萌",24);
        studentArray[2]=new Student("王杰",26);
        studentArray[3]=new Student("凌立宏",25);
        studentArray[4]=new Student("陈旭",26);

        for (int i = 0; i <studentArray.length ; i++) {
            System.out.println(studentArray[i].toString());
            System.out.println("--------");
            Student s=studentArray[i];
            System.out.println(s.getName()+"---"+s.getAge());//推荐使用这个方法
        }
    }
}

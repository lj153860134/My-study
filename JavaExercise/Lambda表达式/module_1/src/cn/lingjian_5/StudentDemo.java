package cn.lingjian_5;

/**
 * @author lingjian
 * @date 2019/11/5 - 11:14 上午
 */
public class StudentDemo {
    public static void main(String[] args) {
        //Lambda
//        useStudentBuilder((String s,int x)->{
//            return new Student(s,x);
//        });

        //Lambda简化版
//        useStudentBuilder((s, x) -> new Student(s, x));


        //方法引用构造器
        useStudentBuilder(Student::new);
    }

    private static void useStudentBuilder(StudentBuilder sb){
       Student s=sb.build("凌健",25);
        System.out.println(s);
    }
}

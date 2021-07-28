package cn.lingjian_6;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.TreeSet;

/**
 * @author lingjian
 * @date 2019/10/10 - 9:19 下午
 */
public class StudentDemo1 {
    public static void main(String[] args) throws IOException {
        //创建集合对象
        TreeSet<Student> ts=new TreeSet<Student>(new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                int num=s1.getSum()-s2.getSum();
                int num1=num==0?s1.getChineseScore()-s2.getChineseScore():num;
                int num2=num1==0?s1.getMathScore()-s2.getMathScore():num1;
                int num3=num2==0?s1.getEnglishScore()-s2.getEnglishScore():num2;
                int num4=num3==0?s1.getName().compareTo(s2.getName()):num3;
                return num4;
            }
        });
        //创建学生对象
        Student s1=new Student("凌健",70,90,80);
        Student s2=new Student("徐小萌",100,70,80);
        Student s3=new Student("陈旭",90,100,90);
        Student s4=new Student("王小龙",60,50,60);
        Student s5=new Student("王杰",100,90,100);

        //学生信息添加到集合
        ts.add(s1);
        ts.add(s2);
        ts.add(s3);
        ts.add(s4);
        ts.add(s5);

        //遍历集合，把数据写到文本文件
        BufferedWriter bw=new BufferedWriter(new FileWriter("Student.txt"));
        bw.write("学生信息如下：");
        bw.newLine();
        bw.flush();
        bw.write("姓名，语文成绩，数学成绩，英语成绩");
        bw.newLine();
        bw.flush();
        for (Student s : ts) {
            StringBuilder sb=new StringBuilder();
            sb.append(s.getName()).append(",")
                    .append(s.getChineseScore())
                    .append(",").append(s.getMathScore())
                    .append(",").append(s.getEnglishScore());
            System.out.println(sb);
            bw.write(sb.toString());
            bw.newLine();
            bw.flush();

        }
        bw.close();




    }
}

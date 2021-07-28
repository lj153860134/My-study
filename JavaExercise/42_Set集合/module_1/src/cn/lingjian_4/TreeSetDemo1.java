package cn.lingjian_4;

import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * @author lingjian
 * @date 2019/9/21 - 11:32 上午
 */
public class TreeSetDemo1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int count=0;
        TreeSet<StudentGrade> ts=new TreeSet<StudentGrade>();
        StudentGrade sg1=new StudentGrade("凌健",90,90,90);
        StudentGrade sg2=new StudentGrade("徐小萌",90,80,100);
        StudentGrade sg3=new StudentGrade("王杰",90,90,90);
        StudentGrade sg4=new StudentGrade("王龙",100,100,100);
        StudentGrade sg5=new StudentGrade("陈旭",90,60,90);
        ts.add(sg1);
        ts.add(sg2);
        ts.add(sg3);
        ts.add(sg4);
        ts.add(sg5);

//        while(count<5){
//            System.out.println("请输入第 "+count+" 学生姓名和各科成绩");
//            String name=sc.nextLine();
//            int chinese=sc.nextInt();
//            int math=sc.nextInt();
//            int english=sc.nextInt();
//            StudentGrade sg=new StudentGrade(name,chinese,math,english);
//            count++;
//
//        }
        System.out.println("这5个学生的成绩排名如下：");
        System.out.println("姓名 \t语文 \t数学 \t英语 \t总分");
        for (StudentGrade h : ts) {
            System.out.println(h.getName()+" \t"+h.getChinese()+" \t"
            +h.getMath()+" \t"+h.getEnglish()+" \t"+h.grade());
        }
    }
}

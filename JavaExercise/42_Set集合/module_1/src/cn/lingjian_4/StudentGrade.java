package cn.lingjian_4;

/**
 * @author lingjian
 * @date 2019/9/21 - 11:33 上午
 */
public class StudentGrade implements Comparable<StudentGrade> {
    private String name;
    private int chinese;
    private int math;
    private int english;

    public StudentGrade() {
        super();
    }

    public StudentGrade(String name, int chinese, int math, int english) {
        super();
        this.name = name;
        this.chinese = chinese;
        this.math = math;
        this.english = english;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getChinese() {
        return chinese;
    }

    public void setChinese(int chinese) {
        this.chinese = chinese;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public int getEnglish() {
        return english;
    }

    public void setEnglish(int english) {
        this.english = english;
    }

    public int grade() {
        return chinese + math + english;
    }

    public int compareTo(StudentGrade s) {
        int num = this.grade() - s.grade();
        int num2 = num == 0 ? this.chinese - s.chinese : num;
        int num3 = num2 == 0 ? this.math - s.math : num2;
        int num4 = num3 == 0 ? this.english - s.english : num3;
        int num5 = num4 == 0 ? this.name.compareTo(s.name) : num4;
        return -num5;
    }


}

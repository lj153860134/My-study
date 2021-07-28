package cn.lingjian_6;

/**
 * @author lingjian
 * @date 2019/10/10 - 9:31 下午
 */
public class Student {
    private String name;
    private int chineseScore;
    private int mathScore;
    private int englishScore;

    public Student() {
        super();
    }

    public Student(String name, int chineseScore, int mathScore, int englishScore) {
        super();
        this.name = name;
        this.chineseScore = chineseScore;
        this.mathScore = mathScore;
        this.englishScore = englishScore;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getChineseScore() {
        return chineseScore;
    }

    public void setChineseScore(int chineseScore) {
        this.chineseScore = chineseScore;
    }

    public int getMathScore() {
        return mathScore;
    }

    public void setMathScore(int mathScore) {
        this.mathScore = mathScore;
    }

    public int getEnglishScore() {
        return englishScore;
    }

    public void setEnglishScore(int englishScore) {
        this.englishScore = englishScore;
    }

    public int getSum(){
        return this.chineseScore+this.mathScore+this.englishScore;
    }
}

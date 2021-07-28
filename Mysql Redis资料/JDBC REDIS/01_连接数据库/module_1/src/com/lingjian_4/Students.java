package com.lingjian_4;

/**
 * @description: 四六级学生类
 * @author: Ling Jian
 * @date: 2019-12-06 22:56
 **/
public class Students {
    private int flowId;
    private int type;
    private String idCard;
    private String examCard;
    private String name;
    private String location;
    private int grade;

    public Students() {
        super();
    }

    public Students(int flowId, int type, String idCard, String examCard, String name, String location, int grade) {
        this.flowId = flowId;
        this.type = type;
        this.idCard = idCard;
        this.examCard = examCard;
        this.name = name;
        this.location = location;
        this.grade = grade;
    }

    public int getFlowId() {
        return flowId;
    }

    public void setFlowId(int flowId) {
        this.flowId = flowId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getExamCard() {
        return examCard;
    }

    public void setExamCard(String examCard) {
        this.examCard = examCard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "流水号:    "+flowId+"\n四级/六级: "+type+
                "\n身份证号:  "+idCard+"\n准考证号:  "+examCard+
                "\n学生姓名:  "+name+"\n区域:   "+location+
                "\n成绩      "+grade;
    }
}

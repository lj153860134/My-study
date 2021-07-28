package cn.lingjian_4;

/**
 * @author lingjian
 * @date 2019/10/23 - 10:35 上午
 */
public class Teacher {
    private Teacher(){
    }

    private static Teacher t=null;

    public static Teacher getTeacher(){
        if(t==null){
            t=new Teacher();
        }
        return t;
    }
}

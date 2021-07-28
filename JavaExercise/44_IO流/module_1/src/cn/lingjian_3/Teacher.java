package cn.lingjian_3;

/**
 * @author lingjian
 * @date 2019/9/25 - 3:18 下午
 */
public class Teacher {
    public static void main(String[] args) {
        try {
            check(50);
        } catch (MyException e) {
            e.printStackTrace();
        }
        try {
            check(1000);
        } catch (MyException e) {
            e.printStackTrace();
        }


    }
    public static void check(int score)throws MyException{
        if(score>100||score<0){

                throw new MyException("分数要在0-100");

        }else{
            System.out.println("right");
        }
    }
}

/*循环语句的区别*/
public class loopDifferent {
    public static void main(String[] args){
        int x=3;
        do{
            System.out.println("我爱徐小萌");
        }while(x<3);
        //do-while语句循环至少执行一次
        while(x<3){
            System.out.println("我爱徐小萌");
        }
        //for while循环语句必须先判断条件是否成立，然后再决定执行
    }
}

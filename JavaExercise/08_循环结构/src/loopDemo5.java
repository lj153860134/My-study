/*根据输入的行数和列数 输出相对应的星星图案
* 根据所输入的的行数 输出每行递增的星星图案*/
import java.util.Scanner;
public class loopDemo5 {
    public static void main(String[] args){
        //创建键盘录入对象
        Scanner sc=new Scanner(System.in);
        System.out.println("Please enter the row");
        int row =sc.nextInt();
        //消除错误数据（数据小于1）
        //还有一种错误数据（数据不是整数） 还没有学会保证输入的为整数
        while(row<1){
            System.out.println("Please enter the right row(integer)");
            row=sc.nextInt();
        }
        System.out.println("Please enter the column");
        int column =sc.nextInt();
        //消除错误数据（数据小于1）
        //还有一种错误数据（数据不是整数） 还没有学会保证输入的为整数
        while(column<1){
            System.out.println("Please enter the right column(integer)");
            column=sc.nextInt();
        }
        //利用for循环的嵌套 外循环控制行数 内循环控制列数
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                System.out.print('*');
            }
            System.out.println();
        }
        System.out.println("-----------------");
        // 注意与上面for循环的嵌套，外循环行数不变 内循环的控制变量变成i
        for(int i=0;i<row;i++){
            for(int j=0;j<=i;j++){
                System.out.print('*');
            }
            System.out.println();
        }
    }
}

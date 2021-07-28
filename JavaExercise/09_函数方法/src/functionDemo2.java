/*键盘输入一个数据n（1到9之间）  输出对应的nn乘法表*/
import java.util.Scanner;
public class functionDemo2 {
    public static void main(String[] args){
        //创建键盘录入对象
        Scanner sc=new Scanner(System.in);
        System.out.println("Please enter a integer(1 to n)");
        int n=sc.nextInt();
        while(n<1||n>9){
            System.out.println("Please enter a right integer(1 to n)");
            n=sc.nextInt();
        }
        multiplyTable(n);

    }
    public static void multiplyTable(int m){
        for(int i=1;i<=m;i++){
            for(int j=1;j<=i;j++){
                System.out.print(j+"*"+i+"="+j*i+"\t");
            }
            System.out.println();
        }
    }

}

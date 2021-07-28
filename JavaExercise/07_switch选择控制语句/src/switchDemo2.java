/*模拟做单项选择题，根据你的选择，给出对应的答案（表达式是字符的情况）
  分析：
  A：出一个选择题，然后供你选择
  B:键盘录入选择的数据
  C:根据选择来给出答案
 */
import java.util.Scanner;
public class switchDemo2 {
    public static void main(String[] args){
        // 由于我们现在还没有办法键盘录入得到‘A’ ‘B’
        // 我们现在先用65 66 代替 将来获取这样的值厚，强制转换成字符类型
        System.out.println("Which is your favourite person?");
        System.out.println("65 刘亦菲");
        System.out.println("66 杨幂");
        System.out.println("67 周杰伦");
        System.out.println("68 徐小萌");
        //键盘录入你的选择
        Scanner sc=new Scanner(System.in);
        System.out.println("Please enter yout choice");
        int choice=sc.nextInt();

        // 将整数类型强制转换成字符类型
        char ch=(char) choice;
        switch(ch){
            case 'A':
                System.out.println("刘亦菲");
                break;
            case 'B':
                System.out.println("杨幂");
                break;
            case 'C':
                System.out.println("周杰伦");
                break;
            case 'D':
                System.out.println("徐小萌");
                break;
            default:
                System.out.println("选择错误");
                break;

        }
    }
}

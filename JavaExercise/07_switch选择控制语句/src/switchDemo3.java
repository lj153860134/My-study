/*  键盘录入字符串，根据给定的字符串，来输入你选择的字符串 否则 提示错误
*    String s=sc.nextLine();
*
*
*   */
import java.util.Scanner;
public class switchDemo3 {
    public static void main(String[] args){
        //创建键盘录入对象
        Scanner sc =new Scanner(System.in);
        //录入数据
        System.out.println("Plaese enter your favourite word");
        String s=sc.nextLine();
        switch (s){
            case "hello":
                System.out.println("your favourite word is hello");
                break;      //switch 语句一定不要忘了最后的break语句
            case "world":
                System.out.println("your favourite word is world");
                break;
            case "love":
                System.out.println("your favourite word is love");
                break;
            case "java":
                System.out.println("your favourite word is java");
                break;
            default:
                System.out.println("your word is wrong");
                break;

        }

    }
}

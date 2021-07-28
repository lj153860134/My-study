/*根据输入的数据，输出对应的星期数*/
import java.util.Scanner;
public class switchDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
            System.out.println("Please enter a integer(1 to 7) ");
            int week = sc.nextInt();
            switch (week) {
                case 1:         //case语句后面加的是冒号 不是分号
                    System.out.println("Monday");
                    break;
                case 2:
                    System.out.println("Tuesday");
                    break;
                case 3:
                    System.out.println("Wednesday");
                    break;
                case 4:
                    System.out.println("Thursday");
                    break;
                case 5:
                    System.out.println("Friday");
                    break;
                case 6:
                    System.out.println("Saturday");
                    break;
                case 7:
                    System.out.println("Sunday");
                    break;
                default:
                    System.out.println("The interger is wrong");
                    break;


            }
    }
}

import java.util.Scanner;
public class processControlDemo {
    public static void main(String[] arg){
        /*选择结构 if 语句第一种格式*/
        int x=10;
        if(x==10){
            System.out.println("x is equal to 10");
        }     //若只有一个语句 可以省略大括号 最好都不要省略
        if(x!=10){   //if的关系表达式后面不能直接加分号 会默认if执行空语句
            System.out.println("game over");
        }
        /*选择结构 if 语句第二种格式*/
        int a=10;
        int b=20;
        if(a==b){
            System.out.println("a is equal to b");
        }else{
            System.out.println("a is not equal to b");
        }
        System.out.println("-------------------");
        /*获取两个数据中较大的数*/
        Scanner sc=new Scanner(System.in);// 创建键盘录入对象
        System.out.println("Plaese enter the first integer");
        int p=sc.nextInt();
        System.out.println("Plaese enter the second integer");
        int q=sc.nextInt();
        int max;
        if (p>q){
            max =p;
        }else{
            max=q;
        }
        System.out.println("The larger integer is "+max);
        System.out.println("-------------------");
        /*判断一个数据是奇数还是偶数 并输出*/
        System.out.println("Please enter a integer");
        int r=sc.nextInt();
        if ((r%2)==0){
            System.out.println("This integer is even number");
        }else{
            System.out.println("This integer is odd number");
        }
        System.out.println("The integer is "+ r);
        System.out.println("-------------------");

        /*根据成绩进行等级测评*/
            System.out.println("Plaese enter your score");
            int score = sc.nextInt();
            if (score >= 90 && score <= 100) {
                System.out.println("excellent");
            } else if (score >= 80&&score<90) {
                System.out.println("good");
            } else if (score >= 70&&score<80) {
                System.out.println("well");
            } else if (score >= 60&&score<70) {
                System.out.println("pass");
            } else if(score>=0&&score<60) {
                System.out.println("not pass");
            }else{
                System.out.println("Your score is wrong");
            }
        System.out.println("-------------------");
        /*利用if嵌套语句判断三个输入数据中的最大值*/
        System.out.println("Plaese enter the first integer");
        int a1=sc.nextInt();
        System.out.println("Plaese enter the second integer");
        int a2=sc.nextInt();
        System.out.println("Plaese enter the third integer");
        int a3=sc.nextInt();
        if(a1>a2) {
            if (a1 > a3) {
                max = a1;
            } else {
                max = a3;
            }
        }
        else{if(a2>a3) {
            max = a2;
        }
        else{
            max=a3;
        }
            }
        System.out.println("The largest integer is max: "+max);
        }
    }


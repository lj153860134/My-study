/*  某个公司采用公用电话传递数据信息，数据是小于8位的整数，为了确保安全，
	在传递过程中需要加密，加密规则如下：
	首先将数据倒序，然后将每位数字都加上5，再用和除以10的余数代替该数字，
	最后将第一位和最后一位数字交换。 请任意给定一个小于8位的整数，
	然后，把加密后的结果在控制台打印出来。 */
/*  题目要求：
		A:数据是小于8位的整数
			定义一个int类型的数据
			int number = 123456;
		B:加密规则（只要将这个数据输入进数组内下面的ABC步骤都很容易操作）
			a:首先将数据倒序
				结果 654321
			b:然后将每位数字都加上5，再用和除以10的余数代替该数字
				结果 109876
			c:最后将第一位和最后一位数字交换
				结果 609871
		C:把加密后的结果输出在控制台  */
import java.util.Scanner;
public class jiaMIDemo {
    public static void main(String[] args){
        //创建键盘录入对象
        Scanner sc=new Scanner(System.in);
        System.out.println("Please enter a integer ");
        int input=sc.nextInt();
        while(input>10E9||input<0){
            System.out.println("Please enter a right integer(less than 10E9)");
            input=sc.nextInt();
        }
        //方法1：用for循环将输入的整数倒序 且变为数组
        int [] array=new int[8];
        int count=0;
        for(int num=input;num>0;num/=10){
            array[count]=num%10;
            count++;
        }
        /*方法2：用while循环语句输入的整数变为数组
        //定义数组
		int[] arr = new int[8];

		//定义索引
		int index = 0;

		//把number中的数据想办法放到数组中
		while(number > 0) {
			arr[index] = number%10;
			index++;
			number /= 10;
		}       */

        printNum(array,count);   //打印数据倒序之后的结果
        changeNum(array,count);  //调用将改变数据（每一位的数字+5 再%10）方法
        printNum(array,count);   //打印数据改变之后的结果
        exchangeNum(array,count);//调用将第一位和最后一位数字交换的方法
        printNum(array,count);   //打印最终加密的结果

    }
    //打印该数的方法
    public static void printNum(int[] arr,int a){
        for(int i=0;i<a;i++){
            System.out.print(arr[i]);
        }
        System.out.println();
    }
    //每位数字都加上5，再用和除以10的余数代替该数字方法
    public static void changeNum(int[] arr,int a){
        for(int i=0;i<a;i++){
            arr[i]=(arr[i]+5)%10;
        }
    }
    //第一位和最后一位数字交换的方法
    public static void exchangeNum(int[] arr,int a){
        int temp=arr[0];
        arr[0]=arr[a-1];
        arr[a-1]=temp;
    }
}

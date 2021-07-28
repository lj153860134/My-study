/*数组元素查找（查找指定元素第一次在数组中出现的索引）*/
import java.util.Scanner;
public class arrayDemo6 {
    public static void main(String[] args) {
        //创建键盘录入对象
        Scanner sc = new Scanner(System.in);
        int[] array= {1,1,1,3,3,2,2,4,6,5,7,9,0,7,8};
        System.out.println("Please enter the integer(0 to 9)you find");
        int num=sc.nextInt();
        int index=findIndex(array,num);
        System.out.println("The index is "+index);
    }
    public static int findIndex(int[] arr,int a){
        int index=0;
        for(int i=0;i<arr.length;i++){
            if(a==arr[i]){
                return i;
            }
        }
        return -1;
    }
}

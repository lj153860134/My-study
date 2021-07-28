/*打印杨辉三角形（行数键盘录入）
* 1
  1 1
  1 2 1
  1 3 3 1
  1 4 6 4 1
  1 5 10 10 5 1*/
  // A:任何一行的第一列与最后一列都是1
  // B:从第三行开始，每一个数据都是上一行的前一列和它上一行的本列之和
import java.util.Scanner;
public class arrayDemo9 {
    public static void main(String[] args){
        //创建键盘录入对象
        Scanner sc=new Scanner(System.in);
        System.out.println("Plesse enter the row");
        int n=sc.nextInt();
        int[][] array=new int[n][n];
        yangHuiTriangle(array);

    }
    public static void yangHuiTriangle(int[][] arr){
        arr[0][0]=1;
        int len=arr.length;
        if (len > 1) {
            arr[1][0] = 1;
            arr[1][1] = 1;
        }
        if(len>2) {
            for (int i=2;i<len;i++){
                for (int j=0;j<i+1;j++){
                    if (j>0&&j<i){
                        arr[i][j] = arr[i-1][j-1]+arr[i-1][j];
                    } else {
                        arr[i][j] = 1;
                    }
                }
            }
        }
        printTwoArray(arr);
    }

    //杨辉三角形数组遍历方法
    public static void printTwoArray(int[][] arr){
        int len=arr.length;
        for(int i=0;i<len;i++){
            for(int j=0;j<=i;j++){
                if(j==i){
                    System.out.println(arr[i][j]);
                }else{
                    System.out.print(arr[i][j]+"\t");//加一个\t 输出会更美观
                }
            }

        }
    }

}

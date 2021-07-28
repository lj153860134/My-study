/* 数组遍历：就是依次输出数组中的每一个元素
*  用length获取数组的长度
*  还可用方法来遍历数组的元素*/
public class arrayDemo3 {
    public static void main(String[] args){
        int [] arr={11,22,33,44,55};   //我们数了数组中元素的个数
        for(int i=0;i<arr.length;i++){ //很多时候数组的元素不能靠数 我们用length
            System.out.println(arr[i]);
        }
        System.out.println("---------------");
        printArray(arr);

    }
    public static void printArray(int[] arr){
        for(int i=0;i<arr.length;i++){
            if(i==arr.length-1){  //保证数组在同一行输出
                System.out.println(arr[i]);
            }else{
                System.out.print(arr[i]+",");
            }
        }
    }
}

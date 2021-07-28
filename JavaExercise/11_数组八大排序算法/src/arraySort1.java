/*快速插入排序*/
public class arraySort1 {
    public static void main(String[] args){
        int[] array={1,3,4,6,4,9,0,5,7,8};
        insertArray(array);
        printArray(array);
    }
    //打印数组方法
    public static void printArray(int[] arr){
        System.out.print("[");
        int len=arr.length;
        for(int i=0;i<len;i++){
            if(i==len-1){
                System.out.println(arr[i]+"]");
            }else{
                System.out.print(arr[i]+",");
            }
        }
    }
    //快速排序方法
    public static void insertArray(int[] arr){
        int len=arr.length;
        int insertNumber;
        for(int i=1;i<len;i++){
            int j=i-1;
            insertNumber=arr[i];
            while(j>=0&&arr[j]>insertNumber){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=insertNumber;
        }
    }
}

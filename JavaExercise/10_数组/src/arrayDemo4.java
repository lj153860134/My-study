/*获取数组中的最大值和最小值*/
public class arrayDemo4 {
    public static void main(String[]args){
        int[] array={1,2,6,3,8,3,9,3,9,2,6,10,0,2,3,45};
        int max=getMaxArray(array);
        int min=getMinArray(array);
        System.out.println("The max of array is :"+max);
        System.out.println("The min of array is :"+min);
    }
    public static int getMaxArray(int[] arr){
        int max=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>max){
                max=arr[i];
            }
        }
        return max;
    }
    public static int getMinArray(int[] arr){
        int min=arr[0];
        for(int i=0;i<arr.length;i++){
            if(arr[i]<min){
                min=arr[i];
            }
        }
        return min;
    }
}


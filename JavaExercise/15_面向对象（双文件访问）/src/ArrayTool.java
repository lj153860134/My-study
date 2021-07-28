/**
* 这是针对数组进行操作的工具类
* @author 凌健
* @version v.10
*
* */
public class ArrayTool {
    //把构造方法私有，外界就不能创建对象了
    /**
    * 这是私有构造
    * */
    private ArrayTool(){}

    //遍历数组
    /**
     * 这是遍历数组的方法，遍历后的格式是：[元素1，元素2，元素3,....]
     * @param arr 这是要遍历的数组
     */
    public static void printArray(int[] arr){
        System.out.print("[");
        for(int i=0;i<arr.length;i++){
            if(i==arr.length-1){
                System.out.println(arr[i]+"]");
            }else{
                System.out.print(arr[i]+",");
            }
        }
    }

    //遍历数组的最大值

    /**
     * 这是获取数组中最大值的方法
     * @param arr 这是要获取最大值的数组
     * @return 返回数组中的最大值
     */
    public static int getMaxArray(int[] arr){
        int max=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>max){
                max=arr[i];
            }
        }
        return max;
    }

    //遍历数组最小值

    /**
     * 这是获取数组最小值的方法
     * @param arr  这是要获取最大值的数组
     * @return     返回数组中的最大值
     */
    public static int getMinArray(int[] arr){
        int min=arr[0];
        for(int i=0;i<arr.length;i++){
            if(arr[i]<min){
                min=arr[i];
            }
        }
        return min;
    }

    //获取特定值的索引

    /**
     * 这是回去指定元素在数组中第一次出现的索引 如果元素不存在，就返回-1
     * @param arr    被查找的数组
     * @param value  要查找的元素
     * @return       返回元素在数组的索引，如果不存在返回-1
     */
    public static int getIndex(int[] arr,int value){
        int index=-1;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==value){
                index=i;
                break;
            }
        }
        return index;
    }
}

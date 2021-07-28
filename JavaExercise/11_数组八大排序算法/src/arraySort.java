/*八大数组排序*/
public class arraySort {
    public static void main(String[] args){
        int [] array={32,43,23,13,5,7,45,6,43,23,7,5};
        //insertSort(array);
        selectSort(array);
        printArray(array);
    }
    /*打印数组元素的方法
     * 因为要多次调用 所以将其定义为一个方法*/
    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                System.out.println(arr[i] + "]");
            } else {
                System.out.print(arr[i] + ",");
            }
        }
    }
    /*方法1：直接插入排序
    将第一个数和第二个数排序 然后构成一个有序序列将第三个数插入进去
    构成一个新的有序序列 直到最后一个数 重复第二步

    代码实现：
    首先设定插入次数，即循环次数，for(int i=1;i<length;i++)，1个数的那次不用插入。
    设定插入数和得到已经排好序列的最后一个数的位数。insertNum和j=i-1。
    从最后一个数开始向前循环，如果插入数小于当前数，就将当前数向后移动一位。
    将当前数放置到空着的位置，即j+1*/
    public static void insertSort(int [] a){
        int len=a.length;               //单独把数组长度拿出来，提高效率
        int insertNum;                  //要插入的数
        for(int i=1;i<len;i++){         //因为第一次不用，所以从1开始
            insertNum=a[i];
            int j=i-1;                  //序列元素个数
            while(j>=0&&a[j]>insertNum){//从后往前循环，将大于insertNum的数向后移动
                a[j+1]=a[j];            //元素向后移动
                j--;
            }
            a[j+1]=insertNum;           //找到位置，插入当前元素
        }
    }


    /*方法2：简单快速排序
    常用于取序列中最大最小的几个数时。
    如果每次比较都交换，那么就是交换排序；
    如果每次比较完一个循环再交换，就是简单选择排序
    遍历整个序列，将最小的数放在最前面。
    遍历剩下的序列，将最小的数放在最前面。
    重复第二步，直到只剩下一个数。

    代码实现：
    首先确定循环次数，并且记住当前数字和当前位置。
    将当前位置后面所有的数与当前数字进行对比，小数赋值给key，并记住小数的位置。
    比对完成后，将最小的值与第一个数的值交换 重复2、3步。*/
    public static void selectSort(int[]a){
        int len=a.length;
        for(int i=0;i<len;i++){      //循环次数
            int value=a[i];
            int position=i;
            for(int j=i+1;j<len;j++){//找到最小的值和位置
                if(a[j]<value){
                    value=a[j];
                    position=j;
                }
            }
            a[position]=a[i];       //进行交换
            a[i]=value;
        }
    }

}

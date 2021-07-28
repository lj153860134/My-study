package cn.lingjian_1;

/**
 * @author lingjian
 * @date 2019-09-10 - 09:57
 */
/*
*   把字符串中的数字排序
*   举例 字符串“91 27 46 38 50”
*      输出结果“27 38 46 50 91”
* */
public class RegexTest2 {
    public static void main(String[] args) {
        //定义一个字符串
        String str="91 27 46 38 50";
        //把字符串数组变换成int数组
        String[] strArray=str.split(" ");
        //把字符串数组变换成int数组（重点）
        int[] array=new int[strArray.length];
        for (int i = 0; i <strArray.length ; i++) {
            array[i]=Integer.parseInt(strArray[i]);
        }
        //用冒泡排序对int数组排序
        bubbleSort(array);
        //排序后的int数组在组装成一个字符串 尽量用StringBilder类（重点）
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i <array.length ; i++) {
            sb.append(array[i]).append(" ");
        }
        //转换成字符串 运用了String中的trim（）
        System.out.println(sb);//字符串后面会多一个空格
        String result=sb.toString().trim();
        System.out.println(result);

    }
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i <arr.length-1 ; i++) {
            for (int j = 0; j <arr.length-1-i ; j++) {
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }
}

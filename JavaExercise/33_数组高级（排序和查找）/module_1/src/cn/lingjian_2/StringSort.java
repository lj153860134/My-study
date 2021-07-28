package cn.lingjian_2;

/**
 * @author lingjian
 * @date 2019-09-02 - 16:05
 */
/*
*  把字符串进行排序
*  举例：“dacgebf”
*  结果：“abcdefg”
*
*
* */
public class StringSort {
    public static void main(String[] args) {
        String str = "dacgCebBfA";
        char[] chs = str.toCharArray();
        bubbleSort(chs);
        str = String.valueOf(chs);
        System.out.println(str);
    }


    public static void bubbleSort(char[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    char temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}


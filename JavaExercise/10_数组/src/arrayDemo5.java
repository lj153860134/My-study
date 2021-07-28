/*数组元素逆序（把元素对调）*/
public class arrayDemo5 {
    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 4};
        int[] array2 = {1, 2, 3, 4, 5};
        reverseArray1(array1);
        reverseArray2(array1);
        reverseArray1(array2);
        reverseArray2(array2);

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

    /*方法1：定义一个与原数组长度相同新的数组
     * 然后进行对调 在按顺序输出新的数组*/
    public static void reverseArray1(int[] arr) {
        int[] array = new int[arr.length];
        int j = arr.length - 1;
        for (int i = 0; i < arr.length; i++) {
            array[i] = arr[j];
            j--;
        }
        printArray(array);
    }

    /*方法2：直接在原数组中进行对调 需要定义一个temp来帮助对调
    一直到中间（不管偶数还是奇数）然后直接输出元数组即可*/
    public static void reverseArray2(int[] arr) {
        int j = arr.length-1;
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = 0;
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            j--;
        }
        printArray(arr);
    }
}



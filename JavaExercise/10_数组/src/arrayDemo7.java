/*二维数组
* 遍历二维数组（将其看成几个一维数组进行遍历）*/
public class arrayDemo7 {
    public static void main(String[] args){
        int[][] arr=new int[3][2];
        int[][] arr1={{1,2},{1,2,3},{2,4,6,8},{1,5,3,7}};
        System.out.println(arr);
        System.out.println(arr[0]);
        System.out.println(arr[1]);
        System.out.println(arr[2]);
        System.out.println(arr[0][0]);
        System.out.println(arr[0][1]);
        System.out.println("--------------");
        int[][] array=new int[3][];
        System.out.println(array);
        System.out.println(array[0]);  //null
        System.out.println(array[1]);  //null
        System.out.println(array[2]);  //null
        System.out.println("--------------");
        printTwoArray(arr1);
    }
    //二维数组遍历方法
    public static void printTwoArray(int[][] arr){
        int len=arr.length;
        for(int i=0;i<len;i++){
            System.out.print("[");
            for(int j=0;j<arr[i].length;j++){
                if(j==arr[i].length-1){
                    System.out.println(arr[i][j]+"]");
                }else{
                    System.out.print(arr[i][j]+",");
                }
            }

        }
    }

}

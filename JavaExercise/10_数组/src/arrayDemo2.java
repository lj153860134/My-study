/*定义两个数组 把第一个数组的地址赋给第二个数组 通过第二个数组把元素重新修改*/
public class arrayDemo2 {
    public static void main(String[] args){
        int [] array1=new int[3];  //数组的动态初始化
        int [] array2=new int[3];
        int [] array3={1,2,3};     //数组的静态初始化 有系统决定数组长度
        int [] array4=new int[3];
        array1[0]=10;
        array1[1]=20;
        array1[2]=30;
        System.out.println(array1);
        System.out.println(array1[0]);
        System.out.println(array1[1]);
        System.out.println(array1[2]);
        array2=array1;  //将第一个数组的地址值赋给了第二个数组
        array2[0]=40;   //两个引用指向同一个堆内空间
        array2[1]=50;   //无论对谁操作都是针对同一地方
        array2[2]=60;
        System.out.println(array2);  //同一地址值
        System.out.println(array1[0]);
        System.out.println(array1[1]);
        System.out.println(array1[2]);
        System.out.println(array3);
        System.out.println(array3[0]);
        System.out.println(array3[1]);
        System.out.println(array3[2]);
        array4=null;
        System.out.println(array4);     //回报错误：空指针异常
        System.out.println(array4[0]);
        System.out.println(array4[1]);
        System.out.println(array4[2]);
    }
}

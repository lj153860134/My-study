package cn.lingjian_8;

/**
 * @author lingjian
 * @date 2019-08-21 - 21:17
 */
/*
*  需求：把int数组拼接成字符串
*  举例：int[] arr={1,2,3,4};
*  输出结果：输出字符串[1, 2, 3, 4]
*  分析：
*      A:定义一个字符串对象，只不过内容为空（或者先定义一个“[”的字符串）
*      B:遍历数组，得到每一个元素
*
* */
public class StringTest {
    public static void main(String[] args) {
        int[] arr={1,2,3,4};
        //方法一：直接实现
        String s="[";
        for (int i = 0; i <arr.length ; i++) {
                String s1 = String.valueOf(arr[i]);
            if(i<arr.length-1) {
               s= s.concat(s1 + ", ");
            }
            else{
                s=s.concat(s1+"]");
            }
        }
        System.out.println(s);
        System.out.println(stringOfIntArr( arr,arr.length));

    }
    //方法2：通过功能实现
    /*
     *
     * 两个明确：
     *     返回值类型： String类型
     *     参数列表：int数组  数组长度
     *
     * */
    // 实现方法(必须是静态方法）
   public static String stringOfIntArr(int[] arr,int length){
        String s="[";
        for (int i = 0; i <length ; i++) {
            String s1 = String.valueOf(arr[i]);
            if(i<arr.length-1) {
                s= s.concat(s1 + ", ");
            }
            else{
                s=s.concat(s1+"]");
            }
        }
        return s;
    }
}

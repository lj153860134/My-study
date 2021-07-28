package cn.lingjian_3;

/**
 * @author lingjian
 * @date 2019-08-30 - 10:58
 */
/*
* 功能：把数组拼接成一个字符串
*     A：用String做拼接（效率太低）
*     B:用StringBuffer做拼接
*
* */
public class StringBufferTest2 {
    public static void main(String[] args) {
        int[] arr={11,22,33,44,55};
        String s1=arrayToString(arr);
        System.out.println(s1);
        System.out.println(arrayToString(arr));
        System.out.println("------");
        String s2=arrayToString2(arr);
        System.out.println(s2);
        System.out.println(arrayToString2(arr));


    }
    public static String arrayToString(int[] arr){
        String s="";
        s+="[";
        for (int i = 0; i <arr.length ; i++) {
            if(i==arr.length-1){
                s+=arr[i];
                s+="]";
            }else{
                s+=arr[i];
                s+=",";
            }
        }
        return s;
    }

    public static String arrayToString2(int[] arr){
        StringBuffer sb=new StringBuffer();
        sb.append("[");
        for (int i = 0; i <arr.length ; i++) {
            if(i==arr.length-1){
                sb.append(arr[i]+"]");
            }else{
                sb.append(arr[i]+",");
            }

        }
        return sb.toString();
    }
}

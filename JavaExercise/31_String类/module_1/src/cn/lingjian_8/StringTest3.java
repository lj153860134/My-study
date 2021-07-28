package cn.lingjian_8;

/**
 * @author lingjian
 * @date 2019-08-22 - 14:39
 */
/*
*   统计大串中小串出现的次数
*   字符串"woaijava zhendehenaijava aijava zhendeaijava hello java hello"
*
*
*
* */
public class StringTest3 {
    public static void main(String[] args) {
        String s1="woaijava zhendehenaijava aijava zhendeaijava hello javahello";
        String s2="java";
        int count=0;
        int index=0;
        int number=0;
        while(true){
        index=s1.indexOf(s2,number);
        number=index+1;
            if(index==-1){
                break;
            }
            count++;
        }
        System.out.println(count);
    }
}

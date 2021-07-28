package com.lingjian.jianzhi;

/**
 * @description: 输入一个非负整数数组
 *               把数组里所有数字拼接起来排成一个数
 *               打印能拼接出的所有数字中最小的一个
 * @author: Ling Jian
 * @date: 2020-07-09 15:45
 **/
public class Test_45 {
    public static void main(String[] args) {
        int[] nums=new int[]{1,2,3,4,5,0};

        //最小的数
//        String res1 = minNumber(nums);
//        System.out.println(res1);

        //最大的数
        String res2 = minNumber(nums);
        System.out.println(res2);


    }

    public static String minNumber(int[] nums) {
        String[] str = new String[nums.length];
        for (int i = 0; i <str.length ; i++) {
            str[i] = String.valueOf(nums[i]);
        }
        //最小的数
//        fastSort(str, 0, str.length - 1);
        //最大的数
        fastSort1(str, 0, str.length - 1);
        StringBuilder sb = new StringBuilder();
        for (String s : str) {
            sb.append(s);
        }
        return sb.toString();

    }

    public static void fastSort(String[] str,int left,int right){
        if(left>=right){
            return;
        }
        int less=left-1;
        int more=right+1;
        int cur=left;
        int mid=left+((right-left)>>1);
        String temp = str[mid];
        while(cur<more){
            if((str[cur]+temp).compareTo(temp+str[cur])>0){
                swap(str, --more, cur);
            }else if((str[cur]+temp).compareTo(temp+str[cur])<0){
                swap(str,++less,cur++);
            }else{
                cur++;
            }
        }
        fastSort(str, left, less);
        fastSort(str, more, right);
    }

    public static void swap(String[] str,int i,int j){
        String temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }

    //最大的数
    public static void fastSort1(String[] str,int left,int right){
        if(left>=right){
            return;
        }
        int less=left-1;
        int more=right+1;
        int cur=left;
        int mid=left+((right-left)>>1);
        String temp = str[mid];
        while(cur<more){
            if((str[cur]+temp).compareTo(temp+str[cur])<0){
                swap(str, --more, cur);
            }else if((str[cur]+temp).compareTo(temp+str[cur])>0){
                swap(str,++less,cur++);
            }else{
                cur++;
            }
        }
        fastSort1(str, left, less);
        fastSort1(str, more, right);
    }
}

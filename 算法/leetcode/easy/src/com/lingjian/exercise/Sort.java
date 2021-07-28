package com.lingjian.exercise;

import com.lingjian.sort.BubbleSort;

import java.util.Arrays;

/**
 * @description: 排序
 * @author: Ling Jian
 * @date: 2020-08-31 18:23
 **/
public class Sort {
    public static void main(String[] args) {
        int[] nums1 = new int[]{5, 4, 3, 2, 1};
        int[] nums2 = new int[]{5, 4, 3, 2, 1};
        int[] nums3 = new int[]{5, 4, 3, 2, 1};
        int[] nums4 = new int[]{5, 4, 3, 2, 1};
        int[] nums5 = new int[]{5, 4, 3, 2, 1};
        int[] nums6 = new int[]{5, 4, 3, 2, 1};
        int[] nums7 = new int[]{5, 4, 3, 2, 1};
        int[] nums8= new int[]{5, 4, 3, 2, 1};
        //冒泡排序
        bubbleSort(nums1);
        System.out.println(Arrays.toString(nums1));

        //选择排序
        selectSort(nums2);
        System.out.println(Arrays.toString(nums2));

        //插入排序
        insertSort(nums3);
        System.out.println(Arrays.toString(nums3));

        //希尔排序
        shellSort(nums4);
        System.out.println(Arrays.toString(nums4));

        //快速排序
        quickSort(nums5);
        System.out.println(Arrays.toString(nums5));

        //归并排序
        mergeSort(nums6);
        System.out.println(Arrays.toString(nums6));

        //堆排序
        heapSort(nums7);
        System.out.println(Arrays.toString(nums7));
    }

    //冒泡排序
    public static void bubbleSort(int[] nums){
        if(nums==null||nums.length<=1){
            return;
        }
        for (int i = 0; i <nums.length-1 ; i++) {
            int count=0;
            for (int j = 1; j <nums.length-i ; j++) {
                if(nums[j]<=nums[j-1]){
                    swap(nums, j - 1, j);
                    count++;
                }
            }
            if(count==0){
                break;
            }
        }
    }

    //选择排序
    public static void selectSort(int[] nums){
        if(nums==null||nums.length<=1){
            return;

        }
        for (int i = 1; i <nums.length ; i++) {
            int minIndex=i-1;
            for (int j = i+1; j <nums.length ; j++) {
                if(nums[minIndex]>nums[j]){
                    minIndex = j;
                }
            }
            if(minIndex!=i-1){
                swap(nums, i - 1, minIndex);
            }
        }
    }

    //插入排序
    public static void insertSort(int[] nums){
        if(nums==null||nums.length<2){
            return ;
        }
        for (int i = 1; i <nums.length ; i++) {
            int insertIndex = i - 1;
            int insertValue = nums[i];
            if(insertValue<nums[insertIndex]){
                while(insertIndex>=0&&insertValue<nums[insertIndex]){
                    nums[insertIndex + 1] = nums[insertIndex];
                    insertIndex--;

                }
            }
            if(insertIndex!=i-1){
                nums[insertIndex+1] = insertValue;
            }
        }

    }

    //希尔排序
    public static void shellSort(int[] nums){
        if(nums==null||nums.length<2){
            return;
        }
        for (int gap = nums.length/2; gap>=1 ; gap/=2) {
            for (int i = gap; i <nums.length ; i++) {
                int insertIndex = i - gap;
                int insertValue = nums[i];
                if(nums[insertIndex]>insertValue){
                    while(insertIndex>=0&&nums[insertIndex]>insertValue){
                        nums[insertIndex + gap] = nums[insertIndex];
                        insertIndex -= gap;
                    }
                }
                if(insertIndex!=i-gap){
                    nums[insertIndex + gap] = insertValue;

                }
            }
        }
    }

    //快速排序
    public static void quickSort(int[] nums){
        if(nums==null||nums.length<2){
            return;
        }
        process(nums,0,nums.length-1);
    }

    public static void process(int[] nums, int left,int right){
        if(left>=right) return;
        int less=left-1;
        int more=right+1;
        int cur = left;
        int temp=nums[left+(int)((right-left+1)*Math.random())];
        while(cur<more){
            if(temp>nums[cur]){
                swap(nums, ++less, cur++);
            }else if(temp<nums[cur]){
                swap(nums, --more, cur);
            }else{
                cur++;
            }
        }
        process(nums, left, less);
        process(nums, more, right);
    }

    //归并排序
    public static void mergeSort(int[] nums){
        if(nums==null||nums.length<2){
            return;
        }
       process1(nums,0,nums.length-1);
    }

    public static void process1(int[] nums,int left,int right){
        if(left==right) return;
        int mid=left+((right-left)>>1);
        process1(nums, left, mid);
        process1(nums, mid + 1, right);
        merge(nums, left, right, mid);
    }

    public static void merge(int[] nums,int left,int right,int mid){
        int[] help = new int[right - left + 1];
        int p1 = left;
        int p2 = mid + 1;
        int p = 0;
        while(p1<=mid&&p2<=right){
            help[p++] = nums[p1] <= nums[p2] ? nums[p1++] : nums[p2++];
        }
        while(p1<=mid){
            help[p++] = nums[p1++];
        }

        while(p2<=right){
            help[p++] = nums[p2++];
        }
        for (int i = 0; i <help.length ; i++) {
            nums[i + left] = help[i];
        }
    }

    //堆排序
    public static void heapSort(int[] nums){
        if(nums==null||nums.length<2){
            return;
        }
        for (int i = 0; i <nums.length ; i++) {
            insertHeap(nums, i);
        }
        for (int i =nums.length-1; i >=1 ; i--) {
            swap(nums, 0, i);
            heapIfy(nums, 0, i);
        }
    }

    public static void insertHeap(int[] nums, int i){
        //这里只能< 不能<=不然0会在这里死循环
        while(nums[i]>nums[(i-1)/2]){
            swap(nums,i,(i-1)/2);
            i=(i-1)/2;
        }

    }

    public static void heapIfy(int[] nums,int index,int size){
        int left=2*index+1;
        while(left<size){
                int largest = left+1<size&&nums[left] < nums[left + 1] ? left+1 : left;
                largest = nums[index] > nums[largest] ? index : largest;
                if(largest==index) {
                    break;
                }
                swap(nums, largest, index);
                index = largest;
                left = 2 * index + 1;
            }
        }


    public static void swap(int[] nums, int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

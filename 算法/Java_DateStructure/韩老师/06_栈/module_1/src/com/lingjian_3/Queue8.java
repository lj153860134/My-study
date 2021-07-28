package com.lingjian_3;

/**
 * @description: 递归解决8皇后问题
 * @author: Ling Jian
 * @date: 2019-12-05 15:32
 **/
public class Queue8 {
    public static void main(String[] args) {
        Queue q=new Queue();
        q.check(0);
        System.out.println("一共有"+q.getCount()+"解法");
    }


}

class Queue{
    private int max=4;   //定义一个max一共有8个皇后
    private int [] arr=new int [max]; //定义一个数组 保存最后皇后放置位置的结果
    private int count=0;

    public void check(int n){   //n从0开始 判断第n+1个皇后放的位置是否正确
        if(n==max){
            print();
            return;
        }
         //依次将该皇后放入不同的位置 并判断是否冲突
        for (int i = 0; i <max ; i++) {
            //先把当前这个皇后n 放在该行的第一列
            arr[n]=i;
            if(judge(n)){
                check(n+1);
            }
            //如果冲突 就继续for循环
        }
    }

    /**
    * @description:  判断当放置第n个皇后时 与前面所有的皇后是否冲突
    * @param: [n]
    * @return: boolean
    * @author: Ling Jian
    * @date: 2019/12/5 3:58 下午
    */
    public boolean judge(int n){
        for (int i = 0; i < n; i++) {
            //arr[i]==arr[n] 判断是否在同一列
            //Math.abs(n-i)==Math.abs(arr[n]-arr[i] 判断是否在同一斜线
            if(arr[i]==arr[n]||Math.abs(n-i)==Math.abs(arr[n]-arr[i]))
                return false;
        }

        return true;
    }


    /**
    * @description: 打印arr数组 即最终的结果
    * @param: []
    * @return: void
    * @author: Ling Jian
    * @date: 2019/12/5 3:58 下午
    */
    public void print(){
        count++;
        for (int i = 0; i <max ; i++) {
            System.out.print(arr[i]);

        }
        System.out.println();
    }

    public int getCount() {
        return count;
    }
}

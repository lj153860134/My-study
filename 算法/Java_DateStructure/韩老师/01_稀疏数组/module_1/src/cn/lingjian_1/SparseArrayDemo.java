package cn.lingjian_1;

import java.io.*;

/**
 * @author lingjian
 * @date 2019/11/22 - 10:54 上午
 */

/*
* 需求：将原始的二维数组转换为稀疏数组
*      并将稀疏数组存储到文件中
*
* */
public class SparseArrayDemo {
    public static void main(String[] args) throws IOException{
        //创建一个原始的11*11二维数组
        //0表示没有棋子 1表示黑子 2表示蓝子
        int[][] chessArray = new int[11][11];
        chessArray[1][2] = 1;
        chessArray[2][3] = 2;

        //遍历打印二维数组
        printArray(chessArray);

        //将二维数组转稀疏数组
        //先遍历二维数组 得到非0的个数
        int count = 0;     //非零数据的个数

        // 不需要通过变量获取行数列数
        // a为二维数组
        // a.length就是行数  a[0].length就是列数
//        int row_count = 0; //二维数组的行数
//        int column_count = 0;//二维数组的列数

        for (int[] ints : chessArray) {
            for (int data : ints) {
                if (data != 0)
                    count++;
            }
        }
        //column_count最后的结果是总的个数 除以行数就是列数
        //创建稀疏二维数组
        int[][] sparseArray = new int[count + 1][3];
        //给稀疏数组第一行赋值
        sparseArray[0][0] = chessArray.length;
        sparseArray[0][1] = chessArray[0].length;
        sparseArray[0][2] = count;

        //遍历二维数组(这时已知行数列数） 将非0的值放入sparseArray中
        count=0; //将元素个数清0
        for (int i = 0; i <chessArray.length ; i++) {
            for (int j = 0; j < chessArray[0].length; j++) {
                if (chessArray[i][j] != 0) {
                    count++;   //继续计算元素个数
//                    System.out.println(chessArray[i][j]);
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = chessArray[i][j];
                }

            }
        }

        System.out.println("----------");

        //遍历打印稀疏数组
        printArray(sparseArray);
        //输出稀疏数组到文件
        arrayToTxt(sparseArray);

    }


    /**
     * 打印二维数组
     * @param array
     */
    public static void printArray(int[][] array){
        for (int[] ints : array) {
            System.out.print("[");
            for (int data : ints) {
                System.out.printf("%3d",data);
            }
            System.out.println(" ]");
        }
    }

    /**
     * 将稀疏数组放入文件中
     * @param array
     * @throws IOException
     */
    public static void arrayToTxt(int[][] array ) {
        try {
            File file = new File("sparseArray.txt");
            FileWriter fw = new FileWriter(file);
            if (!file.exists())
                file.mkdir();
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[0].length; j++) {
                    fw.write(array[i][j] + "\t");
                    fw.flush();
                }
                fw.write("\r\n");

            }
            fw.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }


}

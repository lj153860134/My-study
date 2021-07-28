package cn.lingjian_1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author lingjian
 * @date 2019/11/25 - 4:04 下午
 */
/*
 * 需求：将txt中的数据转换成稀疏数组
 *      并将稀疏数组转化为二维数组
 * */


public class SparseArrayDemo2 {
    public static void main(String[] args) {
        ArrayList<Integer> list=TxtToList("sparseArray.txt");
        int[][] sparseArray=listToSparse(list);
        int[][] array=sparseToArray(sparseArray);
        printArray(sparseArray);
        printArray(array);
    }

    /**
     * 将文件中稀疏数组的全部数据转换到一个集合中
     * @param filePath
     * @return
     */
    public static ArrayList<Integer> TxtToList (String filePath) {
        ArrayList<Integer> list=new ArrayList<>();
        try {
            File file = new File(filePath);
            if (file.isFile() && file.exists()) {
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line = null;
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                    String[] strs=line.split("\t");
                    for (String str : strs) {
                        int data=Integer.parseInt(str);
                        list.add(data);
                    }


                }
                br.close();
            } else {
                System.out.println("The txt is not found");
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 将集合转换成稀疏数组
     * @param list
     * @return
     */
    public static int[][] listToSparse(ArrayList<Integer> list){
        int row=list.size()/3;  //获取稀疏数组的行数
        int count=0;
        int[][] sparseArray=new int[row][3];
        for (int i = 0; i <list.size() ; i=i+3) {
            sparseArray[count][0]=list.get(i);
            sparseArray[count][1]=list.get(i+1);
            sparseArray[count][2]=list.get(i+2);
            count++;
        }
        return sparseArray;
    }

    /**
     * 将稀疏数组转换成二维数组
     * @param sparseArray
     * @return
     */
    public static int[][]  sparseToArray(int[][] sparseArray){
        int[][] array=new int[sparseArray[0][0]][sparseArray[0][1]];
        for (int i = 1; i < sparseArray.length; i++) {
           array[sparseArray[i][0]][sparseArray[i][1]]=sparseArray[i][2];
        }
        return array;
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


}




package com.lingjian_1;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

/**
 * @author lingjian
 * @date 2019/12/2 - 10:43 上午
 */
public class YueSeFuTest {
    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        System.out.println("请输入你要创建环形链表的大小");
//        int length=sc.nextInt();
//        System.out.println("请输入要开始的编号（小于"+length+")");
//        int k=sc.nextInt();
//        System.out.println("请输入报数出列的m值");
//        int m=sc.nextInt();
        printYueSeFu(5,1,2);

    }

    /**
     *
     * @param length   最初结点的长度
     * @param startNum 表示从第几个开始
     * @param countNum 表示数几下出圈
     */
    public static void printYueSeFu(int length,int startNum,int countNum){
        if(length<0||startNum<1||countNum>length){
            System.out.println("参数输入有误");
            return;
        }
        CircleSingleLinkedList list=new CircleSingleLinkedList();
        list.setList(length);
        BoyNode temp=list.getFirst();
        while(temp.getNum()<startNum){
            temp=temp.getNext();
        }
        while(true){

            for(int i=1;i<countNum;i++){
                temp=temp.getNext();
            }
            System.out.println(temp);
            list.deleteNode(temp.getNum());
            temp=temp.getNext();
            if(list.getFirst()==null)
                break;
        }
    }

    public static void printYueSeFu2(int length,int k,int m){

    }
}

package cn.lingjian_8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * @author lingjian
 * @date 2019/9/24 - 3:42 下午
 */
/*
 * 斗地主改进版（看牌可排序）
 *
 * */
public class PokeDemo2 {
    public static void main(String[] args) {

        HashMap<Integer, String> hm = new HashMap<Integer, String>();
        ArrayList<Integer> arrayList=new ArrayList<Integer>();
        //创建一个牌盒
//        ArrayList<String> list = new ArrayList<String>();
        //定义一个花色数组
        String[] colors = {"♠", "♥", "♣", "◇"};
        //定义一个点数数组
        String[] numbers = { "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K","A", "2"};
        //装牌
        int index=0;
        for (String number : numbers) {
            for (String color : colors) {
//                list.add(color.concat(number));
                arrayList.add(index);
                hm.put(index,color+number);
                index++;
            }

        }
        arrayList.add(52);
        arrayList.add(53);
        hm.put(52,"joker");
        hm.put(53,"JOKER");
//        for (Integer i : hm.keySet()) {
//            System.out.println(i+"----"+hm.get(i));
//        }      //按顺序打印所有的牌

        //洗牌
        Collections.shuffle(arrayList);

        //发牌
        ArrayList<Integer> player1=new ArrayList<Integer>();
        ArrayList<Integer> player2=new ArrayList<Integer>();
        ArrayList<Integer> player3=new ArrayList<Integer>();
        ArrayList<Integer> diPai=new ArrayList<Integer>();

        for (int i = 0; i <arrayList.size() ; i++) {
            if(i>=arrayList.size()-3){
                diPai.add(arrayList.get(i));
            }else if(i%3==0){
                player1.add(arrayList.get(i));
            }else if(i%3==1){
                player2.add(arrayList.get(i));
            }else{
                player3.add(arrayList.get(i));
            }
        }

        //发完牌在进行排序
        Collections.sort(player1);
        Collections.sort(player2);
        Collections.sort(player3);
        Collections.sort(diPai);

        //看牌
        lookPoker("palyer1",player1,hm);
        lookPoker("palyer2",player2,hm);
        lookPoker("palyer3",player3,hm);
        lookPoker("diPai",diPai,hm);





    }

    public static void lookPoker(String s,ArrayList<Integer> list,HashMap<Integer, String> hm) {
        System.out.print(s+": ");
        int x = 1;
        for (Integer i : list) {
            if (x != list.size()) {
                System.out.print(hm.get(i) + ",");
                x++;
            } else {
                System.out.println(hm.get(i));
            }

        }
    }
}

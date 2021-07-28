package cn.lingjian_8;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author lingjian
 * @date 2019/9/24 - 3:00 下午
 */

/*
*
*  斗地主
* */
public class PokeDemo1 {
    public static void main(String[] args) {
        //创建一个牌盒
        ArrayList<String> list=new ArrayList<String>();
        //定义一个花色数组
        String[] colors={"♠","♥","♣","◇"};
        //定义一个点数数组
        String[] numbers={"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
        //装牌
        for (String color : colors) {
            for(String number:numbers)
                list.add(color.concat(number));

        }
        list.add("joker");
        list.add("JOKER");
        System.out.println(list);

        //洗牌
        Collections.shuffle(list);

        //发牌
        ArrayList<String> player1=new ArrayList<String>();
        ArrayList<String> player2=new ArrayList<String>();
        ArrayList<String> player3=new ArrayList<String>();
        ArrayList<String> diPai=new ArrayList<String>();


        for (int i = 0; i <list.size() ; i++) {
            if(i>=list.size()-3){
                diPai.add(list.get(i));
            }else if(i%3==0){
                player1.add(list.get(i));
            }else if(i%3==1){
                player2.add(list.get(i));
            }else{
                player3.add(list.get(i));
            }
        }

        //看牌
        System.out.println("player1:"+player1);
        System.out.println("player2:"+player2);
        System.out.println("player3:"+player3);
        System.out.println("diPai:"+"\t"+diPai);

    }
}

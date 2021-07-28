package cn.lingjian_1;

import java.util.HashMap;

/**
 * @author lingjian
 * @date 2019/9/22 - 11:41 上午
 */
/*
* 测试Map的功能
* */
public class MapDemo1 {
    public static void main(String[] args) {
        HashMap<String,String> hm=new HashMap<String,String>();
        System.out.println(hm.put("凌健","徐小萌"));
        System.out.println(hm.put("凌健","王杰"));

        System.out.println(hm);
    }
}

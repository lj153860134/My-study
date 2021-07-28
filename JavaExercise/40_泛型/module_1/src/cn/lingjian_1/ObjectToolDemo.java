package cn.lingjian_1;

/**
 * @author lingjian
 * @date 2019-09-17 - 15:45
 */
public class ObjectToolDemo {
    public static void main(String[] args) {
        ObjectTool<String> ot=new ObjectTool<String>();
        ot.setObj("凌健");
        System.out.println(ot.getObj());
        ot.setObj("徐小萌");
        System.out.println(ot.getObj());

        ObjectTool<Integer> ot1=new ObjectTool<Integer>();
        ot1.setObj(Integer.valueOf(10));
        System.out.println(ot1.getObj());
        ot1.setObj(Integer.valueOf(20));
        System.out.println(ot1.getObj());



    }

}

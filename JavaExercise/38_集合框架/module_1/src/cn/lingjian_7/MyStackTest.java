package cn.lingjian_7;

/**
 * @author lingjian
 * @date 2019-09-17 - 14:31
 */
public class MyStackTest {
    public static void main(String[] args) {
        MyStack stack=new MyStack();
        //添加元素
        stack.add("hello");
        stack.add("world");
        stack.add("java");

        //获取元素
//        System.out.println(stack.get());
//        System.out.println(stack.get());
//        System.out.println(stack.get());

        while(!stack.isEmpty()){
            System.out.println(stack.get());
        }
    }
}

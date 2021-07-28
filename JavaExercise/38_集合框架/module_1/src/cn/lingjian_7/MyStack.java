package cn.lingjian_7;

import java.util.LinkedList;

/**
 * 自定义的栈集合
 * @author lingjian
 * @date 2019-09-17 - 14:26
 */
public class MyStack {
    private LinkedList link;

    public MyStack(){
        link=new LinkedList();
    }

    public void add(Object obj){
        link.addFirst(obj);
    }

    public Object get(){
        return link.removeFirst();
    }

    public boolean isEmpty(){
        return link.isEmpty();
    }
}

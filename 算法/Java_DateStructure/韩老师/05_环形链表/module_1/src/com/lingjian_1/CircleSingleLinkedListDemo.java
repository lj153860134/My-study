package com.lingjian_1;

/**
 * @author lingjian
 * @date 2019/12/2 - 9:50 上午
 */
public class CircleSingleLinkedListDemo {
    public static void main(String[] args) {
        CircleSingleLinkedList list = new CircleSingleLinkedList();
        list.setList(2);
        list.deleteNode(1);
        list.deleteNode(2);
        list.showList();
    }

}


//创建一个单向环形链表
class CircleSingleLinkedList {
    //创建一个first结点 当前没有编号
    private BoyNode first = null;

    public BoyNode getFirst() {
        return first;
    }

    public void setFirst(BoyNode first) {
        this.first = first;
    }

    /**
     * 设置指定个数小孩结点环形链表
     *
     * @param nums
     */
    public void setList(int nums) {

        if (nums < 1) {
            System.out.println("该数目错误 无法生成环形链表" +
                    "");
            return;
        }
        BoyNode temp = null;//辅助变量 帮助构建环形链表
        //使用for循环创建我们环形链表
        for (int i = 1; i <= nums; i++) {
            //根据编号 创建小孩结点
            BoyNode boy = new BoyNode(i);
            if (i == 1) {
                first = boy;
                first.setNext(first);
                temp = first;
            } else {
                temp.setNext(boy);
                boy.setNext(first);
                temp = boy;
            }
        }

    }

    /**
     * 删除指定结点
     * @param nums
     */
    public void deleteNode(int nums){
        if(first==null){
            System.out.println("链表为空 无法删除");
            return;
        }

        BoyNode temp=first; //辅助变量
        boolean flag=true;  //判断是否删除成功
        if(nums==first.getNum()){
            while(temp.getNext()!=first){
                temp=temp.getNext();
            }
            if(temp==first){
                first=null;
                return;
            }
            temp.setNext(first.getNext());
            first=first.getNext();
        }else{
            while(true){
                if(temp.getNext().getNum()==nums)
                    break;
                else if(temp.getNext()==first){
                    flag=false;
                    break;
                }
                temp=temp.getNext();
            }
            if(flag){
                temp.setNext(temp.getNext().getNext());
            }else{
                System.out.println("无法删除 "+nums+" 结点");
            }
        }

    }

    /**
     * 遍历显示环形链表
     */
    public void showList() {
        //判断链表是否为空
        if (first == null) {
            System.out.println("链表为空 无法打印");
            return;
        }
        BoyNode temp = first;
        while (temp.getNext() != first) {
            System.out.println(temp);
            temp = temp.getNext();
        }
        System.out.println(temp);
    }
}

//创建一个BoyNode类 表示一个结点
class BoyNode {
    private int num;   //编号
    private BoyNode next;//指向下一个结点 默认null

    //创建构造器
    public BoyNode(int num) {
        this.num = num;
    }

    //因为num与next都是私有的
    //需要创建get与set方法
    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public BoyNode getNext() {
        return next;
    }

    public void setNext(BoyNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        String s=Integer.toString(num);
        return s;
    }
}

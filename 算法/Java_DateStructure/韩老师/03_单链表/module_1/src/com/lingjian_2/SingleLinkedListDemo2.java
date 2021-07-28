package com.lingjian_2;


/**
 * @author lingjian
 * @date 2019/11/28 - 3:20 下午
 */
/*
 * 单链表的创建和遍历(考虑编号 按顺序添加）
 * addNode()在链表尾部添加
 * addNode2()在链表中按顺序添加
 * */
public class SingleLinkedListDemo2 {
    public static void main(String[] args) {
        //创建一个单链表
        SingleLinkedList list = new SingleLinkedList();
        SingleLinkedList list2 = new SingleLinkedList();
        //  创建一些结点
        HeroNode hn1 = new HeroNode(1, "凌健", "小小贱");
        HeroNode hn2 = new HeroNode(2, "徐小萌", "小小萌");
        HeroNode hn3 = new HeroNode(3, "凌立宏", "A哥");
        HeroNode hn4 = new HeroNode(4, "王杰", "死胖子");
        //添加结点


        list.addNode2(hn4);
        list.addNode2(hn2);
        list.addNode2(hn1);
        list.addNode2(hn3);

        list.showList();
        System.out.println("----------");

        list.getNode(3);
        list.getNode(5);
        //修改结点
        HeroNode newNode=new HeroNode(1, "lj", "lj");
        list.updateNode(newNode);

        //遍历链表
        list.showList();

        System.out.println("----------");
        //删除结点
        list.deleteNode(3);
        list.showList();

        System.out.println("----------------");
        System.out.println(list2.getLength());


    }
}

class SingleLinkedList {
    //初始化一个头结点 头结点不能动 不存放具体的数据
    private HeroNode head = new HeroNode(0, " ", " ");


    public HeroNode getHead() {
        return head;
    }

    public void setHead(HeroNode head) {
        this.head = head;
    }

    /**
     * 添加结点到单向链表尾部
     *
     * @param heroNode
     */
    //不按照编号顺序添加 直接添加到最后结点
    //1.找到当前链表的最后结点
    //2.将最后这个结点的next 指向新的结点
    public void addNode(HeroNode heroNode) {
        //因为head结点不能动 需要一个辅助变量temp
        HeroNode temp = head;
        //遍历链表
        while (temp.next != null) {
            //没有找到最后结点 一定要将temp后移
            temp = temp.next;
        }
        //当退出while的循环的时候 temp就指向链表的最后
        //添加新的结点 形成新单链表
        temp.next = heroNode;
    }

    /**
     * 按照顺序添加结点到单向链表中
     *
     * @param heroNode
     */
    //1.找到新的结点的位置
    //2.将新结点heroNode插入进去
    //3.如果存在该数据 则添加失败并给出提示
    // heroNode.next=temp.next
    //temp.next=heroNode
    public void addNode2(HeroNode heroNode) {
        //因为head结点不能动 需要一个辅助变量temp
        HeroNode temp = head;//这里不用head.next
                             //要找到添加结点的前一个辅助结点temp

        boolean flag = true;//用来表示是否添加成功 默认true
        while (true) {
            if (temp.next == null) { //说明temp已经在链表的最后
                break;
            }   else if (heroNode.num < temp.next.num) {
                break;
            }  else if (heroNode.num == temp.next.num) { //s说明添加的结点编号已经存在
                flag = false;
                break;
            }
            temp = temp.next;
        }

        if (flag) {
            heroNode.next = temp.next;
            temp.next = heroNode;
        } else {
            System.out.println(heroNode + "该数据已经存在");
        }

    }

    /**
     * 删除结点(根据结点num删除）
     * 不可以自我删除 必须用删除结点前一个结点辅助删除
     * @param num
     */
    public void deleteNode(int num) {
        if (isEmpty()) {
            System.out.println("链表为空 无法删除结点");
        }
        HeroNode temp = head; //这里不用head.next
                              //要找到删除结点的前一个辅助结点temp
        boolean flag = true; //判断是否删除成功
        while (true) {
            if (temp.next == null) {
                flag = false;
                break;
            }else if(temp.next.num==num){
                break;
            }
            temp=temp.next;
        }
        if(flag){
            temp.next=temp.next.next;
        }else{
            System.out.println("查找不到该数据 无法删除");
        }

    }

    /**
     * 修改结点数据（根据num来修改)
     * @param heroNode
     */
    public void updateNode(HeroNode heroNode) {
        if (isEmpty()) {
            System.out.println("链表为空 无法修改");
            return;
        }
        HeroNode temp = head.next;
        boolean flag = true; //用来表示是否修改成功 默认true
        while (true) {
            if (temp == null) {
                flag = false;
                break;
            } else if (temp.num == heroNode.num) {
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.name = heroNode.name;
            temp.nickName = heroNode.nickName;
        } else {
            System.out.println("找不到该数据 无法修改");
        }
    }

    /**
     * 查找打印指定的结点(根据num来查找）
     * @param num
     */

    public void getNode(int num){
        if(isEmpty()){
            System.out.println("链表为空 无法查找该数据");
            return;
        }

        HeroNode temp=head.next;
        boolean flag=true; //判断是否查找成功
        while (true){
            if(temp==null){
                flag=false;
                break;
            }else if(temp.num==num)
                break;
            temp=temp.next;
        }
        if(flag){
            System.out.println(temp);
        }else{
            System.out.println("该数据不存在 无法查找");
        }
    }

    /**
     * 返回指定的结点（根据num返回）
     * @param num
     * @return
     */

    public HeroNode retrieveNode(int num){
        if(isEmpty()){
            System.out.println("链表为空 无法查找该数据");
            return null;
        }

        HeroNode temp=head.next;
        boolean flag=true; //判断是否查找成功
        while (true){
            if(temp==null){
                flag=false;
                break;
            }else if(temp.num==num)
                break;
            temp=temp.next;
        }
        if(flag){
            return temp;
        }else{
            return null;
        }
    }

    public  int getLength(){

        int length=0;
        HeroNode temp=head;
        while(temp.next!=null){
            length++;
            temp=temp.next;
        }
        return length;
    }

    /**
     * 遍历显示链表的所有结点
     * @param
     */
    public void showList() {
        //判断链表是否为空
        if (isEmpty()) {
            System.out.println("链表为空 无法遍历");
            return;
        }

        //head不能动 需要辅助变量temp
        HeroNode temp = head.next;  //已经判断链表不为空 至少存在一个数据
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;  //将temp后移
        }
    }


    //判断链表是否为空
    public boolean isEmpty() {
        return head.next == null;
    }
}

//定义HeroNode 每一个HeroNode对象就是一个结点
class HeroNode {
    public int num;    //结点的序号
    public String name;
    public String nickName;
    public HeroNode next;  //指向下一个结点

    //结点构造器


    public HeroNode(int num, String name, String nickName) {
        this.num = num;
        this.name = name;
        this.nickName = nickName;
    }

    //重写toString方法

    @Override
    public String toString() {
        return "HeroNode{" +
                "num=" + num +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}

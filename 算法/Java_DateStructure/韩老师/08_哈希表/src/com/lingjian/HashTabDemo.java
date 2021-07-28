package com.lingjian;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @description: 设计哈希表
 * @author: Ling Jian
 * @date: 2020-03-02 20:14
 **/
public class HashTabDemo {
    public static void main(String[] args) {
        HashMap<String, String> h = new HashMap<>();
        //创建哈希表
        HashTab hashTab = new HashTab(7);
        boolean loop = true;
        char key = ' ';
        Scanner sc = new Scanner(System.in);
        while (loop) {
            System.out.println("add(a): 添加雇员");
            System.out.println("list(l): 显示雇员");
            System.out.println("find(f): 查找雇员");
            System.out.println("delete(d): 删除雇员");
            System.out.println("exit(e): 退出系统");
            key = sc.next().charAt(0);
            switch (key) {
                case 'a':
                    System.out.println("输入id");
                    Integer id = sc.nextInt();
                    System.out.println("输入姓名");
                    String name = sc.next();
                    Emp emp = new Emp(id, name);
                    hashTab.add(emp);
                    break;
                case 'l':
                    hashTab.list();
                    break;
                case 'f':
                    System.out.println("请输入你要查找的id");
                    id = sc.nextInt();
                    hashTab.findEmpById(id);
                    break;
                case 'd':
                    System.out.println("请输入你要删除的id");
                    id=sc.nextInt();
                    hashTab.deleteEmpById(id);
                    break;
                case 'e':
                    sc.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }

    }


}


/**
 * @description: 哈希表类
 * @author: Ling Jian
 * @date: 2020-03-02 20:11
 **/
class HashTab {
    private EmpLinkedList[] empLinkedListArray;
    private int maxSize; //表示链表的条数

    //构造器
    public HashTab(int maxSize) {
        this.maxSize = maxSize;
        empLinkedListArray = new EmpLinkedList[maxSize];
        //一定不能忘了初始化每一个链表
        for (int i = 0; i < maxSize; i++) {
            empLinkedListArray[i] = new EmpLinkedList();

        }
    }

    /**
     * 添加雇员到哈希表
     *
     * @param emp
     */
    public void add(Emp emp) {
        //根据员工的id 得到该员工应当添加到哪条链表
        int number = hashFun(emp.getId());
        empLinkedListArray[number].add(emp);

    }

    public int hashFun(Integer id) {
        return id % maxSize;
    }

    /**
     * 遍历所有链表
     */
    public void list() {
        for (int i = 0; i <maxSize; i++) {
            empLinkedListArray[i].list(i);
        }
    }

    /**
     * 根据id查找雇员信息
     * @param id
     */
    public void findEmpById(Integer id){
        //使用散列函数确定在哪条链表查找
        int number = hashFun(id);
        Emp emp=empLinkedListArray[number].findEmpById(id);
       if(emp==null){
           System.out.println("未找到该雇员");
       }else{
           System.out.println("在"+(number+1)+"条链表找到该雇员");
           System.out.println("该雇员信息为: "+emp);
       }
    }

    /**
     * 根据id删除雇员信息
     * @param id
     */
    public void deleteEmpById(Integer id) {
        //使用散列函数确定在哪条链表查找
        int number = hashFun(id);
        empLinkedListArray[number].deleteEmpById(id);
    }
}


/**
 * @description: 链表类
 * @author: Ling Jian
 * @date: 2020-03-02 20:11
 **/
class EmpLinkedList {
    //头指针 执行第一个Emp 链表的head 直接指向第一个Emp
    private Emp head;

    public EmpLinkedList() {
        head = new Emp();
    }

    public Emp getHead() {
        return head;
    }

    public void setHead(Emp head) {
        this.head = head;
    }

    /**
     * 添加雇员到链表
     * 假定id是自增长 id的分配是从小到大
     * 直接加入本链表的最后即可
     *
     * @param emp
     */
    public void add(Emp emp) {
        //如果是添加该链表的第一个雇员
        if (head.getNext() == null) {
            head.setNext(emp);
            return;
        }
        //不是第一个雇员 使用辅助变量 帮助定位到最后
        Emp temp = head.getNext();
        while (temp.getNext() != null) {
            temp = temp.getNext();
        }
        temp.setNext(emp);

    }

    /**
     * 遍历链表的雇员信息
     */
    public void list(int num) {
        if (head.getNext() == null) {
            System.out.println("第"+(num+1)+"条链表为空");
            return;
        }
        System.out.print("第"+(num+1)+"条链表为: ");
        Emp temp = head.getNext();
        while (temp != null) {
            System.out.println(temp);
            temp = temp.getNext();
        }
    }

    /**
     * 根据id查找雇员
     */
    public Emp findEmpById(Integer id){
        boolean flag=true; //判断是否查找成功
        if(head.getNext()==null){
           return null;
        }
        //辅助指针
        Emp temp=head.getNext();
        while(true){
           if(temp.getId().equals(id)){
               break;
           }
           if(temp.getNext()==null){
               flag=false;
               break;
           }
           temp=temp.getNext();
        }
        if(flag){
            return temp;
        }else{
            return null;
        }

    }

    public void deleteEmpById(Integer id){
        boolean flag=true;  //判断是否删除成功
        if(head.getNext()==null){
            System.out.println("查找不到该雇员 无法删除");
            return;
        }
        Emp temp=head; //辅助变量
        while(true){
            if(temp.getNext().getId().equals(id)){
                break;
            }
            if(temp.getNext()==null){
                flag=false;
                break;
            }
            temp=temp.getNext();

        }
        if(flag){
            System.out.println("删除成功");
            temp.setNext(temp.getNext().getNext());
        }else{
            System.out.println("查找不到该雇员 无法删除");
        }
    }


}

/**
 * @description: 员工类
 * @author: Ling Jian
 * @date: 2020-03-02 20:11
 **/
class Emp {
    private Integer id;
    private String name;
    private Emp next;  //默认为null


    public Emp() {
    }

    public Emp(Integer id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Emp getNext() {
        return next;
    }

    public void setNext(Emp next) {
        this.next = next;
    }


    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

package com.lingjian.jianzhi;




import java.util.LinkedList;

/**
 * @description: 请实现两个函数，分别用来序列化和反序列化二叉树
 * @author: Ling Jian
 * @date: 2020-06-12 20:52
 **/
public class    Test_37 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        String serial = serialize(root);
        String serial1 = serialize1(root);
        System.out.println(serial);
        System.out.println(serial1);

        TreeNode newRoot = deserialize(serial);
        System.out.println(newRoot.val);
        System.out.println(newRoot.left.val);
        System.out.println(newRoot.right.val);
        System.out.println(newRoot.right.left.val);
        System.out.println(newRoot.right.right.val);

    }

    //序列化（leetCode版）
    public static String serialize(TreeNode root) {
        if (root == null) {
            return "[]";
        }
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while(!list.isEmpty()){
            TreeNode temp = list.poll();
            if (temp != null) {
                sb.append(temp.val + ",");
                list.add(temp.left);
                list.add(temp.right);
            }else{
                sb.append("null,");
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        return sb.toString();

    }

    //反序列化(左神版）
    public static TreeNode deserialize(String data) {
        if(data.equals("[]")){
            return null;
        }
        String[] str = data.substring(1, data.length() - 1).split(",");
        LinkedList<TreeNode> list = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(str[0]));
        list.add(root);
        int i=1;
        while(!list.isEmpty()){
            TreeNode temp = list.poll();
            temp.left = generateNodeByString(str[i++]);
            temp.right = generateNodeByString(str[i++]);
            if (temp.left != null) {
                list.add(temp.left);
            }

            if (temp.right != null) {
                list.add(temp.right);
            }

        }
        return root;
    }

    public static TreeNode generateNodeByString(String val) {
        if (val.equals("null")) {
            return null;
        }
        return new TreeNode(Integer.parseInt(val));
    }


    //左神序列化
    public static String serialize1(TreeNode root) {
        if (root == null) {
            return "[]";
        }
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(root.val+",");
        while(!list.isEmpty()){
            TreeNode temp = list.poll();
            if (temp.left!= null) {
                sb.append(temp.left.val + ",");
                list.add(temp.left);
            }else{
                sb.append("null,");
            }

            if (temp.right!= null) {
                sb.append(temp.right.val + ",");
                list.add(temp.right);
            }else{
                sb.append("null,");
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        return sb.toString();
    }





    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}

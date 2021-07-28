package com.lingjian.jianzhi;

/**
 * @description: 找二叉树中指定节点的深度 （节点的值互不相同）
 * @author: Ling Jian
 * @date: 2020-06-30 16:03
 **/
public class Test_68_3 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        int val=7;
        int res = findDepth(root, val,0).depth;
        int res1 = findDepth1(root, val, 0);
        System.out.println(res);
        System.out.println(res1);

    }

    public static ReturnType findDepth(TreeNode root, int val,int i) {
        if(root==null){
            return new ReturnType(false, -1);
        }
        if(root.val==val){
            return new ReturnType(true, i);
        }

        ReturnType L=findDepth(root.left,val,i+1);
        if(L.flag){
            return new ReturnType(true, L.depth);
        }
        ReturnType R=findDepth(root.right,val,i+1);
        if(R.flag){
            return new ReturnType(true, R.depth);
        }
        return new ReturnType(false, -1);

    }

    public static int findDepth1(TreeNode root, int val,int i){
        if(root==null){
            return -1;
        }
        if(root.val==val){
            return i;
        }
        int L=findDepth1(root.left,val,i+1);
        if(L!=-1) return L;
        int R = findDepth1(root.right, val, i+1);
        if(R!=-1) return R;
        return -1;
    }


    static class ReturnType{
        public boolean flag;
        public int depth;

        public ReturnType(boolean flag, int depth) {
            this.flag = flag;
            this.depth = depth;
        }
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}

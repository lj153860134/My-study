package com.lingjian.tree.lingjian_4;

/**
 * @description: 平衡二叉树 （平衡二叉搜索树） AVL树
 * @author: Ling Jian
 * @date: 2020-03-10 14:31
 **/
public class BalancedBinaryTree {
    public static void main(String[] args) {
        int[] arr = new int[]{4, 3, 6, 5, 7, 8};
        Node head = createBST(arr);
        preOrderTree(head);
        int height = treeHeight(head);
        int leftHeight = treeHeight(head.left);
        int rightHeight = treeHeight(head.right);
        System.out.println();
        System.out.println("树的高度为" + height);
        System.out.println("左子树的高度为" + leftHeight);
        System.out.println("右子树的高度为" + rightHeight);

        //经过左旋转
        head = leftRotate(head);
        preOrderTree(head);
        height = treeHeight(head);
        leftHeight = treeHeight(head.left);
        rightHeight = treeHeight(head.right);
        System.out.println();
        System.out.println("旋转后树的高度为" + height);
        System.out.println("旋转后左子树的高度为" + leftHeight);
        System.out.println("旋转后右子树的高度为" + rightHeight);


    }


    //进行左旋转
    public static Node leftRotate(Node head) {
        //创建新的结点 已当前根结点的值
        Node temp = new Node(head.value);
        //将根结点的左子树作为新结点的左子树
        temp.left = head.left;
        //将根结点的右子树的左子树作为新结点的右子树
        temp.right = head.right.left;
        //将根结点的值改为其右子数的值
        head.value = head.right.value;
        //将根结点的右子树的右子树作为其新的右子树
        head.right = head.right.right;
        //将新结点作为根结点新的左子树
        head.left=temp;
        return head;
    }

    //创建二叉搜索树
    public static Node createBST(int[] arr) {
        if (arr == null) {
            return null;
        }
        Node head = new Node(arr[0]);
        //创建头结点
        for (int i = 1; i < arr.length; i++) {
            addNode(head, new Node(arr[i]));
        }
        return head;
    }

    //递归添加结点
    public static void addNode(Node head, Node node) {
        if (node.value >= head.value) {
            if (head.right != null) {
                addNode(head.right, node);
            } else {
                head.right = node;
            }
        }
        if (node.value < head.value) {
            if (head.left != null) {
                addNode(head.left, node);
            } else {
                head.left = node;
            }
        }
    }

    //递归前序遍历
    public static void preOrderTree(Node head) {
        if (head == null) {
            return;
        }
        System.out.print(head.value + " ");
        preOrderTree(head.left);
        preOrderTree(head.right);
    }

    //递归中序遍历
    public static void inOrderTree(Node head) {
        if (head == null) {
            return;
        }
        inOrderTree(head.left);
        System.out.println(head.value);
        inOrderTree(head.right);
    }

    //树的高度
    public static int treeHeight(Node head) {
        if (head == null) {
            return 0;
        }
        return Math.max(treeHeight(head.left), treeHeight(head.right)) + 1;
    }

    //定义结点
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }
}

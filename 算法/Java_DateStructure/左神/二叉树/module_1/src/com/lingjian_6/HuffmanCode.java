package com.lingjian_6;

import java.util.*;

/**
 * @description: 哈夫曼编码
 * @author: Ling Jian
 * @date: 2020-03-09 11:31
 **/
public class HuffmanCode {
    public static void main(String[] args) {
        String sendMessage = "i like like like java do you like a java";
        //将字符串转换为字节数组
        byte[] bytes = sendMessage.getBytes();
//        System.out.println(bytes.length);
        //将字节数组中的字节以及权重放入集合中
        List<Node> list = getNodes(bytes);
        //根据权重排序
        Collections.sort(list);
//        System.out.println(list);

        //创建赫夫曼树
        Node head = creatHuffmanTree(list);
        //前序遍历
//        PreOrderTree(head);

        //生成赫夫曼编码
//        Node node1=new Node((byte)97,1);
//        Node node2=new Node((byte)98,2);
//        Node node3=new Node(null,3);
//        node3.left=node1;
//        node3.right=node2;
        getHuffmanCodes(head, "", new StringBuilder());
        System.out.println(huffmanCodes);

        //压缩生成赫夫曼字节数组
        StringBuilder huffman = new StringBuilder();
        for (byte aByte : bytes) {
            huffman.append(huffmanCodes.get(aByte));
        }
        //生成赫夫曼字节数组的字符串
        System.out.println(huffman.toString());
        System.out.println(huffman);
        System.out.println(huffman.length());

        //统计返回byte[] huffmanCodeBytes长度
//        int len=huffman.length()%8==0?huffman.length()/8:huffman.length()/8+1;
        //也可以写成下面一句话 更简洁
        int len = (huffman.length() + 7) / 8;

        //创建压缩后的byte[]数组
        byte[] huffmanCodeBytes = new byte[len];
        for (int i = 0; i < huffman.length(); i += 8) {
            //最后不够8位
            if (i + 8 > huffman.length()) {
                String strByte = huffman.substring(i);
                huffmanCodeBytes[i / 8] = (byte) Integer.parseInt(strByte, 2);
            } else {
                String strByte = huffman.substring(i, i + 8);
                //将StrByte转换成一个byte 放入压缩后的byte[]数组
                huffmanCodeBytes[i / 8] = (byte) Integer.parseInt(strByte, 2);
            }
        }

        //打印压缩后的byte[]数组
        System.out.println(Arrays.toString(huffmanCodeBytes));

        //接收端 转换成原二进制字符串
        String str = getBinaryString(huffmanCodeBytes);
        System.out.println(str);

        //接收端收到的最终消息
        String getMessage = binaryToMessage(str);
        System.out.println(getMessage);


    }

    //将字符串转换为字节数组
    public static List<Node> getNodes(byte[] bytes) {
        List<Node> list = new ArrayList<>();
        Map<Byte, Integer> map = new HashMap<>();
        for (byte aByte : bytes) {
            if (!map.containsKey(aByte)) {
                map.put(aByte, 1);
            } else {
                map.put(aByte, map.get(aByte) + 1);
            }
        }

        for (Map.Entry<Byte, Integer> entry : map.entrySet()) {
            list.add(new Node(entry.getKey(), entry.getValue()));
        }
        return list;
    }

    //创建赫夫曼树
    public static Node creatHuffmanTree(List<Node> list) {
        while (list.size() > 1) {
            //排序 有两种方法
            //Node实现Comparable接口 实现compareTo方法
            //在这里用内部实现类 实现Comparator接口 实现compare方法
            Collections.sort(list);
//            System.out.println(list);
            //取出最小的前两个权值节点
            Node leftNode = list.get(0);
            Node rightNode = list.get(1);

            //生成新的结点
            Node parent = new Node(null, leftNode.weight + rightNode.weight);
            parent.left = leftNode;
            parent.right = rightNode;

            //移除这两个节点
            list.remove(leftNode);
            list.remove(rightNode);

            //将新结点放入集合中
            list.add(parent);


        }
        return list.get(0);
    }

    //用静态Map存储赫夫曼编码的对应关系
    static HashMap<Byte, String> huffmanCodes = new HashMap<>();

    //生成赫夫曼树对应的赫夫曼编码
    public static void getHuffmanCodes(Node head, String code, StringBuilder sb) {
        StringBuilder str = new StringBuilder(sb);
        str.append(code);
//        sb.append(code);
        if (head.data != null) {
            huffmanCodes.put(head.data, str.toString());
            return;
        }
        getHuffmanCodes(head.left, "0", str);
        getHuffmanCodes(head.right, "1", str);

    }

    //将字节转换成二进制字符串
    public static String byteToString(byte b, boolean flag) {
        String str;
        int temp = b;
        if (flag) {
            temp |= 256;
            str = Integer.toBinaryString(temp);
            return str.substring(str.length() - 8);

        } else {
            str = Integer.toBinaryString(temp);
            return str;
        }
    }

    //将字节数组转换成原二进制字符串
    public static String getBinaryString(byte[] bytes) {

        StringBuilder sb = new StringBuilder();
        boolean flag;
        for (int i = 0; i < bytes.length; i++) {
            flag = i == bytes.length - 1 ? false : true;
            sb.append(byteToString(bytes[i], flag));
        }
        return sb.toString();
    }

    //将原二进制字符串转换成接收到的消息
    public static String binaryToMessage(String string) {
        //将静态Map存储赫夫曼编码的对应关系 进行反转
        HashMap<String, Byte> reverseHuffmanCodes = new HashMap<>();
        for (Byte b : huffmanCodes.keySet()) {
            reverseHuffmanCodes.put(huffmanCodes.get(b), b);
        }
//        System.out.println(reverseHuffmanCodes);
        StringBuilder sb = new StringBuilder();
        int count=1;
        for (int i = 0; i < string.length(); ) {
            Byte b;
            String str = string.substring(i, i + count);
            b = reverseHuffmanCodes.get(str);
            if (b == null) {
                count++;
            } else {
                sb.append((char) (byte) (b));
                i+=count;
                count = 1;
            }
        }

        return sb.toString();
    }

    //定义结点
    public static class Node implements Comparable<Node> {
        public Byte data; //存放数据本身 'a'对应97 ' '对应32
        public int weight;//权值 字符出现的次数
        public Node left;
        public Node right;

        public Node(Byte data, int weight) {
            this.data = data;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }


        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", weight=" + weight +
                    '}';
        }
    }

    //递归前序遍历
    public static void PreOrderTree(Node head) {
        if (head == null) {
            return;
        }
        System.out.println(head);
        PreOrderTree(head.left);
        PreOrderTree(head.right);
    }
}

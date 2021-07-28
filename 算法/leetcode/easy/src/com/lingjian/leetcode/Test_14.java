package com.lingjian.leetcode;

import com.sun.xml.internal.fastinfoset.util.PrefixArray;

/**
 * @description: 编写一个函数来查找字符串数组中的最长公共前缀
 * 如果不存在公共前缀，返回空字符串 ""
 * @author: Ling Jian
 * @date: 2020-06-15 15:38
 **/
public class Test_14 {
    public static void main(String[] args) {
        String[] strs = new String[]{"aaa","aa","aaa"};
        String res = longestCommonPrefix1(strs);
        System.out.println(res);


    }

    //暴力法
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        char[] chs = strs[0].toCharArray();
        StringBuilder sb = new StringBuilder();
        int res = chs.length;
        for (int i = 1; i < strs.length; i++) {
            char[] chs1 = strs[i].toCharArray();
            int index = Math.min(chs1.length, res);
            res = 0;
            for (int j = 0; j < index; j++) {
                if (chs[j] == chs1[j]) {
                    res++;
                } else {
                    break;
                }
            }
            if (res == 0) {
                return "";
            }
        }
        for (int i = 0; i < res; i++) {
            sb.append(chs[i]);
        }
        return sb.toString();
    }

    //用前缀树
    public static String longestCommonPrefix1(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        Trie trie = new Trie();
        trie.insert(strs[0]);
        String res = "";
        for (int i = 1; i <strs.length ; i++) {
            res=trie.search(strs[i]);
            if("".equals(res)){
                return "";
            }
        }
        return res;
    }


    //前缀树结点
    public static class TrieNode {
        public int path;
        public int end;
        public TrieNode[] nexts;


        public TrieNode() {
            this.nexts = new TrieNode[26];
        }
    }

    //前缀树
    public static class Trie {
        private TrieNode root;

        public Trie() {
            this.root = new TrieNode();
        }


        //插入字符串
        public void insert(String word) {
            if (word == null) {
                return;
            }
            char[] chs = word.toCharArray();
            TrieNode node = root;
            int index = 0;
            for (int i = 0; i < chs.length; i++) {
                index = chs[i] - 'a';
                if (node.nexts[index] == null) {
                    node.nexts[index] = new TrieNode();
                }
                node = node.nexts[index];
                node.path++;
            }
            node.end++;
        }

        public String  search(String word){
            if(word==null){
                return "";
            }
            char[] chs = word.toCharArray();
            TrieNode node = root;
            int index=0;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i <chs.length ; i++) {
                index = chs[i] - 'a';
                if(node.nexts[index]==null){
                    node.nexts = new TrieNode[26];
                    return sb.toString();
                }
                sb.append(chs[i]);
                node = node.nexts[index];
            }
            node.nexts=new TrieNode[26];
            return sb.toString();
        }
    }


}

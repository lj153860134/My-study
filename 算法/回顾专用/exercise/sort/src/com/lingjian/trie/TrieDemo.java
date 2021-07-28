package com.lingjian.trie;

import javax.swing.*;

/**
 * @description: 前缀树（字典树）
 * @author: Ling Jian
 * @date: 2020-06-15 15:55
 **/
public class TrieDemo {
    public static void main(String[] args) {

    }

    //前缀树结点
    public static class TrieNode{
        public int path;
        public int end;
        public TrieNode[] nexts;


        public TrieNode() {
            this.nexts = new TrieNode[26];
        }
    }

    //前缀树
    public static class Trie{
        private TrieNode root;

        public Trie() {
            this.root = new TrieNode();
        }

        //插入字符串
        public  void insert(String word) {
            if(word==null){
                return;
            }
            char[] chs = word.toCharArray();
            TrieNode node = root;
            int index=0;
            for (int i = 0; i <chs.length ; i++) {
                 index = chs[i] - 'a';
                if(node.nexts[index]==null){
                    node.nexts[index] = new TrieNode();
                }
                node = node.nexts[index];
                node.path++;
            }
            node.end++;
        }

        //查找字符串出现次数
        public int search(String word) {
            if (word == null) {
                return 0;
            }
            char[] chs = word.toCharArray();
            TrieNode node = root;
            int index=0;
            for (int i = 0; i <chs.length ; i++) {
              index = chs[i] - 'a';
                if (node.nexts[index] == null) {
                    return 0;
                }
                node = node.nexts[index];
            }
            return node.end;
        }

        //删除字符串
        public void delete(String word) {
            if(search(word)==0){
                return;
            }
            char[] chs = word.toCharArray();
            TrieNode node = root;
            int index = 0;
            for (int i = 0; i < chs.length; i++) {
                index = chs[i] - 'a';
                if(--node.nexts[index].path==0){
                    node.nexts[index]=null;
                    return;
                }
                node = node.nexts[index];
            }
            node.end--;
        }
    }



}

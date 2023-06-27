package com.xzq.study.tree;

/**
 * 前缀树
 */
public class Code_TrieTree {

    //前缀树节点
    public static class TrieNode {
        public int pass;    //该节点通过的次数
        public int end;     //该节点结束的次数
        // 当字符总类过多时，可以使用 ;
        // HashMap<char, Node> nexts;
        // TreeMap<char, Node> nexts;
        public TrieNode[] nexts;

        //初始化根节点
        public TrieNode() {
            pass = 0;
            end = 0;
            //nexts[0] == null  没有走向下标为0的‘路’
            //nexts[0] != null  有走向下标为0的‘路’
            //nexts[25] != null 没有走向下标25的‘路’
            nexts = new TrieNode[26];//标识26个字母
        }
    }

    public static class Trie{
        private TrieNode root;

        public Trie(){
            root = new TrieNode();
        }

        //添加单词
        public void insert(String word){
            if(word == null){
                return;
            }
            char[] chars = word.toCharArray();
            TrieNode node = root;
            node.pass++;

            int index = 0;//字符存储的下标
            for (int i = 0; i < chars.length; i++) {
                index = chars[i] - 'a';//字符‘a’的 ascll 码 97， 即获取字符数组下标
                if(node.nexts[index] == null){
                    node.nexts[index] = new TrieNode();
                }
                //node移动到下一个节点
                node = node.nexts[index];
                //通过次数加1
                node.nexts[index].pass++;
            }
            node.end++;
        }

        //删除单词
        public void delete(String word){
            //查询有该字符串，在进行删除
            if(search(word) != 0){
                char[] chars = word.toCharArray();
                TrieNode node = root;
                node.pass--;
                int index = 0;

                for (int i = 0; i < chars.length; i++) {
                    index = chars[i] - 'a';

                    //当某个点的的通过节点数量已经为0，表示该前缀树该字符已经没有了，直接置空
                    if(--node.nexts[index].pass == 0){
                        node.nexts[index] = null;
                        return;
                    }
                    node = node.nexts[index];
                }
                node.end--;
            }
        }

        //查询单词出现次数
        public int search(String word){
            if(word == null){
                return 0;
            }
            char[] chars = word.toCharArray();
            TrieNode node = root;
            int index = 0;

            for (int i = 0; i < chars.length; i++) {
                index = chars[i] - 'a';
                if(node.nexts[index] == null){
                    return 0;
                }
                node = node.nexts[index];
            }
            return node.end;
        }

        //查询相同前缀出现次数
        public int prefixNumber(String word){
            if(word == null){
                return 0;
            }
            char[] chars = word.toCharArray();
            TrieNode node = root;
            int index = 0;

            for (int i = 0; i < chars.length; i++) {
                index = chars[i] - 'a';
                if(node.nexts[index] == null){
                    return 0;
                }
                node = node.nexts[index];
            }
            return node.pass;
        }
    }
}

package com.xzq.study.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树序列化
 * 例子:1_2_#_3_4_#_5
 */
public class TreeOperation {
    public static void main(String[] args) {

    }

    public static String serialByPre(Node head) {
        if(head == null){
            return "#_";
        }
        String treeStr = head.value + "_";
        treeStr += serialByPre(head.left);
        treeStr += serialByPre(head.right);
        return treeStr;
    }

    public static Node reconByPreString(String preStr){
        String[] values = preStr.split("_");
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < values.length; i++) {
            queue.add(values[i]);
        }
        return reconPreOrder(queue);
    }
    public static Node reconPreOrder(Queue<String> queue){
        String value = queue.poll();
        if(value.equals("#")){
            return null;
        }
        Node head = new Node(Integer.valueOf(value));
        head.left = reconPreOrder(queue);
        head.right = reconPreOrder(queue);
        return head;
    }
}

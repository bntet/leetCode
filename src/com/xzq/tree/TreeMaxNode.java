package com.xzq.tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class TreeMaxNode {



    public static void main(String[] args) {
        Node<Integer> integerNode = new Node<Integer>(2);
        Node<Integer> integerNode2 = new Node<Integer>(1);
        Node<Integer> integerNode3 = new Node<Integer>(3);
        integerNode.setLeft(integerNode2);
        integerNode.setRight(integerNode3);

        /**使用hashMap,求树的最大宽度*/
//        int i = treeMaxNode(integerNode);
//        System.out.println(i);



        /**检查是否完全二叉树*/
        Boolean aBoolean = checkCBT(integerNode);
        System.out.println(aBoolean);
    }

    /**
     * 使用hashmap，记录树的最大宽度
     * @param head
     * @return
     */
    public static int treeMaxNode(Node head) {
        //建立一个队列
        Queue<Node> queue = new LinkedList<>();
        //设置头节点
        queue.add(head);
        //建立一个map,记录节点所在层数
        HashMap<Node, Integer> levelMap = new HashMap<>();
        //设置头节点在第一层
        levelMap.put(head, 1);
        //curLevel:当前在哪一层
        int curLevel = 1;
        //curLevelNodes:当前层有几个节点
        int curLevelNodes = 0;
        //记录最大宽度
        int max = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            //队列弹出
            Node cur = queue.poll();
            //获取弹出节点层数
            int curNodeLevel = levelMap.get(cur);
            //弹出节点层数 == 当前层数
            if (curNodeLevel == curLevel) {
                //当前层数节点++
                curLevelNodes++;
            } else {
                //不相同, 表示已经进入下一层
                //层数++
                curLevel++;
                //当前层节点数量初始化
                curLevelNodes = 1;
            }
            //赋值最大节点数量
            max = Math.max(max, curLevelNodes);
            if (cur.left != null) {
                //左子节点不为空, 加入map中
                levelMap.put(cur.left, curNodeLevel + 1);
                //入队列
                queue.add(cur.left);
            }
            if (cur.right != null) {
                //右子节点不为空, 加入map中
                levelMap.put(cur.right, curNodeLevel + 1);
                //入队列
                queue.add(cur.right);
            }
        }
        return max;
    }



    /**
     * 检查是否完全二叉树
     * 1.任意节点 有右节点 没有左节点 直接false
     * 2.条件1不违规，如果遇到第一个左右子节点不全，后续皆为叶节点
     * @param head
     * @return
     */
    public static Boolean checkCBT(Node head){
        Queue<Node> queue = new LinkedList();
        queue.add(head);
        Boolean hasPerfectChild = false;   //是否遇到左右孩子节点不全的节点
        Node l;                 //左孩子节点
        Node r;                 //右孩子节点
        while (!queue.isEmpty()){
            head = queue.poll();
            l = head.left;
            r = head.right;
            if(
                    (hasPerfectChild && (l != null || r != null)) ||     //当已经遇到左右孩子节点不全的节点时， 如果左右孩子还有值，则不是完全二叉树
                    (l == null && r != null))                            //当左孩子为 null, 右孩子不为 null, 则不是完全二叉树
            {
                return false;
            }

            if(l != null){
                queue.add(l);
            }
            if(r != null){
                queue.add(r);
            }

            if(l == null || r == null){                             //遇到左右孩子节点不全的节点时， 标记 true
                hasPerfectChild = true;
            }
        }
        return true;
    }

    /**
     * 检查是否平衡二叉树
     * 1.对于任何一个子树来说，左树与右树的高度差不超过1
     * @param head
     * @return
     */
    public static Boolean checkBalance(Node head){

        return true;
    }
}

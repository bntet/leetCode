package com.xzq.study.tree;

/**
 * 完全二叉树
 * 1.任意节点 有右节点 没有左节点 直接false
 * 2.条件1不违规，如果遇到第一个左右子节点不全，后续皆为叶节点
 */
public class CheckCompleteBinaryTree {


    public static void main(String[] args) {
        Node<Integer> integerNode = new Node<Integer>(2);
        Node<Integer> integerNode2 = new Node<Integer>(1);
        Node<Integer> integerNode3 = new Node<Integer>(3);
        integerNode.setLeft(integerNode2);
        integerNode.setRight(integerNode3);
    }
}

package com.xzq.tree;

/**
 * 满二叉树
 */
public class CheckFullBinaryTree {
    public static void main(String[] args) {
        Node<Integer> integerNode = new Node<Integer>(2);
        Node<Integer> integerNode2 = new Node<Integer>(1);
        Node<Integer> integerNode3 = new Node<Integer>(3);
        integerNode.setLeft(integerNode2);
        integerNode.setRight(integerNode3);

        Boolean full = isFull(integerNode);
        System.out.println("is Full Binary tree?" + full);
    }

    public static Boolean isFull(Node node){
        if(node == null){
            return true;
        }
        Info f = f(node);
        return f.nodes == ((1 << f.height) -1);
    }

    public static class Info{
        public int height;//树的高度
        public int nodes;//节点个数

        public Info(int height, int nodes) {
            this.height = height;
            this.nodes = nodes;
        }
    }

    public static Info f(Node x){
        if(x == null){
            return new Info(0, 0);
        }
        Info leftNode = f(x.left);
        Info rightNode = f(x.right);
        int height = Math.max(leftNode.height, rightNode.height) + 1;
        int nodes = leftNode.nodes + rightNode.nodes + 1;
        return new Info(height, nodes);
    }

    public void testMargeBranch(){
        System.out.println("test");
        System.out.println("test dev");
    }
}

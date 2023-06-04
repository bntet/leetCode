package com.xzq.study.tree;

/**
 * 检查是否搜索二叉树
 * 1.每一颗子树左侧节点比它小，右侧比它大
 */
public class CheckBinarySearchTree {

    //全局最小值
    public static int preValue = Integer.MIN_VALUE;

    public static class ReturnData{
        Boolean isBst;
        int min;
        int max;

        public ReturnData(Boolean isBst, int min, int max) {
            this.isBst = isBst;
            this.min = min;
            this.max = max;
        }

        public Boolean getBst() {
            return isBst;
        }

        public void setBst(Boolean bst) {
            isBst = bst;
        }

        public int getMin() {
            return min;
        }

        public void setMin(int min) {
            this.min = min;
        }

        public int getMax() {
            return max;
        }

        public void setMax(int max) {
            this.max = max;
        }
    }

    public static void main(String[] args) {
        Node<Integer> integerNode = new Node<Integer>(2);
        Node<Integer> integerNode2 = new Node<Integer>(1);
        Node<Integer> integerNode3 = new Node<Integer>(3);
        integerNode.setLeft(integerNode2);
        integerNode.setRight(integerNode3);
        /**检查是否是搜搜二叉树--递归 */
        Boolean aBoolean = checkBst(integerNode);
        System.out.println(aBoolean);
    }

    /**
     * 检查是否搜索二叉树--递归
     * @param head
     * @return
     */
    public static Boolean checkBst(Node head){
        if(head == null){
            return true;
        }
        Boolean isLeftBst = checkBst(head.left);
        if(!isLeftBst){
            return false;
        }
        if((int)head.value <= preValue){
            return false;
        }else{
            preValue = (int)head.value;
        }
        return checkBst(head.right);
    }

    /**
     * 检查是否搜索二叉树--不递归，使用栈
     * @param head
     * @return
     */
    public static Boolean checkBst2(Node head){
        return true;
    }

    /**
     * 检查是否搜搜二叉树--使用递归套路
     * 1。左树是搜索二叉树，右树是搜索二叉树
     * 2.左树最大值小于 x, 右树最小值大于 x
     * @param head
     * @return
     */
    public static Boolean checkBst3(Node head){

        return true;
    }
    public ReturnData process(Node<Integer> x){
        if(x == null){
            return null;
        }
        ReturnData leftData = process(x.left);
        ReturnData rightData = process(x.right);

        Boolean isBst = true;//默认搜索二叉树
        int min = x.value;
        int max = x.value;

        //获取最小和最大值
        if(leftData != null){
            min = Math.min(min, leftData.min);
            max = Math.max(max, leftData.max);
        }
        if(rightData != null){
            min = Math.min(min, rightData.min);
            max = Math.max(max, rightData.max);
        }

        //判断是否搜索二叉树
        //左边不是搜索二叉树   ||   左子树最大值 >= 当前树的值
        if(leftData != null && (!leftData.isBst || leftData.max >= x.value)){
            isBst = false;
        }
        //右边不是搜索二叉树   ||   右子树最小值 <= 当前树的值
        if(rightData != null && (!rightData.isBst || rightData.min <= x.value)){
            isBst = false;
        }

        return new ReturnData(isBst, min, max);
    }
}



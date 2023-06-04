package com.xzq.study.tree;

/**
 * 二叉树折纸问题
 * 1.根节点：凹
 * 2.左子树节点：凹，右子树节点：凸
 */
public class TreePaperFoldingQuestion {
    public static void main(String[] args) {
        printFold(3);
    }

    public static void paperFold(int N, int i,boolean down){
        if(i > N){
            return;
        }
        paperFold(N, i + 1, true);
        System.out.println(down ? "凹" : "凸");
        paperFold(N, i + 1, false);
    }

    public static void printFold(int N){
        paperFold(N, 1, true);
    }
}

package com.xzq.study.graph.template;

import java.util.ArrayList;

/**
 * 图 点结构
 */
public class Node {
    public int value;//值
    public int in;//入度: 指向当前点的个数
    public int out;//出度：指向其他点的个数
    public ArrayList<Node> nexts;//指向下一个点的集合
    public ArrayList<Edge> edges;//指向下一个点的边的集合

    public Node(int value) {
        this.value = value;
        this.in = 0;
        this.out = 0;
        this.nexts = new ArrayList<>();
        this.edges = new ArrayList<>();
    }
}

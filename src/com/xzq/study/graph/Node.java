package com.xzq.study.graph;

import java.sql.Array;
import java.util.ArrayList;

/**
 * 图 点结构
 */
public class Node {
    public int value;
    public int in;//入度
    public int out;//出度
    public ArrayList<Node> nexts;//下一个节点
    public ArrayList<Edge> edges;//边

    public Node(int value) {
        this.value = value;
        this.in = 0;
        this.out = 0;
        this.nexts = new ArrayList<>();
        this.edges = new ArrayList<>();
    }
}

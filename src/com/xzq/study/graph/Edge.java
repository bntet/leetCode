package com.xzq.study.graph;

/**
 * 边:有向边
 * 无向边：两个有向边组合
 */
public class Edge {
    public int weight;//权值
    public Node from;//来自哪里
    public Node to;//到哪里

    public Edge(int weight, Node from, Node to) {
        this.weight = weight;
        this.from = from;
        this.to = to;
    }
}

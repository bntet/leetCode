package com.xzq.study.graph;


import java.util.HashMap;
import java.util.HashSet;

/**
 * 图 结构
 */
public class Graph {
    //点集合
    public  HashMap<Integer, Node> nodes;
    //边集合
    public  HashSet<Edge> edges;

    public Graph() {
        this.nodes = new HashMap<>();
        this.edges = new HashSet<>();
    }
}

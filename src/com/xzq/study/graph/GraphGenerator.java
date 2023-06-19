package com.xzq.study.graph;

import com.xzq.study.graph.template.Edge;
import com.xzq.study.graph.template.Graph;
import com.xzq.study.graph.template.Node;

/**
 * GraphGenerator
 * 图结构转化
 */
public class GraphGenerator {

    /**
     * 二维数组 转 图结构
     * @param matrix
     * @return
     */
    public static Graph createGraph(Integer[][] matrix){
        Graph graph = new Graph();
        for (int i = 0; i < matrix.length; i++) {
            Integer from = matrix[i][0];        //假设下标：0 为出发点
            Integer to = matrix[i][1];          //假设下标：1 为目标点
            Integer weight = matrix[i][2];      //假设下标：2 为 权值

            //该值不在图中，设置该点
            if (!graph.nodes.containsKey(from)){
                graph.nodes.put(from, new Node(from));
            }
            //该值不在图中，设置该点
            if (!graph.nodes.containsKey(to)){
                graph.nodes.put(from, new Node(to));
            }

            //设置边
            Node fromNode = graph.nodes.get(from);
            Node toNode = graph.nodes.get(to);
            Edge edge = new Edge(weight, fromNode, toNode);

            //设置下个节点
            fromNode.nexts.add(toNode);
            fromNode.out++;
            toNode.in++;
            //设置边
            fromNode.edges.add(edge);
            graph.edges.add(edge);
        }
        return graph;
    }
}

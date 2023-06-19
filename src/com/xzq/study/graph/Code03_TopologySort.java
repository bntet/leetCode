package com.xzq.study.graph;

import com.xzq.study.graph.template.Graph;
import com.xzq.study.graph.template.Node;

import java.util.*;

/**
 * 拓扑排序
 * 适用范围：要求有向图， 且有入度为0的节点， 且没有环
 * 1.找到入度为0的点
 * 2.去除 入度为0的点 的影响（即 去除入度为0的点指向下一个点的边）
 * 3.找下一个入度为0的点
 */
public class Code03_TopologySort {
    public static void main(String[] args) {

    }

    public static List<Node> sortedTopology(Graph graph){
        //key:某一个node， value:剩余的入度
        HashMap<Node, Integer> inMap = new HashMap<>();
        //入度为0的点，才能进入的队列
        Queue<Node> zeroInQueue = new LinkedList<>();

        //设置每个节点的入度 map
        for (Node node : graph.nodes.values()) {
            inMap.put(node, node.in);
            if(node.in == 0){
                //当入度为0时，设置到队列中
                zeroInQueue.add(node);
            }
        }

        List<Node> result = new ArrayList<>();
        while (!zeroInQueue.isEmpty()){
            Node cur = zeroInQueue.poll();
            //加入结果列表
            result.add(cur);
            //擦去下个节点的引用
            for (Node next : cur.nexts) {
                //下个节点入度 减1
                inMap.put(next, inMap.get(next) - 1);
                if (inMap.get(next) == 0){
                    //入度为0时加入队列
                    zeroInQueue.add(next);
                }
            }

        }
        return result;
    }
}

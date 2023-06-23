package com.xzq.study.graph;


import com.xzq.study.graph.template.Edge;
import com.xzq.study.graph.template.Node;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * dijktra 算法
 * 适用范围：没有权值为负数的边，不能有累加和为负数的环
 */
public class Code06_Dijkstra {

    public static HashMap<Node, Integer> dijktra(Node head){
        /*
        distanceMap:记录节点到head节点的权值
        key: 从head节点出发到达的节点
        value: 从head节点出发到达的节点的距离
        如果map中，没有该记录，则表示head到该点的距离为正无穷
         */
        HashMap<Node, Integer> distanceMap = new HashMap<>();
        distanceMap.put(head, 0);

        //存放已经计算过最短权值的节点, 后续不在计算
        HashSet<Node> selectNodes = new HashSet<>();

        Node minNode = getMinDistanceAndUnselectNode(distanceMap, selectNodes);
        while (minNode != null){
            Integer distance = distanceMap.get(minNode);
            for (Edge edge : minNode.edges) {
                Node toNode = edge.to;
                if(!distanceMap.containsKey(toNode)){
                    distanceMap.put(toNode, edge.weight + distance);
                }
                distanceMap.put(toNode, Math.min(distanceMap.get(toNode), edge.weight + distance));
            }
            selectNodes.add(minNode);
            minNode = getMinDistanceAndUnselectNode(distanceMap, selectNodes);
        }
        return distanceMap;
    }

    /**
     * 返回最小权值的，且不在selectNodes中的节点
     * @param distanceMap
     * @param selectNodes
     * @return
     */
    public static Node getMinDistanceAndUnselectNode(HashMap<Node, Integer> distanceMap, HashSet<Node> selectNodes){
        Node minNode = null;
        int minDistance = Integer.MAX_VALUE;
        for (Map.Entry<Node, Integer> entry : distanceMap.entrySet()) {
            Node key = entry.getKey();
            int value = entry.getValue();
            if(!selectNodes.contains(key) && value < minDistance){
                minNode = key;
                minDistance = value;
            }
        }
        return minNode;
    }
}

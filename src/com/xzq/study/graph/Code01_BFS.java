package com.xzq.study.graph;

import com.xzq.study.graph.template.Node;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * bfs: breadth first search
 * 广度优先算法（宽度优先搜索）
 */
public class Code01_BFS {

    /**
     * 使用宽度优先遍历
     * 重一个节点出发
     * @param node
     */
    public static void bfs(Node node){
        if (node == null){
            return;
        }
        //队列
        Queue<Node> queue = new LinkedList<>();
        //使用set保证同一个点不要重复进入队列。 防止有无向图，或者有向图存在环的情况
        HashSet<Node> set = new HashSet<>();
        queue.add(node);
        set.add(node);

        while (!queue.isEmpty()){
            Node poll = queue.poll();

            //处理逻辑
            System.out.println(poll.value);

            for (Node next : poll.nexts) {
                //保证 节点不会重复添加
                if(!set.contains(next)){
                    set.add(next);
                    queue.add(next);
                }
            }
        }
    }
}

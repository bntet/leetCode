package com.xzq.study.graph;

import com.xzq.study.graph.template.Node;

import java.util.HashSet;
import java.util.Stack;

/**
 * DFS：depth first search
 * 深度优先算法
 */
public class Code02_DFS {

    /**
     *
     * @param node
     */
    public static void dfs(Node node){
        if (node == null){
            return;
        }

        Stack<Node> stack = new Stack<>();
        HashSet<Node> set = new HashSet<>();
        stack.add(node);
        set.add(node);

        //深度优先 是添加节点的时候处理逻辑
        System.out.println(node.value);

        while (!stack.isEmpty()){
            Node pop = stack.pop();
            for (Node next : pop.nexts) {

                if(!set.contains(next)){
                    //set中不包含临近节点，节点重新进栈,临近节点随后进栈
                    stack.add(pop);
                    stack.add(next);
                    set.add(next);

                    //临近节点进栈处理逻辑
                    System.out.println(next);
                    break;
                }
            }
        }
    }
}

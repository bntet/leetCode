package com.xzq.study;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 贪心算法
 * 场景：只有一个会议室，如何有效的安排会议
 * 方法：根据会议的结束时间来安排
 */
public class Code_BestArrange {

    //会议类
    public static class Program{
        int start;  //开始时间
        int end;    //结束时间

        public Program(int start, int end){
            this.start = start;
            this.end = end;
        }
    }

    public static class ProgramComparator implements Comparator<Program> {
        @Override
        public int compare(Program o1, Program o2) {
            return o1.end - o2.end;
        }
    }

    public static int bestArrange(Program[] program, int timePoint){
        //根据会议结束时间从小到大排序
        Arrays.sort(program, new ProgramComparator());
        int result = 0;
        for (int i = 0; i < program.length; i++) {
            if(program[i].start >= timePoint){
                result++;
                timePoint = program[i].end;
            }
        }
        return result;
    }
}

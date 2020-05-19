package 刷题.leetcode;

import java.util.*;

/**
 * @author Ryan
 * @date 2020/5/2 20:25
 */
public class _1353 {
    /**
     * 第一种方法，暴力超时了
     * @param events
     * @return
     */
    public int maxEvents(int[][] events) {
        Arrays.sort(events, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1]==o2[1])
                    return o1[0]-o2[0];
                return o1[1]-o2[1];
            }
        });
        int count=0;
        int[] days=new int[events[events.length-1][1]+1];
        for(int[] event:events){
            for(int i=1;i<days.length;i++){
                if(days[i]==0&&i>=event[0]&&i<=event[1]){
                    days[i]=1;
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    /**
     * 还是超时了
     */
    public int maxEvents2(int[][] events) {
        Arrays.sort(events, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1]==o2[1])
                    return o1[0]-o2[0];
                return o1[1]-o2[1];
            }
        });
        //int[] days=new int[events[events.length-1][1]+1];
        Set<Integer> set=new HashSet<>();
        for(int[] event:events){
            for(int i=event[0];i<=event[1];i++){
                if(set.add(i)) break;
            }
        }
        return set.size();
    }
    public int maxEvents3(int[][] events) {
        //首先排序：开始时间小的在前。这样是方便我们顺序遍历，把开始时间一样的都放进堆
        Arrays.sort(events, (o1, o2) -> o1[0] - o2[0]);
        //小顶堆
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        //结果、开始时间、events下标、有多少组数据
        int res = 0, last = 1, i = 0, n = events.length;
        while (i < n || !pq.isEmpty()) {
            //将start相同的会议都放进堆里
            while (i < n && events[i][0] == last) {
                pq.offer(events[i++][1]);
            }
            //pop掉当前天数之前的
            while (!pq.isEmpty() && pq.peek() < last) {
                pq.poll();
            }
            //顶上的就是俺们要参加的
            if (!pq.isEmpty()) {
                pq.poll();
                res++;
            }
            last++;
        }
        return res;
    }
}

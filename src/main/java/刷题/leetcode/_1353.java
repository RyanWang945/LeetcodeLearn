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

    /**
     * 这是一道典型的扫描算法题。由于每个时间点最多参加一个会议，我们可以从1开始遍历所有时间。
     *
     * 对于每一个时间点，所有在当前时间及之前时间开始，并且在当前时间还未结束的会议都是可参加的。
     * 显然，在所有可参加的会议中，选择结束时间最早的会议是最优的，因为其他会议还有更多的机会可以去参加。
     *
     * 怎样动态获得当前结束时间最早的会议呢？我们可以使用一个小根堆记录所有当前可参加会议的结束时间。
     * 在每一个时间点，我们首先将当前时间点开始的会议加入小根堆，再把当前已经结束的会议移除出小根堆（因为已经无法参加了），
     * 然后从剩下的会议中选择一个结束时间最早的去参加。
     *
     * 为了快速获得当前时间点开始的会议，我们以O(N)O(N)时间预处理得到每个时间点开始的会议的序号。
     *
     * 算法总的时间复杂度为O(T\log N)O(TlogN)（这里的TT为时间范围）。
     *
     */
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

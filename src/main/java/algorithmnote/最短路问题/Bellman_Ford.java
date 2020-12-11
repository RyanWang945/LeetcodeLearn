package algorithmnote.最短路问题;

import java.util.Arrays;

/**
 * @author Ryan
 * @date 2020/6/4 21:33
 */
public class Bellman_Ford {
    int inf=(int)1e8+7;
    public int networkDelayTime(int[][] times, int N, int K) {
        // 存放 K 到各个点的最短路径，最大的那个最短路径即为结果
        int[] distance = new int[N + 1];
        Arrays.fill(distance, inf);
        distance[K] = 0;
        // 进行 N-1 轮的松弛，因为任意两点间的最短路径最多包含 N-1 条边
        for (int i = 1; i <= N - 1; i++) {
            for (int[] time : times) {
                // 源节点
                int u = time[0];
                // 目标节点
                int v = time[1];
                // 一个信号源从源节点到目标节点的时间
                int w = time[2];
                // 判断能否通过 u->v 缩短 distance[v]（松弛）
                if (distance[u] != inf) {
                    if (distance[v] == inf) {
                        distance[v] = distance[u] + w;
                    } else {
                        distance[v] = Math.min(distance[v], distance[u] + w);
                    }
                }
            }
        }

        int maxDistance = 0;
        for (int i = 1; i <= N; i++) {
            if (distance[i] == -1) {
                return -1;
            }
            maxDistance = Math.max(distance[i], maxDistance);
        }

        return maxDistance;
    }
}

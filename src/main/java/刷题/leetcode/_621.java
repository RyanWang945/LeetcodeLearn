package 刷题.leetcode;

import java.util.*;

/**
 * @author Ryan
 * @date 2020/6/6 10:47
 */
public class _621 {
    public int leastInterval(char[] tasks, int n) {
        Integer[] map = new Integer[26];
        for (char c: tasks)
            map[c - 'A']++;
        Arrays.sort(map);
        Arrays.sort(map,(o1,o2)->o2-o1);
        int time = 0;
        while (map[25] > 0) {
            int i = 0;
            while (i <= n) {
                if (map[25] == 0)
                    break;
                if (i < 26 && map[25 - i] > 0)
                    map[25 - i]--;
                time++;
                i++;
            }
            Arrays.sort(map);
        }
        return time;
    }
}

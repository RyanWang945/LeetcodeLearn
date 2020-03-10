package 周赛;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Ryan
 * @date 2020/3/8 11:25
 */
public class _3_8numOfMinutes {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        if(n==1)
            return 0;
        int time=0;
        Queue<Integer> queue=new LinkedList<>();
        while(!queue.isEmpty()){
            while(!queue.isEmpty()){
                Integer person = queue.poll();
            }
        }
        return -1;
    }
}

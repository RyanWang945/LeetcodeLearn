package 刷题.leetcode;

import java.util.*;

/**
 * @author Ryan
 * @date 2020/1/2 18:26
 */
public class _47AllArrange2 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        int len=nums.length;
        Arrays.sort(nums);
        boolean[] hashtable=new boolean[len];
        ArrayList<Integer> path=new ArrayList<>();
        int depth=0;
        List<List<Integer>> results=new ArrayList<>();
        dfs(nums,path,depth,results,hashtable);
        return results;
    }
    private void dfs(int[] nums,ArrayList<Integer> path,int depth,List<List<Integer>> results,boolean[]hashtable){
        if (depth == nums.length) {
            results.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!hashtable[i]) {
                // 修改 2：因为排序以后重复的数一定不会出现在开始，故 i > 0
                // 和之前的数相等，并且之前的数还未使用过，只有出现这种情况，才会出现相同分支
                // 这种情况跳过即可
                if (i > 0 && nums[i] == nums[i - 1] && !hashtable[i - 1]) {
                    continue;
                }
                hashtable[i] = true;
                path.add(nums[i]);
                dfs(nums, path, depth, results, hashtable);
                path.remove(i);
                hashtable[i] = false;
            }
        }
    }
}

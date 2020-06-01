package 刷题.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ryan
 * @date 2020/5/31 19:32
 */
public class _698 {
    int target;
    boolean flag=false;
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum=0;
        for(int i:nums){
            sum+=i;
        }
        if((sum%k)!=0)
            return false;
        target=sum/k;
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<k;i++){
            list.add(new ArrayList<>());
        }
        boolean[] hashtable=new boolean[nums.length];
        dfs(nums,k,0,0,0,list,hashtable);
        return flag;
    }
    private void dfs(int[] nums,int k,int used,int tempsum,int index,List<List<Integer>> list,boolean[] hashtable){
        if(flag==true) return;
        if(index==k) return;
        if(tempsum==target){
            index++;
            tempsum=0;
        }else if(tempsum>target){
            return;
        }
        if(index==k&&used==nums.length){
            flag=true;
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(hashtable[i]==false){
                tempsum+=nums[i];
                hashtable[i]=true;
                list.get(index).add(nums[i]);
                dfs(nums,k,used+1,tempsum,index,list,hashtable);
                hashtable[i]=false;
                tempsum-=nums[i];
                list.get(index).remove(list.get(index).size()-1);
            }
        }
    }
    private boolean backtracking(int[] nums, int k, int target, int cur, int start, boolean[] used) {
        // 返回条件
        if (k == 0) return true;
        if (cur == target) {
            // 构建下一个集合
            return backtracking(nums, k-1, target, 0, 0, used);
        }
        for (int i = start; i < nums.length; i++) {
            if (!used[i] && cur+nums[i] <= target) {
                used[i] = true;
                if (backtracking(nums, k, target, cur+nums[i], i+1, used)) return true;
                used[i] = false;
            }
        }
        return false;
    }

    public boolean canPartitionKSubsets2(int[] nums, int k) {
        // 注意nums[i] > 0
        int sum = 0, maxNum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (maxNum < nums[i]) maxNum = nums[i];
        }
        if (sum % k != 0 || maxNum > sum/k) return false;
        boolean[] used = new boolean[nums.length];
        return backtracking(nums, k, sum/k, 0, 0, used);
    }
}

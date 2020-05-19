package 刷题.leetcode;

import java.util.ArrayList;
import java.util.List;


public class _46permute{
    List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        if(nums.length==0) return ans;
        int n=nums.length;
        boolean[] hashtable=new boolean[n];
        int[] temp=new int[n];
        dfs(hashtable,nums,temp,0);
        return ans;
    }
    private void dfs(boolean[] hashtable,int[] nums,int[] temp,int index){
        if(index==hashtable.length){
            List<Integer> r=new ArrayList<>();
            for(int i:temp){
                r.add(i);
            }
            ans.add(r);
        }
        for(int i=0;i<hashtable.length;i++){
            if(hashtable[i]==false){
                hashtable[i]=true;
                temp[index]=nums[i];
                dfs(hashtable,nums,temp,index+1);
                hashtable[i]=false;
            }
        }
    }
    public List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        if(nums.length<1)
            return null;
        for(int i:nums){
            List<Integer> temp;
            List<List<Integer>> ttt=new ArrayList<>();
            for(List<Integer> t:ans){
                int len=t.size();
                for(int j=0;j<len+1;j++){
                    temp=new ArrayList<>();
                    temp.addAll(t);
                    temp.add(j,i);
                    ttt.add(temp);
                }
            }
            if(ans.isEmpty()){
                temp=new ArrayList<>();
                temp.add(i);
                ans.add(temp);
            }else{
                ans=ttt;
            }
        }
        return ans;
    }
}






















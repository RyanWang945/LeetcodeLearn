package leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**1302 2031
 * @author Ryan
 * @date 2020/3/24 21:23
 */
public class _51 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans=new ArrayList<>();
        if(n==0)
            return ans;
        boolean[] hashtable=new boolean[n];
        int[] nums=new int[n];
        dfs(0,ans,hashtable,n,nums);
        return ans;
    }
    private void dfs(int index,List<List<String>> ans,boolean[]hashtable,int n,int[]nums){
        if(index==n&&check(nums)){
            List<String> b=new ArrayList<>();
            for(int i=0;i<n;i++){
                String a="";
                for(int j=0;j<n;j++){
                    if(nums[i]==j)
                        a=a+"Q";
                    else a=a+".";
                }
                b.add(a);
            }
            ans.add(b);
            return;
        }
        for(int i=0;i<n;i++){
            if(hashtable[i]==false){
                hashtable[i]=true;
                nums[index]=i;
                dfs(index+1,ans,hashtable,n,nums);
                hashtable[i]=false;
            }
        }
    }
    private boolean check(int[]nums){
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums.length;j++){
                if(nums[i]==nums[j]||(Math.abs(nums[i]-nums[j])==Math.abs(i-j)))
                    return false;
            }
        }
        return true;
    }

    @Test
    public void test(){
        List<List<String>> lists = solveNQueens(4);
        for(List<String> list:lists){
            for(String s:list){
                System.out.println(s);
            }
        }
    }

}

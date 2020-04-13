package 刷题.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Ryan
 * @date 2020/3/31 18:53
 */
public class _898 {
    /**
     * 方法1.on2的dp
     * 超时了
     */
    public int subarrayBitwiseORs(int[] A) {
        int n=A.length;
        if(n==1) return 1;
        if(n==0) return 0;
        int[][] dp=new int[n][n];
        Set<Integer> ans=new HashSet<>();
        for(int len=1;len<=n;len++){
            for(int i=0;i<=n-len;i++){
                int j=i+len-1;
                if(len==1){
                    dp[i][j]=A[i];
                    ans.add(dp[i][j]);
                    continue;
                }
                dp[i][j]=dp[i][j-1]|A[j];
                ans.add(dp[i][j]);
            }
        }
        return ans.size();
    }
    public int subarrayBitwiseORs1(int[] A) {
        Set<Integer> ans=new HashSet<>();
        Set<Integer> curr=new HashSet<>();
        for(int a:A){
            Set<Integer> next=new HashSet<>();
            next.add(a);
            for(int b:curr){
                next.add(a|b);
            }
            ans.addAll(next);
            curr=next;
        }
        return ans.size();
    }
    public int subarrayBitwiseORs2(int[] A) {
        int n=A.length;
        if(n<2) return n;
        Set<Integer> ans=new HashSet<>();
        for(int i=0;i<n;i++){
            ans.add(A[i]);
            for(int j=i-1;j>=0;j--){
                if((A[j]&A[i])==A[i]) break;
                A[j]|=A[i];
                ans.add(A[j]);
            }
        }
        return ans.size();
    }
}

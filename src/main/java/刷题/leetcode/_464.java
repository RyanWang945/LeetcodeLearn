package 刷题.leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Ryan
 * @date 2020/6/11 21:44
 */
public class _464 {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if(maxChoosableInteger>=desiredTotal) return true;
        if((1+maxChoosableInteger)*maxChoosableInteger/2<desiredTotal) return false;
        int[] state=new int[maxChoosableInteger+1];
        return helper(state,desiredTotal,new HashMap<>());
    }
    private boolean helper(int[] state,int desiredTotal,HashMap<String,Boolean> map){
        String key= Arrays.toString(state);
        if(map.containsKey(key)) return map.get(key);
        for(int i=1;i<state.length;i++){
            if(state[i]==0){
                state[i]=1;
                if(desiredTotal-i<=0||!helper(state,desiredTotal-i,map)){
                    map.put(key,true);
                    state[i]=0;
                    return true;
                }
                state[i]=0;
            }
        }
        map.put(key,false);
        return false;
    }
    /**
     * 状压dp
     */
    public boolean canIWin2(int maxChoosableInteger, int desiredTotal) {
        if(maxChoosableInteger>=desiredTotal) return true;
        if((1+maxChoosableInteger)*maxChoosableInteger/2<desiredTotal) return false;
        Boolean[] dp=new Boolean[(1<<maxChoosableInteger)-1];
        return dfs(maxChoosableInteger,desiredTotal,0,dp);
    }
    private boolean dfs(int maxChoosableInteger,int desiredTotal,int state,Boolean[]dp){
        if(dp[state]!=null) return dp[state];
        for(int i=1;i<=maxChoosableInteger;i++){
            int tmp=(1<<(i-1));
            if((tmp&state)==0){
                if(desiredTotal-i<=0||!dfs(maxChoosableInteger,desiredTotal-i,tmp|state,dp)){
                    dp[state]=true;
                    return true;
                }
            }
        }
        dp[state]=false;
        return false;
    }
}

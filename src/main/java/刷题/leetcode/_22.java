package 刷题.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Ryan
 * @date 2020/4/9 14:14
 */
public class _22 {
    public List<String> generateParenthesis(int n) {
        List<String> ans=new ArrayList<>();
        int[] hashtable=new int[2*n];
        dfs(hashtable,ans,0,n,n,n);
        return ans;
    }
    private void dfs(int[] hashtable,List<String> ans,int index,int a,int b,int n){
        if(index==2*n){
            if(isValid(hashtable)&&a==0&&b==0){
                StringBuilder sb=new StringBuilder();
                for(int i:hashtable){
                    if(i==0)
                        sb.append('(');
                    else sb.append(')');
                }
                ans.add(sb.toString());
            }
        }
        if(a<0||b<0)
            return;
        if(a>0){
            hashtable[index]=0;
            dfs(hashtable,ans,index+1,a-1,b,n);
            hashtable[index]=0;
        }
        if(b>0){
            hashtable[index]=1;
            dfs(hashtable,ans,index+1,a,b-1,n);
            hashtable[index]=0;
        }
    }
    private boolean isValid(int[] hashtable){
        Stack<Integer> stack=new Stack<>();
        for(int i:hashtable){
            if(!stack.isEmpty()){
                if(stack.peek()==0&&i==1)
                    stack.pop();
                else
                    stack.push(i);
            }else stack.push(i);
        }
        if(stack.size()==0)
            return true;
        else return false;
    }

    /**
     * 这个方法是递归，我们要明确这个东西的本质，本质是二叉树的深搜
     */
    List<String> ans=new ArrayList<>();
    public List<String> generateParenthesis2(int n) {
        dfs(n,n,"");
        return ans;
    }
    private void dfs(int left,int right,String curStr){
        if(left==0&&right==0){
            ans.add(curStr);
            return;
        }
        if(left>0)
            dfs(left-1,right,curStr+"(");
        if(left<right)
            dfs(left,right-1,curStr+")");
    }

    /**
     * 这种方法是动态规划
     * @param n
     * @return
     */
    //List<String> ans=new ArrayList<>();
    public List<String> generateParenthesis3(int n) {
        if(n==0) return new ArrayList<>();
        List<List<String>> dp=new ArrayList<>();
        List<String> dp0=new ArrayList<>();
        dp0.add("");
        dp.add(dp0);
        for(int i=1;i<=n;i++){
            List<String> cur=new ArrayList<>();
            for(int j=0;j<i;j++){
                List<String> str1=dp.get(j);
                List<String> str2=dp.get(i-1-j);
                for(String s1:str1){
                    for(String s2:str2){
                        cur.add("("+s1+")"+s2);
                    }
                }
            }
            dp.add(cur);
        }
        return dp.get(n);
    }
}

package leetcode;

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
}

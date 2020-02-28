package algorithmnote;

import org.junit.jupiter.api.Test;

import java.util.Stack;

/**
 * @author Ryan
 * @date 2020/1/7 12:07
 */
public class _1_7DFS {
    static int[] nums=new int[]{2,3,0,4,5,6,7,8,1,10,11,12};
    static int target=12;
    static int n=2;
    Stack<Integer> temp=new Stack<>();
    Stack<Integer> ans=new Stack<>();
    static int maxSquare=-1;
    public void dfs(int index,int count,int sum,int sumsquare){
        if(count==n){
            if(sum==target){
                if(sumsquare>maxSquare){
                    maxSquare=sumsquare;
                    if(!ans.empty()){
                        for(int i=0;i<2;i++){
                            ans.pop();
                        }
                    }
                    for(int i=0;i<2;i++){
                        ans.push(temp.get(i));
                    }
                    return;
                }
            }
            return;
        }
        if(index==nums.length||count>2||sum>target) return;
        temp.push(nums[index]);
        dfs(index+1,count+1,sum+nums[index],sumsquare+nums[index]*nums[index]);
        temp.pop();
        dfs(index+1,count,sum,sumsquare);
    }
    @Test
    public void test_DFS(){
        dfs(0,0,0,0);
        for(int x:ans){
            System.out.println(x);
        }
    }
}

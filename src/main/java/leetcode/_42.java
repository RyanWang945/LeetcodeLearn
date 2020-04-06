package leetcode;

import java.util.Stack;

/**
 * @author Ryan
 * @date 2020/4/4 16:03
 */
public class _42 {
    /**
     * 单调栈
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int n=height.length;
        if(n==0||n==1)
            return 0;
        Stack<Integer> stack=new Stack<>();
        int ans=0;
        for(int i=0;i<n;i++){
            //维护栈的同时时刻观察栈顶的值是否小于当前值，如果小于，则不能出循环，还要继续
            while(!stack.isEmpty()&&height[stack.peek()]<height[i]){
                int currIndex=stack.pop();
                while(!stack.isEmpty()&&height[stack.peek()]==height[currIndex])
                    stack.pop();
                if(!stack.isEmpty()){
                    int stackTop=stack.peek();
                    ans+=(Math.min(height[stackTop],height[i])-height[currIndex])*(i-stackTop-1);//因为是求夹在两者之间的距离，所以是a-b-1
                }
            }
            stack.add(i);
        }
        return ans;
    }

    /**
     * bf解法
     * @param height
     * @return
     */
    public int trap2(int[] height) {
        int n=height.length;
        if(n==0||n==1) return 0;
        int ans=0;
        for(int i=1;i<n-1;i++){
            int max_left=0;
            int max_right=0;
            for(int j=i;j>=0;j--){
                max_left=Math.max(max_left,height[j]);
            }
            for(int j=i;j<n;j++){
                max_right=Math.max(max_right,height[j]);
            }
            ans+=Math.min(max_left,max_right)-height[i];
        }
        return ans;
    }
}

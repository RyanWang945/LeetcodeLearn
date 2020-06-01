package 刷题.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Ryan
 * @date 2020/5/30 8:48
 */
public class _84 {
    public int largestRectangleArea(int[] heights) {
        int res=0;
        for(int i=0;i<heights.length;i++){
            int temp=0;
            for(int j=i-1;j>=0;j--){
                if(heights[j]>=heights[i])
                    temp+=heights[i];
                else break;
            }
            for(int j=i+1;j<heights.length;j++){
                if(heights[j]>=heights[i])
                    temp+=heights[i];
                else break;
            }
            temp=temp+heights[i];
            res=Math.max(res,temp);
        }
        return res;
    }
    //看到的元素的高度严格小于当前栈顶元素的高度的时候，出栈
    public int largestRectangleArea2(int[] heights) {
        int res=0;
        Deque<Integer> stack=new ArrayDeque<>();
        int[] new_heights=new int[heights.length+2];
        for(int i=1;i<heights.length+1;i++) new_heights[i]=heights[i-1];
        for(int i=0;i<new_heights.length;i++){
            while(!stack.isEmpty()&&new_heights[stack.peek()]>new_heights[i]){
                int cur=stack.pop();
                res=Math.max(res,(i-stack.peek()-1)*new_heights[cur]);
            }
            stack.push(i);
        }
        return res;
    }
}

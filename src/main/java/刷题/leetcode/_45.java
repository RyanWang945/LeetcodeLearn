package 刷题.leetcode;

/**
 * @author Ryan
 * @date 2020/5/4 8:53
 */
public class _45 {
    /**
     * 它上来就加了一次1，但在结尾没能跳到最后，而是跳到了倒数第二个位置
     * 所以即使上来加一，最后实际上是缺1 的，总额是正确答案
     * 但这种方法不太好理解
     */
    public int jump(int[] nums) {
        int end=0;
        int maxPosition=0;
        int steps=0;
        for(int i=0;i<nums.length-1;i++){
            maxPosition=Math.max(maxPosition,nums[i]+i);
            if(i==end){
                end=maxPosition;
                steps++;
            }
        }
        return steps;
    }
}

package 刷题.leetcode;

/**
 * @author Ryan
 * @date 2020/5/26 19:20
 */
public class _268 {
    public int missingNumber(int[] nums) {
        int ans=0;
        int sum=0;
        for(int i:nums)
            sum+=i;
        int n=nums.length;
        int total=(0+n)*(n+1)/2;
        ans=total-sum;
        return ans;
    }
    public int missingNumber2(int[] nums) {
        int sum=0;
        for(int i:nums)
            sum^=i;
        int total=0;
        for(int i=0;i<=nums.length;i++){
            total^=i;
        }
        return total^sum;
    }
}

package 刷题.leetcode;

/**
 * @author Ryan
 * @date 2020/5/26 8:57
 */
public class _287 {
    public int findDuplicate(int[] nums) {
        int len=nums.length;
        int left=1;
        int right=len-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            int count=0;
            for(int i:nums){
                if(i<=mid)
                    count++;
            }
            if(count>mid)
                right=mid-1;
            else
                left=mid+1;
        }
        return left;
    }
}

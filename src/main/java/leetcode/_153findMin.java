package leetcode;

/**
 * @author Ryan
 * @date 2020/3/3 17:07
 */
public class _153findMin {
    /**
     * [3,4,5,1,2]
     * [0,1,2,3,4]
     * 输出1
     * [3.4,5,6,7,8,0,1,2]
     * [0,1,2,3,4,5,6,7,8]
     * 0
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        int i;
        for(i=0;i<nums.length-1;i++){
            if(i+1<nums.length&&nums[i]<nums[i+1])
                continue;
            else return nums[i+1];
        }
        return nums[0];
    }
    public int findMin2(int[] nums){
        int left=0,right=nums.length-1;
        while(left<right){
            int mid=left+(right-left)/2;
            if(nums[mid]<=nums[right])
                right=mid;
            else
                left=mid+1;
        }
        return nums[left];
    }
}

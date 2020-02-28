package algorithmnote;

/**
 * @author Ryan
 * @date 2019/12/29 16:16
 */
public class InsertSort {
    public int[] sort(int[] nums){
        int n=nums.length;
        for(int i=1;i<n;i++){
            int j=i-1;
            int temp=nums[i];
            for(;j>=0;j--){
                if(temp<nums[j]){
                    nums[j+1]=nums[j];
                }else break;
            }
            nums[j+1]=temp;
        }
        return nums;
    }
}

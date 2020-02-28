package leetcode;

/**
 * @author Ryan
 * @date 2020/2/28 10:41
 */
public class _75sortColors {
    public void sortColors1(int[] nums) {
        int[] counter=new int[3];
        for(int i=0;i<3;i++){
            counter[i]=0;
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                counter[1]++;
            }else if(nums[i]==0){
                counter[0]++;
            }else
                counter[2]++;
        }
        int index=0;
        for(int i=0;i<3;i++){
            for(int j=0;j<=counter[i]-1;j++){
                nums[index]=i;
                index++;
            }
        }
    }
    public void sortColors2(int[] nums){
        int left=0;
        int right=nums.length-1;
        for(int i=0;i<=right;i++){
            if(nums[i]==0){
                swap(nums,i,left++);
            }else if(nums[i]==2){
                swap(nums,i--,right--);
            }
        }

    }
    private void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}

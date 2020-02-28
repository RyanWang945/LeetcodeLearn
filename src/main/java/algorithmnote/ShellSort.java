package algorithmnote;

/**
 * @author Ryan
 * @date 2019/12/30 12:15
 */
public class ShellSort {
    public int[] shellsort(int[] nums){
        int temp=0;
        int increase=nums.length;
        while(true){
            increase=increase/2;
            for(int k=0;k<increase;k++){
                for(int i=k+increase;i<nums.length;i+=increase){
                    for(int j=i;j>k;j-=increase){
                        if(nums[j]<nums[j-increase]){
                            temp=nums[j-increase];
                            nums[j-increase]=nums[j];
                            nums[j]=temp;
                        }else break;
                    }
                }
            }
            if(increase==1){
                break;
            }
        }
        return nums;
    }
}

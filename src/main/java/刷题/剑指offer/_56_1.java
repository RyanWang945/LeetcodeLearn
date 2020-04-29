package 刷题.剑指offer;

/**
 * @author Ryan
 * @date 2020/4/28 9:16
 */
public class _56_1 {
    public int[] singleNumbers(int[] nums) {
        int sum=0;
        for(int i:nums){
            sum^=i;
        }
        int temp=1;
        while((sum&temp)==0)
            temp<<=1;
        int sum1=0,sum2=0;
        for(int i:nums){
            if((i&temp)==temp){
                sum1^=i;
            }else
                sum2^=i;
        }
        int[] ans=new int[2];
        ans[0]=sum1;
        ans[1]=sum2;
        return ans;
    }
}

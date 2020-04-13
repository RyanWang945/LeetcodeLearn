package 刷题.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ryan
 * @date 2020/3/13 9:43
 */
public class _229majorityElement {
    public List<Integer> majorityElement(int[] nums){
        List<Integer> res=new ArrayList<>();
        if(nums==null||nums.length==0){
            return res;
        }
        int[] ans=new int[2];
        int[] count=new int[2];
        for(int num:nums){
            if(num==ans[0]){
                count[0]++;
                continue;
            }
            if(num==ans[1]){
                count[1]++;
                continue;
            }
            if(count[0]==0){
                ans[0]=num;
                count[0]++;
                continue;
            }
            if(count[1]==0){
                ans[1]=num;
                count[1]++;
                continue;
            }
            count[0]--;
            count[1]--;
        }
        count[0]=count[1]=0;
        for(int num:nums){
            if(num==ans[0])
                count[0]++;
            else if(num==ans[1])
                count[1]++;

        }
        int n=nums.length;
        if(count[0]>n/3)
            res.add(ans[0]);
        if(count[1]>n/3)
            res.add(ans[1]);
        return res;
    }
    @Test
    public void test(){
        int[] nums=new int[]{1,2,2,3,2,1,1,3};
        List<Integer> list = majorityElement2(nums);
        for(int i:list){
            System.out.println(i);
        }
    }
    public List<Integer> majorityElement2(int[] nums) {
        List<Integer> ans=new ArrayList<>();
        int[] count=new int[2];
        int[] temp=new int[2];
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]!=temp[0]&&nums[i]!=temp[1]){
                if(count[0]==0){
                    count[0]=1;
                    temp[0]=nums[i];
                }else if(count[1]==0){
                    count[1]=1;
                    temp[1]=nums[i];
                }else{
                    count[0]--;
                    count[1]--;
                }
            }else{
                if(nums[i]==temp[0])
                    count[0]++;
                if(nums[i]==temp[1])
                    count[1]++;
            }
        }
        int count1=0,count2=0;
        for(int i:nums){
            if(temp[0]==i)
                count1++;
            else if(temp[1]==i)
                count2++;
        }
        if(count1*3>n)
            ans.add(temp[0]);
        if(count2*3>n)
            ans.add(temp[1]);
        return ans;
    }
}

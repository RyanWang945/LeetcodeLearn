package leetcode;

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
}

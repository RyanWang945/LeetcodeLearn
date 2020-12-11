package 刷题.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ryan
 * @date 2020/6/15 10:32
 */
public class _1477 {
    public int minSumOfLengths(int[] arr, int target) {
        List<int[]> list=new ArrayList<>();
        int left=0,right=0;
        int sum=0;
        while(right<arr.length&&left<arr.length){
            if(sum<target)
                sum+=arr[right++];
            if(sum>target){
                sum-=arr[left++];
            }
            if(sum==target){
                list.add(new int[]{left,right-1});
                sum-=arr[left++];
            }
        }
        if(sum==target) list.add(new int[]{left,right-1});
        if(list.size()<2) return -1;
        int len=list.size();
        int[] dp=new int[len+1];
        dp[len]=Integer.MAX_VALUE;
        for(int i=len-1;i>=0;i--){
            int[] p=list.get(i);
            dp[i]=Math.min(dp[i+1],p[1]-p[0]+1);
        }
        System.out.print(list.size());
        int[] ps=new int[len];
        int pi=0;
        for(int[] p:list) ps[pi++]=p[0];
        int min=Integer.MAX_VALUE;
        for(int i=0;i<len-1;i++){
            int[] a=list.get(i);
            int l=i+1,r=len-1;
            while(l<r){
                int mid=l+(r-l)/2;
                if(ps[mid]<=a[1]) l=mid+1;
                else r=mid;
            }
            if(ps[l]>a[1])
                min=Math.min(min,(a[1]-a[0]+1)+dp[l]);
        }
        return min==Integer.MAX_VALUE?-1:min;
    }

    /**
     * 无敌 的线性复杂度，服了
     * @param arr
     * @param target
     * @return
     */
    public int minSumOfLengths2(int[] arr, int target) {
        int index1 = -1;//记录第一个符合条件的最短子数组在arr中的起始位置
        int index2 = -1;//记录第一个符合条件的最短子数组在arr中的介绍位置
        int len1 = -1;//记录第一个符合条件的最短子数组的长度
        int len2 = -1;//记录第二个符合条件的最短子数组的长度
        int sum = 0;
        //========================
        int fast = arr.length-1;
        int slow = arr.length-1;
        while(fast>=0){
            sum += arr[fast];
            if(sum>target){
                while(sum>target){
                    sum -= arr[slow];
                    slow--;
                }
            }
            if(sum==target){
                if(len1==-1) {
                    len1 = slow-fast+1;
                    index1 = fast;
                    index2 = slow;
                }else {
                    if(len1 > slow-fast+1) {
                        len1 = slow-fast+1;
                        index1 = fast;
                        index2 = slow;

                    }
                }
            }
            fast--;
        }
        if(len1==-1){//当len==-1, 说明没有任何一个符合条件的子数组,直接返回-1；
            return -1;
        }
        //====================================
        //将arr中未使用的数组部分依次复制到temp数组中
        int[] temp = new int[arr.length-index2+index1-1];
        int index = 0;
        for(int i=0;i<index1;i++) {
            temp[index++] = arr[i];
        }
        for(int i=index2+1;i<arr.length;i++) {
            temp[index++] = arr[i];
        }
        //========================================
        //遍历数组temp, 寻找第二个符合条件的子数组
        sum = 0;
        fast = temp.length-1;
        slow = temp.length-1;
        while(fast>=0){
            sum += temp[fast];
            if(sum>target){
                while(sum>target){
                    sum -= temp[slow];
                    slow--;
                }
            }
            if(sum==target){
                if(len2==-1) {
                    len2 = slow-fast+1;
                }else {
                    if(len2 > slow-fast+1) {
                        len2 = slow-fast+1;

                    }
                }
            }
            fast--;
        }
        //========================
        if(len1!=-1&&len2!=-1){
            return len1+len2;
        }
        return -1;
    }
}

package 刷题.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ryan
 * @date 2019/12/25 15:47
 * @version 1.0
 */
public class _1twosum {
    /**
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int array[]=new int[2];
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    array[0]=i;
                    array[1]=j;
                    //return array;
                    return new int[]{i,j};
                }
            }
        }
        throw new IllegalArgumentException("no such value");
    }
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        for(int i=0;i<nums.length;i++){
            int temp=target-nums[i];
            if(map.containsKey(temp)&&map.get(temp)!=i)
                return new int[]{i,map.get(temp)};
        }
        throw new IllegalArgumentException("no such solution");
    }

    public static void main(String[] args) {
        Map<Integer,Integer> map=new HashMap<>();
        map.put(3,0);
        map.put(3,1);
        map.put(3,2);
        map.put(2,3);
        map.put(2,4);
        map.put(2,5);
        map.put(2,6);
        System.out.println(map.get(3));
        System.out.println(map.get(3));
        System.out.println(map.get(3));
        System.out.println(map.get(2));
        System.out.println(map.get(2));
        System.out.println(map.get(2));
        System.out.println(map.get(2));
        System.out.println(map.get(2));
        System.out.println(map.get(2));
    }
}

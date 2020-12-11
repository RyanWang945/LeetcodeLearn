package 刷题.牛客;

import java.util.*;

/**
 * @author Ryan
 * @date 2020/8/2 11:01
 */
public class Solution {
    public static int getWinner(int[] arr, int k) {
        if(k>=arr.length){
            Arrays.sort(arr);
            return arr[arr.length-1];
        }
        List<Integer> list=new LinkedList<>();
        for(int i=0;i<arr.length;i++){
            list.add(arr[i]);
        }
        int count=0;
        while(true){
            if(list.get(0)>list.get(1)) {
                int temp = list.get(1);
                list.remove(1);
                list.add(temp);
                count++;
                if(count==k) return list.get(0);
            }else{
                int temp=list.get(0);
                list.remove(0);
                list.add(temp);
                count=1;
                if(count==k) return list.get(0);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr=new int[]{1,25,35,42,68,70};
        int k=1;
        System.out.println(getWinner(arr,k));
    }
}

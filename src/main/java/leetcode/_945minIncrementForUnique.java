package leetcode;

import java.util.Arrays;

/**
 * @author Ryan
 * @date 2020/3/23 20:45
 */
public class _945minIncrementForUnique {
    public int minIncrementForUnique(int[] A){
        int count=0;
        Arrays.sort(A);
        for(int i=1;i<A.length;i++){
            if(A[i]<=A[i-1]){
                int temp=A[i];
                A[i]=A[i-1]+1;
                count=A[i]-temp;
            }
        }
        return count;
    }
    public int minIncrementForUnique2(int[] A){
        int count=0;
        int[] hashtable = new int[40001];
        int max=-1;
        for(int i:A){
            hashtable[i]++;
            max=Math.max(max,i);
        }
        for(int i=0;i<=max;i++){
            if(hashtable[i]>1){
                int d=hashtable[i]-1;
                count+=d;
                hashtable[i+1]+=d;
            }
        }
        int d=hashtable[max]-1;
        count+=(1+d)*d/2;
        return count;
    }
}

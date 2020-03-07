package leetcode面试系列;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ryan
 * @date 2020/3/6 9:18
 * (1+x)x/2=target
 * x/2+x^2/2=target
 *
 */
public class _57 {
    public int[][] findContinuousSequence(int target) {
        List<int[]> ans=new ArrayList<>();
        int start=1;
        int last=(int)(-0.5f+Math.sqrt(0.25f+4*target/2));
        while((last-start+1)>=2){
            int sum=(start+last)*(last-start+1)/2;
            if(sum==target){
                int index=start;
                int[] a=new int[last-start+1];
                for(int i=0;i<last-start+1;i++){
                    a[i]=index++;
                }
                ans.add(a);
                start++;
            }
            if(sum<target){
                last++;
            }
            if(sum>target){
                start++;
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }

    public static void main(String[] args) {
        System.out.println((int)(-0.5f+Math.sqrt(0.25f+4*9/2)));
    }

}

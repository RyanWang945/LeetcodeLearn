package 刷题.leetcode;

import org.junit.jupiter.api.Test;

/**
 * @author Ryan
 * @date 2020/3/11 8:48
 */
public class _1013canThreePartsEqualSum {
    public boolean canThreePartsEqualSum(int[] A) {
        int sum=0;
        for(int i=0;i<A.length;i++){
            sum+=A[i];
        }
        if(sum%3!=0)
            return false;
        int target=sum/3;
        int temp1=0;
        int j;
        int i;
        for(i=0;i<A.length;i++){
            temp1+=A[i];
            if(temp1==target){
                j=i+1;
                break;
            }else if(i==A.length-1)
                return false;
        }
        int temp2=0;
        for(j=i+1;j<A.length;j++){
            temp2+=A[j];
            if(temp2==target){
                if(j==A.length-1)
                    return false;
                return true;
            }else if(j==A.length-1)
                return false;
        }
        return false;
    }
    @Test
    public void test(){
        int[] a={18,12,-18,18,-19,-1,10,10};
        boolean ans=canThreePartsEqualSum(a);
        System.out.println(ans);
    }
}

package leetcode;

/**
 * @author Ryan
 * @date 2020/2/25 12:00
 */
public class _633TowSquareSum {
    public boolean judgeSquareSum(int c) {
        int index2=(int)Math.sqrt(c);
        int index1=0;
        while(index1<index2){
            int sum=index1*index1+index2*index2;
            if(sum==c)
                return true;
            else if(sum>c)
                index2--;
            else if(sum<c)
                index1++;
        }
        return false;
    }
}

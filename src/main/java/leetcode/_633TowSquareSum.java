package leetcode;

/**
 * @author Ryan
 * @date 2020/2/25 12:00
 */
public class _633TowSquareSum {
    public boolean judgeSquareSum(int c) {
        int index2=(int)Math.sqrt(c);
        int index1=1;
        while(index1<index2){
            if((index1*index1+index2*index2)>c)
                index2--;
            else if((index1*index1+index2*index2)<c)
                index1++;
            if((index1*index1+index2*index2)==c)
                return true;
        }
        return false;
    }
}

package 刷题.leetcode;

/**
 * @author Ryan
 * @date 2020/5/9 21:08
 */
public class _191 {
    public int hammingWeight(int n) {
        int count=0;
        while(n!=0){
            if(n%2!=0){
                count++;
            }
            n=n>>>1;
        }
        return count;
    }
}

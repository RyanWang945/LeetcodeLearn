package 刷题.leetcode;

/**
 * @author Ryan
 * @date 2020/3/3 14:14
 */
public class _69mySqrt {
    public int mySqrt1(int x) {
        long left=0,right=x;
        while(left<=right){
            long mid=left+(right-left)/2;
            long target=mid*mid;
            if(target==x)
                return (int)mid;
            else if(target>x)
                right=mid-1;
            else if(target<x)
                left=mid+1;
        }
        return (int)right;
    }
    public int mySqrt2(int x){
        int left=0,right=x;
        while(left<=right){
            int mid=left+(right-left)/2;
            int sqrt=x/mid;
            if(sqrt==mid)
                return sqrt;
            else if(sqrt>mid){
                right=mid-1;
            }else if(sqrt<mid){
                left=mid+1;
            }
        }
        return right;
    }
}

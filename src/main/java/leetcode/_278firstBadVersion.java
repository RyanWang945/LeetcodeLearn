package leetcode;

/**
 * @author Ryan
 * @date 2020/3/3 16:59
 */
public class _278firstBadVersion {
    public boolean isBadVersion(int n){
        return true;
    }

    /**
     * [0,0,0,0,0,1,1,1,1]
     * [1,2,3,4,5,6,7,8,9]
     * @param n
     * @return
     */
    public int firstBadVersion(int n) {
        int left=0,right=n;
        while(left<right){
            int mid=left+(right-left)/2;
            boolean s=isBadVersion(mid);
            if(s)
                right=mid;
            else
                left=mid+1;
        }
        return left;
    }
}

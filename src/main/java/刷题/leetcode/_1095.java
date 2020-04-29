package 刷题.leetcode;

/**
 * @author Ryan
 * @date 2020/4/29 9:13
 */
public class _1095 {
    private interface MountainArray {
        public int get(int index);
        public int length();
    }
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int left=0,right=mountainArr.length()-1;
        while(left<=right){
            int mid=(left+right)/2;
            int a=mountainArr.get(mid);
            int b=mountainArr.get(mid+1);
            if(a<b){
                left=mid+1;
            }else if(a>b){
                right=mid-1;
            }
        }
        int top=0;
        if(mountainArr.get(left)>mountainArr.get(right)){
            top=left;
        }else top=right;
        //System.out.print(top);
        if(mountainArr.get(top)==target) return top;
        left=0;
        right=top-1;
        while(left<=right){
            int mid=(left+right)/2;
            int midval=mountainArr.get(mid);
            if(midval==target){
                return mid;
            }else if(midval>target){
                right=mid-1;
            }else
                left=mid+1;
        }
        left=top+1;
        right=mountainArr.length()-1;
        while(left<=right){
            int mid=(left+right)/2;
            int midval=mountainArr.get(mid);
            if(midval==target){
                return mid;
            }else if(midval<target){
                right=mid-1;
            }else
                left=mid+1;
        }
        return -1;
    }
}

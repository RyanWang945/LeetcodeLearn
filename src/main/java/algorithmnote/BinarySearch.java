package algorithmnote;

import org.junit.jupiter.api.Test;

/**
 * 二分查找，时间复杂度O(logn）
 * @author Ryan
 * @date 2020/1/3 13:22
 */
public class BinarySearch {
    int binarySearch(int[] A,int left,int right,int target){
        while(left<=right){
            int mid=(left+right)/2;
            if(A[mid]==target) return mid;
            else if(A[mid]>target){
                right=mid-1;
            }
            else if(A[mid]<target){
                left=mid+1;
            }
        }
        return -1;
    }
    int binarySearch2(int[] A,int left,int right,int target){
        while(left<=right){
            int mid=(right+left)/2;
            if(A[mid]==target) return mid;
            else if(A[mid]>target){
                right=mid-1;
            }else if(A[mid]<target){
                left=mid+1;
            }
        }
        return -1;
    }
}
class testbinary{
    @Test
    public void test_binarysearch(){
        int[] a={1,3,4,5,6,7,8,9,12,23,55,65,88,97};
        BinarySearch b=new BinarySearch();
        System.out.println(b.binarySearch2(a,0,a.length,55));
    }
}



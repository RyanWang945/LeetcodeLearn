package Sort;

import org.junit.Test;

/**
 * @author Ryan
 * @date 2020/2/27 8:31
 */
public class MyMerge {
    public void merge(int[] nums,int left1,int right1,int left2,int right2){
        int[] temp=new int[right1-left1+right2-left2+2];
        int p=0;
        int index1=left1,index2=left2;
        while(index1<=right1&&index2<=right2){
            if(nums[index1]<nums[index2]){
                temp[p++]=nums[index1++];
            }else
                temp[p++]=nums[index2++];
        }
        while(index1<=right1) temp[p++]=nums[index1++];
        while(index2<=right2) temp[p++]=nums[index2++];
        int index=0;
        while(index<p){
            nums[left1+index]=temp[index];
            index++;
        }
    }
    public void mergeSort(int[] nums,int left,int right){
        if(left<right){
            int mid=(left+right)/2;
            mergeSort(nums,left,mid);
            mergeSort(nums,mid+1,right);
            merge(nums,left,mid,mid+1,right);
        }
    }
    @Test
    public void test_mergeSort(){
        int[] test=new int[]{22,43,13,32,77,96,33,32,11,24,62};
        mergeSort(test,0,test.length-1);
        for(int i=0;i<test.length;i++){
            System.out.println(test[i]);
        }
    }
}

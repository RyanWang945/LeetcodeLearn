package algorithmnote;

import org.junit.jupiter.api.Test;

/**
 * @author Ryan
 * @date 2020/1/5 21:05
 */
public class _1_5MergeSort {
    public void mergeSort(int[] nums,int left,int right){
        if(left<right){
            int mid=(left+right)/2;
            mergeSort(nums,left,mid);
            mergeSort(nums,mid+1,right);
            merge(nums,left,mid,mid+1,right);
        }
    }
    public void merge(int[]nums,int left1,int right1,int left2,int right2){
        int i=left1,j=left2;
        int[] temp=new int[right1-left1+1+right2-left2+1];
        int p=0;
        while(i<=right1&&j<=right2){
            if(nums[i]<=nums[j]) temp[p++]=nums[i++];
            else temp[p++]=nums[j++];
        }
        while(i<=right1) temp[p++]=nums[i++];
        while(j<=right2) temp[p++]=nums[j++];
        for(int index=0;index<p;index++){
            nums[left1+index]=temp[index];
        }
    }

    @Test
    public void test_mergesort(){
        int[] test=new int[]{22,43,13,32,77,96,33,32,11,24,62};
        mergeSort(test,0,test.length-1);
        for(int i=0;i<test.length;i++){
            System.out.println(test[i]);
        }
    }
    public void fobo(int n){
        int a=1,b=1;
        System.out.println(f(n));
    }
    public int f(int n){
        if(n==1||n==2)
            return 1;
        else
            return f(n-1)+f(n-2);
    }
    @Test
    public void test_f(){
        fobo(4);
    }
}



























//    public void mergeSort(int[] nums,int left,int right){
//        if(left<right){
//            int mid=(left+right)/2;
//            mergeSort(nums,left,mid);
//            mergeSort(nums,mid+1,right);
//            merge(nums,left,mid,mid+1,right);
//        }
//    }
//    public void merge(int[] nums,int left1,int right1,int left2,int right2){
//        int[] temp=new int[right2-left1+1];
//        int p=0;
//        int i=left1,j=left2;
//        while(i<=right1&&j<=right2){
//            if(nums[i]<=nums[j]){
//                temp[p++]=nums[i++];
//            }
//            else temp[p++]=nums[j++];
//        }
//        while(i<=right1) temp[p++]=nums[i++];
//        while(j<=right2) temp[p++]=nums[j++];
//        for(int index=0;index<p;index++){
//            nums[left1+index]=temp[index];
//        }
//    }

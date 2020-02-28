package algorithmnote;

/**
 * 冒泡排序法，和插入排序一样，但是想起来比较好想
 * @author Ryan
 * @date 2019/12/30 11:45
 */
public class Bobblesort {
    public int[] BubbleSort(int[] nums){
        int n=nums.length;
        boolean flag=false;
        for(int i=n-1;i>0;i--){
            for(int j=0;j<i;j++){
                if(nums[j]>nums[j+1]){
                    int temp=nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=temp;
                    flag=true;
                }
            }
            if(flag==false)
                break;
            else
                flag=false;
        }
        return nums;
    }
    public static int[] bubbleSort(int[] nums){
        for(int i=nums.length;i>0;i--){
            int flag=0;
            for(int j=0;j<i-1;j++){
                if(nums[j]>nums[j+1]){
                    int temp=nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=temp;
                    flag=1;
                }
            }
            if(flag==0)
                break;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] array={23,11,22,56,78,97,3,6,7,55,45,9,32,28,85,13};
        int[] ints = bubbleSort(array);
        for(int i:ints){
            System.out.println(i);
        }
    }
}

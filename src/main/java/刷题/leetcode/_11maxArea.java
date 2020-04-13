package 刷题.leetcode;

/**
 * @author Ryan
 * @date 2020/3/7 21:15
 */
public class _11maxArea {
    /**
     * bf
     */
    public int maxArea(int[] height) {
        int temp=0;
        for(int i=0;i<height.length-1;i++){
            for(int j=i+1;j<height.length;j++){
                int h;
                if(height[i]>height[j]) h=height[j];
                else h=height[i];
                int sum=(j-i)*h;
                if(temp<sum){
                    temp=sum;
                }
            }
        }
        return temp;
    }
    /**
     * double pointer
     */
    public int maxArea2(int[] height) {
        int left=0;
        int right=height.length-1;
        int temp=0;
        while(left<right){
            int h;
            if(height[left]>height[right]) h=height[right];
            else h=height[left];
            int sum=h*(right-left);
            if(temp<sum){
                temp=sum;
            }
            if(height[left]>height[right]) right--;
            else left++;
        }
        return temp;
    }
}

package algorithmnote;

/**
 * @author Ryan
 * @date 2020/4/27 9:46
 */
public class BinarySearchDemo {
    /**
     * 寻找数组中某个确切的值
     *需要注意的点：
     * 1.left<=right，因为你是找一个确切的位置，所以不要省略掉left==right的情景，终止条件
     * 是left==right+1
     * 2.三个情况都要写全，不要省略
     * 3.因为寻找确切值属于左闭右闭区间问题，因此当nums[mid]不等于target时，必然进行+1或-1
     * 4.int mid=left+(right-left)/2的写法是为了避免加法运算越界
     */
    public int binarySearch(int[] nums,int target){
        int left=0,right=nums.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]==target)
                return mid;
            else if(nums[mid]<target){
                left=mid+1;
            }else if(nums[mid]>target){
                right=mid-1;
            }
        }
        return -1;
    }
    /**
     * 寻找数组中某个数的左边界，即[1,2,2,2,2,3]我们要找2的左边界的位置，也就是index=1
     * 1.因为寻找左边界相当于左闭右开问题，因此初始状态需要是0到num.length，同时结束状态应该是
     * left==right，即[left,left),这时区间为空，因此可以终止。while中就是left<right
     * 2.为什么可以搜索左边界，重点在于nums[mid]==target，当搜索到了一个等于target的数时，
     * 真正的左边界必然小于等于当前mid位置，因此更新为right=mid，同理，当nums[mid]>target时，
     * 真正的左边界也必然在mid的左边，所以right=mid
     * 而当nums[mid]<target时，就类似与例子中index=0的位置，必然left=mid+1
     * 3.终止条件是left==right，但如果target不存在于数组中，nums[left]应当仅仅是恰好比target大
     * 需要判断一下nums[left]是否等于target，不是就返回-1
     */
    public int binarySearch2(int[] nums,int target){
        int left=0,right=nums.length;
        while(left<right){
            int mid=left+(right-left)/2;
            if(nums[mid]==target)
                right=mid;
            else if(nums[mid]<target)
                left=mid+1;
            else if(nums[mid]>target)
                right=mid;
        }
        return nums[left]==target?left:-1;
    }

    /**
     * 搜索左侧边界的统一写法
     * 如何把right和搜索确切值统一起来，即right=nums.length-1;
     * 这时的终止条件应该是left==right+1，因为是左闭右闭区间，当left==right时可能没有搜索到target
     * 需要继续搜索，while(left<=right)
     */
    public int binarySearch3(int[] nums,int target){
        int left=0,right=nums.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]==target)
                right=mid-1;
            else if(nums[mid]<target)
                left=mid+1;
            else if(nums[mid]>target)
                right=mid-1;
        }
        if(left>=nums.length||nums[left]!=target)
            return -1;
        else return left;
    }
    /**
     * 搜索右侧边界
     */
    public int binarySearch4(int[]nums,int target){
        if(nums.length==0) return -1;
        int left=0,right=nums.length;
        while(left<right){
            int mid=left+(right-left)/2;
            if(nums[mid]==target)
                left=mid+1;
            else if(nums[mid]<target)
                left=mid+1;
            else if(nums[mid]>target)
                right=mid;
        }
        return left-1;
    }
    /**
     * 搜索右侧边界的统一写法
     */
    public int binarySearch5(int[]nums,int target){
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                // 这里改成收缩左侧边界即可
                left = mid + 1;
            }
        }
        // 这里改为检查 right 越界的情况，见下图
        if (right < 0 || nums[right] != target)
            return -1;
        return right;
    }




    int binary_search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if(nums[mid] == target) {
                // 直接返回
                return mid;
            }
        }
        // 直接返回
        return -1;
    }

    int left_bound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                // 别返回，收缩左侧边界
                right = mid - 1;
            }
        }
        // 最后要检查 left 越界的情况
        if (left >= nums.length || nums[left] != target)
            return -1;
        return left;
    }


    int right_bound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                // 别返回，收缩右侧边界
                left = mid + 1;
            }
        }
        // 最后要检查 right 越界的情况
        if (right < 0 || nums[right] != target)
            return -1;
        return right;
    }

}

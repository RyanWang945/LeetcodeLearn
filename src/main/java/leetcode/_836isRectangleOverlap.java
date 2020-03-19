package leetcode;

/**
 * @author Ryan
 * @date 2020/3/18 8:22
 */
public class _836isRectangleOverlap {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        if(rec2[0]>=rec1[2])
            return false;
        if(rec1[0]>=rec2[2])
            return false;
        if(rec1[1]>=rec2[3])
            return false;
        if(rec2[1]>=rec1[3])
            return false;
        return true;
    }
}

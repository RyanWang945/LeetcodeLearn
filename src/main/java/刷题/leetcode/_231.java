package 刷题.leetcode;

/**
 * @author Ryan
 * @date 2020/5/27 10:26
 */
public class _231 {
    public boolean isPowerOfTwo(int n) {
        return (n > 0) && ((n &(n - 1)) == 0);
    }
}

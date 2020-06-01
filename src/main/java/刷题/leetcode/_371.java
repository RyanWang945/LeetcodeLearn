package 刷题.leetcode;

/**
 * @author Ryan
 * @date 2020/5/27 10:15
 */
public class _371 {
    public int getSum(int a, int b) {
        if (a==0) return b;
        if (b==0) return a;
        int lower;
        int carrier;
        while (true) {
            lower = a^b;    // 计算低位
            carrier = a&b;  // 计算进位
            if (carrier==0) break;
            a = lower;
            b = carrier<<1;
        }
        return lower;
    }
}

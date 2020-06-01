package 刷题.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ryan
 * @date 2020/5/27 9:47
 */
public class _974 {
    public int subarraysDivByK(int[] A, int K) {
        int[] sum = new int[A.length+1]; sum[0] = 0;
        for(int i = 1; i < sum.length; i++)
            sum[i] = A[i-1] + sum[i-1];
        for(int i = 1; i < sum.length; i++)
            sum[i] %= K;
        int ans = 0;
        Map<Integer, Integer> m = new HashMap<>();
        for(int i = 0; i < sum.length; i++) {
            if(m.containsKey(sum[i]))
                ans += m.get(sum[i]);
            if(m.containsKey(sum[i]-K))
                ans += m.get(sum[i]-K);
            if(m.containsKey(sum[i]+K))
                ans += m.get(sum[i]+K);
            m.put(sum[i], m.getOrDefault(sum[i], 0)+1);
        }
        return ans;
    }

    /**
     * 我觉得这个版本的最好理解
     */
    public int subarraysDivByK2(int[] A, int K) {
        Map<Integer, Integer> record = new HashMap<>();
        record.put(0, 1);
        int sum = 0, ans = 0;
        for (int elem: A) {
            sum += elem;
            // 注意 Java 取模的特殊性，当被除数为负数时取模结果为负数，需要纠正
            int modulus = (sum % K + K) % K;
            int same = record.getOrDefault(modulus, 0);
            ans += same;
            record.put(modulus, same + 1);
        }
        return ans;
    }
}

package 刷题.leetcode;

import org.junit.jupiter.api.Test;

/**
 * @author Ryan
 * @date 2020/3/3 14:55
 */
public class _744nextGreatestLetter {
    public char nextGreatestLetter(char[] letters, char target) {
        for (char c: letters)
            if (c > target) return c;
        return letters[0];
    }
    public char nextGreatestLetter2(char[] letters, char target) {
        int lo = 0, hi = letters.length;
        while (lo < hi) {
            int mi = lo + (hi - lo) / 2;
            if (letters[mi] <= target) lo = mi + 1;
            else hi = mi;
        }
        return letters[lo % letters.length];
    }
    @Test
    public void test(){
        System.out.println('a'>'b');
    }
}

package leetcode;

import org.junit.jupiter.api.Test;

/**
 * @author Ryan
 * @date 2020/2/29 13:22
 */
public class _392isSubsequence {
    public boolean isSubsequence(String s, String t) {
        int index1 = 0;
        int index2 = 0;
        if (s.length() > t.length()) return false;
        while (index1 <= s.length() && index2 <= t.length()) {
            if (s.charAt(index1) == t.charAt(index2)) {
                index1++;
                index2++;
            } else
                index2++;
            if (index1 == s.length()) return true;
        }
        return false;
    }
    @Test
    public void test_Null(){
        System.out.println("".length());
    }
}

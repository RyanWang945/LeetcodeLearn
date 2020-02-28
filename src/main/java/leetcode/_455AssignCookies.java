package leetcode;

import java.util.Arrays;

/**
 * @author Ryan
 * @date 2020/2/28 11:10
 */
public class _455AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i=g.length;
        int j=s.length;
        int count=0;
        while(i>=0){
            while(j>=0){
                if(g[i]<=s[j]){
                    i--;
                    j--;
                    count++;
                }else{
                    j--;
                }
            }
        }
        return count;
    }
}

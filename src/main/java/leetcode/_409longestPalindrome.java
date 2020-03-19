package leetcode;

/**
 * @author Ryan
 * @date 2020/3/19 9:01
 * 122-65+1=58
 */
public class _409longestPalindrome {
    public int longestPalindrome(String s) {
        int[] hashtable=new int[58];
        for(int i=0;i<s.length();i++){
            hashtable[(char)s.charAt(i)-'A']++;
        }
        int count=0;
        for(int i=0;i<hashtable.length;i++){
            if(hashtable[i]%2==0)
                continue;
            else count++;
        }
        if(count>1)
            return s.length()-count+1;
        else return s.length();

    }
}

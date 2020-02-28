import java.util.HashSet;
import java.util.Set;

/**
 * @author Ryan
 * @date 2019/12/28 22:09
 *
 */
public class _3LongestString {
    public int lengthOfSubstring(String s){
        int i=0,j=0;
        int n=s.length();
        Set<Character> set=new HashSet<>();
        int ans=0;
        while(j<n&&i<n){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans=Math.max(ans,j-i);
            }else{
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }
}

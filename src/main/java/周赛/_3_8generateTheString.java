package 周赛;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Ryan
 * @date 2020/3/8 10:32
 */
public class _3_8generateTheString {
    Set<Character> set=new HashSet<>(Arrays.asList('a','b','c'));
    public String generateTheString(int n) {
        StringBuilder str=new StringBuilder();
        if(n%2==1){
            for(int i=0;i<n;i++){
                str.append('a');
            }
            return str.toString();
        }else{
            for(int i=0;i<n-1;i++){
                str.append('a');
                str.append('b');
            }
            return str.toString();
        }
    }
}

package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Ryan
 * @date 2020/2/26 15:10
 */
public class _524findLongestWord {
    public static void main(String[] args) {
        String s = "abpcplea";
        List<String> d = new LinkedList<>();
        d.add("ale");
        d.add("apple");
//        String longestWord = findLongestWord(s, d);
//        System.out.println(longestWord);
        for(String string:d){
            System.out.println(string);
        }
    }
    public static String findLongestWord(String s, List<String> d) {
        String longestword="";
        for(String target:d){
            int l1=longestword.length(),l2=target.length();
            if(l1>l2||(l1==l2&&longestword.compareTo(target)<0)){
                continue;
            }
            if(isValid(s,target)){
                longestword=target;
            }
        }
        return longestword;

    }
    private static boolean isValid(String s1,String s2){
        int i=0,j=0;
        while(i<s1.length()&&j<s2.length()){
            if(s1.charAt(i)==s2.charAt(j)){
                j++;
            }
            i++;
        }
        return j==s2.length();
    }
}

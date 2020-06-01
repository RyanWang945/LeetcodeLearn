package 刷题.leetcode;

import java.util.HashSet;

/**
 * @author Ryan
 * @date 2020/5/29 19:08
 */
public class _720 {
    public String longestWord(String[] words) {
        HashSet<String> set=new HashSet<>();
        for(String s:words){
            set.add(s);
        }String ans="";
        for(String s:words){
            boolean flag=true;
            for(int i=1;i<=s.length();i++){
                if(!set.contains(s.substring(0,i))){
                    flag=false;
                    break;
                }
            }
            if(flag){
                if(ans.length()<s.length())
                    ans=s;
                else if(ans.length()==s.length()){
                    ans=s.compareTo(ans)<0?s:ans;
                }
            }
        }
        return ans;
    }
}

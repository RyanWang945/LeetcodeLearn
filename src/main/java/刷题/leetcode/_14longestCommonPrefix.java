package 刷题.leetcode;

import org.junit.jupiter.api.Test;

/**
 * @author Ryan
 * @date 2020/3/19 17:27
 * StringBuilder的效率不如只用String的substring高啊
 */
public class _14longestCommonPrefix {
    @Test
    public void test(){
        String[] strs={"c","c"};
        System.out.println(longestCommonPrefix(strs));
        String a="-123";
        Long s=Long.parseLong(a);
        System.out.println(s);
    }
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0) return "";
        String res=strs[0];
        for(int i=1;i<strs.length;i++){
            StringBuilder sb=new StringBuilder();
            for(int j=0;j<res.length();j++){
                if(j<strs[i].length()&&res.charAt(j)==strs[i].charAt(j)){
                    sb.append(res.charAt(j));
                }else{
                    sb.append("");
                    break;
                }
            }
            res=sb.toString();
        }
        return res;
    }
    public String longestCommonPrefix2(String[] strs){
        if(strs.length==0)
            return "";
        String ans=strs[0];
        for(int i=1;i<strs.length;i++){
            int j=0;
            for(;j<ans.length()&&j<strs[i].length();j++){
                if(ans.charAt(j)!=strs[i].charAt(j))
                    break;
            }
            ans=ans.substring(0,j);
            if(ans.equals(""))
                return ans;
        }
        return ans;
    }
    public String longestCommonPrefix3(String[] strs) {
        if(strs.length==0) return "";
        String s=strs[0];
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            boolean flag=true;
            for(String str:strs){
                if(i>=str.length()){
                    flag=false;
                    break;
                }
                if(str.charAt(i)!=s.charAt(i)){
                    flag=false;
                    break;
                }
            }
            if(flag==true)
                sb.append(s.charAt(i));
            else break;
        }
        return sb.toString();
    }
}

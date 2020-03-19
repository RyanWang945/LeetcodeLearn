package leetcode;

import org.junit.jupiter.api.Test;

/**
 * @author Ryan
 * @date 2020/3/19 17:27
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
}

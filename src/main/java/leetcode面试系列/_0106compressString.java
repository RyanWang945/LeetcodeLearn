package leetcode面试系列;

import org.junit.jupiter.api.Test;

/**
 * @author Ryan
 * @date 2020/3/16 8:59
 */
public class _0106compressString {
    public String compressString(String S) {
        int len=S.length();
        StringBuilder sb=new StringBuilder();
        char temp=S.charAt(0);
        int count=1;
        for(int i=1;i<len;i++){
            if(S.charAt(i)==temp)
                count++;
            else if(S.charAt(i)!=temp){
                sb.append(String.valueOf(temp));
                sb.append(count);
                count=1;
                temp=S.charAt(i);
            }
        }
        if(len<=sb.toString().length())
            return S;
        else
            return sb.toString();
    }
    @Test
    public void test(){
        String a="aabcccccaaaeeeee";
        System.out.println(compressString(a));
        //System.out.println(String.valueOf(2).toString());
        char c='a';
        StringBuilder sb=new StringBuilder();
        sb.append(c);
        int num=1;
        sb.append(num);
        System.out.println(sb.toString());
    }
}

package 刷题.leetcode;

/**
 * @author Ryan
 * @date 2020/4/18 14:50
 */
public class _28 {
    int[] next;
    public int strStr(String haystack, String needle) {
        if(needle.length()==0) return 0;
        next=new int[needle.length()+1];
        build(needle);
        int n=haystack.length();
        int len=needle.length();
        for(int i=0,j=0;i<n;i++){
            while(j>0&&haystack.charAt(i)!=needle.charAt(j))
                j=next[j];
            if(haystack.charAt(i)==needle.charAt(j))
                j++;
            if(j==len){
                return i-len+1;
            }
        }
        return -1;
    }
    private void build(String needle){
        int len=needle.length();
        next=new int[len+1];
        next[0]=0;
        next[1]=0;
        int index=2;
        for(int i=1,j=0;i<len;i++){
            while(j>0&&needle.charAt(i)!=needle.charAt(j))
                j=next[j];
            if(needle.charAt(i)==needle.charAt(j))
                j++;
            next[index++]=j;
        }
    }
}

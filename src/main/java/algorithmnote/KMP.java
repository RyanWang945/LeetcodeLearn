package algorithmnote;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ryan
 * @date 2020/4/18 10:13
 */
public class KMP {
    /**
     * 28,459,1392这三道题都用到了kmp算法
     * definition of next[i]: length of the longest prefix of p[0:i] that is also the suffix;
     */
    private void build(String p){
        int len=p.length();
        next=new int[len+1];
        next[0]=0;
        next[1]=0;
        int index=2;
        for(int i=1,j=0;i<len;i++){
            while(j>0&&p.charAt(i)!=p.charAt(j))
                j=next[j];
            if(p.charAt(i)==p.charAt(j)) {
                j++;
            }
            next[index++]=j;
        }
    }

    /**
     * 匹配过程
     * when s[i]==p[j],i++,j++
     * when s[i]!=p[j],i remains the same and j=next[j] if(j==0) i++;else j=next[j];  j==0 means there is no partial match
     * we need to start from the beginning
     * when q=p,means we have a full match,now i++,j=next[j],treat if as a mismatch
     *
     */
    int[] next;
    private List<Integer> search(String s,String p){
        List<Integer> ans=new ArrayList<>();
        int n=s.length();
        int len=p.length();
        for(int i=0,j=0;i<n;i++){
            while(j>0&&s.charAt(i)!=p.charAt(j))
                j=next[j];
            if(s.charAt(i)==p.charAt(j))
                j++;
            if(j==len) {
                ans.add(i - len + 1);
                j=next[j];
            }
        }
        return ans;
    }
}

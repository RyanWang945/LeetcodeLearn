package 刷题.leetcode;

/**
 * @author Ryan
 * @date 2020/5/10 19:38
 */
public class _6 {
    public String convert(String s, int numRows) {
        if(s==null||s.length()==0) return "";
        StringBuilder[] sb=new StringBuilder[numRows];
        int n=numRows+numRows-2;
        int x=1;
        if(n==0) return s;
        for(int i=0;i<s.length();i++){
            if(sb[i%numRows]==null) sb[i]=new StringBuilder();
            if(i%n<numRows)
                sb[i%n].append(s.charAt(i));
            else {
                sb[numRows-x-1].append(s.charAt(i));
                x++;
                if(x==numRows-1)
                    x=1;
            }
        }
        StringBuilder ans=new StringBuilder();
        for(int i=0;i<sb.length&&sb[i]!=null;i++){
            ans.append(sb[i].toString());
        }
        return ans.toString();
    }
}

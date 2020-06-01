package 刷题.leetcode;

/**
 * @author Ryan
 * @date 2020/5/28 9:30
 */
public class _394 {
    StringBuilder sb;
    public String decodeString(String s) {
        if(s==null||s.length()==0) return "";
        sb=new StringBuilder();
        char[] chs=s.toCharArray();
        for(int i=0;i<chs.length;i++){
            if(chs[i]>='1'&&chs[i]<='9'){
                int[] time=matcher(chs,i);
                int end=helper(chs,time[1],sb,time[0]);
                i=end;
            }else
                sb.append(chs[i]);
        }
        return sb.toString();
    }
    private int helper(char[] chs,int index,StringBuilder sb,int time){
        StringBuilder temp=new StringBuilder();
        int i=0;
        for(i=index+2;i<chs.length&&chs[i]!=']';i++){
            if(chs[i]>='1'&&chs[i]<='9'){
                int[] times=matcher(chs,i);
                int end=helper(chs,times[1],temp,times[0]);
                i=end;
            }else{
                temp.append(chs[i]);
            }
        }
        for(int j=0;j<time;j++){
            sb.append(temp);
        }
        return i;
    }
    private int[] matcher(char[] chs,int index){
        StringBuilder sb=new StringBuilder();
        int i=0;
        for(i=index;i<chs.length&&chs[i]>='0'&&chs[i]<='9';i++){
            sb.append(chs[i]);
        }
        int time=Integer.valueOf(sb.toString());
        return new int[]{time,i-1};
    }
}

package 刷题.leetcode;

/**
 * @author Ryan
 * @date 2020/5/1 15:01
 */
public class _1208 {
    public int equalSubstring(String s, String t, int maxCost) {
        int[] costArray=new int[s.length()];
        for(int i=0;i<s.length();i++){
            costArray[i]=Math.abs(s.charAt(i)-t.charAt(i));
        }
        int ans=0;
        int left=0,right=0,cost=0,len=0;
        while(right<costArray.length){
            int a=costArray[right++];
            cost+=a;
            if(cost<=maxCost){
                len++;
                ans=Math.max(len,ans);
            }else len++;
            while(cost>maxCost){
                int b=costArray[left++];
                cost-=b;
                len--;
            }
        }
        return ans;
    }
}

package leetcode;

/**
 * @author Ryan
 * @date 2020/1/4 18:42
 * 这个算法不够优雅
 * 0123
 */
public class _9isPalindrome {
    public boolean isPalindrome(int x) {
        if(x<0)
            return false;
        else if(x==0)
            return true;
        else if(x%10==0)
            return false;
        Integer nums=new Integer(x);
        String s=nums.toString();
        int[] intarray=new int[s.length()];
        for(int i=0;i<s.length();i++){
            Character ch=s.charAt(i);
            intarray[i]=Integer.parseInt(ch.toString());
        }
        boolean flag=true;
        for(int i=0;i<=intarray.length/2;i++){
            if(intarray[i]==intarray[intarray.length-i]){

            }else
                flag=false;
        }
        if(flag==false)
            return false;
        else return true;
    }
    public boolean isPalindrome2(int x){
        if(x<0||(x%10==0&&x!=0)){
            return false;
        }
        Integer nums=new Integer(x);
        String s=nums.toString();
        char[] str=s.toCharArray();
        for(int i=0;i<str.length/2;i++){
            if(str[i]!=str[str.length-i-1])
                return false;
        }
        return true;
    }
}

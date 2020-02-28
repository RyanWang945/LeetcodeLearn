package leetcode;

/**
 * @author Ryan
 * @date 2020/2/25 14:35
 */
public class _680validPalindrome {
    public static void main(String[] args) {
        String str="asdfg";
        for(int i=0;i<str.length();i++){
            System.out.print(str.charAt(i));
        }
        System.out.println();
        boolean a = str.contains("a");
        System.out.println(a);
    }

    public boolean validPalindrome(String s){
        int i=0,j=s.length()-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return isPalindrome(s,i,j-1)||isPalindrome(s,i+1,j);
            }
            i++;
            j--;
        }
        return true;
    }
    private boolean isPalindrome(String s,int i,int j){
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
        }
        return true;
    }
}

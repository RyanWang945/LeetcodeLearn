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

    /**
     * 在这道题中，i++和j--同i+1和j-1有本质的区别，这提醒了我们，在循环外已经使用了
     * 自增自减操作的时候，就不能在循环内部再次使用自增自减操作了
     * @param s
     * @return
     */
    public boolean validPalindrome(String s){
        for(int i = 0, j = s.length()-1; i < j ; i++, j--){
            if(s.charAt(i) != s.charAt(j)){
                //分两种情况，一是右边减一，二是左边加一
                return isPalindrome(s,i,j-1) || isPalindrome(s, i+1, j);
            }
        }
        return true;
        //==========================

//        for(int i=0,j=s.length()-1;i<j;i++,j--){
//            if(s.charAt(i)!=s.charAt(j)){
//                return isPalindrome(s,i,j--)||isPalindrome(s,i++,j);
//            }
//        }
//        return true;
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

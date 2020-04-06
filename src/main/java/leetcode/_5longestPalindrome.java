package leetcode;

/**
 * @author Ryan
 * @date 2020/3/14 16:45
 */
public class _5longestPalindrome {
    /**
     * 暴力法显然超时了
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        int n=s.length();
        String temp="";
        if(s.length()==1) return s;
        for(int i=0;i<n-1;i++){
            for(int j=i;j<n;j++){
                if(isValid(s.substring(i,j+1))){
                    if(temp.length()<j-i+1)
                        temp=s.substring(i,j+1);
                }
            }
        }
        return temp;
    }
    public boolean isValid(String s){
        int n=s.length()-1;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!=s.charAt(n-i))
                return false;
        }
        return true;
    }

    /**
     * 动态规划
     * abcaiiiijijijijacba
     * abcajijijiiiiiiacba
     * ijijijacaijj
     * jjiacajijiji
     */
    public String longestPalindrome1(String s){
        if(s.equals(""))
            return "";
        String origin=s;
        String reverse=new StringBuilder(s).reverse().toString();
        int length=s.length();
        int[][] arr=new int[length][length];
        int maxLen=0;
        int maxEnd=0;
        for(int i=0;i<length;i++){
            for(int j=0;j<length;j++){
                if(origin.charAt(i)==reverse.charAt(j)){
                    if(i==0||j==0){
                        arr[i][j]=1;
                    }else{
                        arr[i][j]=arr[i-1][j-1]+1;
                    }
                }
                if(arr[i][j]>maxLen){
                    int beforeRev=length;
                }
            }
        }
        return "";
    }

    public static void main(String[] args) {
        int[][] matrix=new int[2][2];
        System.out.println(matrix[1][1]);
        String a="aa";
    }
    public String longestPalindrome2(String s) {
        if (s.equals(""))
            return "";
        String origin = s;
        String reverse = new StringBuffer(s).reverse().toString();
        int length = s.length();
        int[][] arr = new int[length][length];
        int maxLen = 0;
        int maxEnd = 0;
        for (int i = 0; i < length; i++)
            for (int j = 0; j < length; j++) {
                if (origin.charAt(i) == reverse.charAt(j)) {
                    if (i == 0 || j == 0) {
                        arr[i][j] = 1;
                    } else {
                        arr[i][j] = arr[i - 1][j - 1] + 1;
                    }
                }
                /**********修改的地方*******************/
                //当我们有当前的开始节点，要通过加上一个长度到达末尾节点，很显然需要-1
                if (arr[i][j] > maxLen) {
                    int beforeRev = length - 1 - j;
                    if (beforeRev + arr[i][j] - 1 == i) { //判断下标是否对应
                        maxLen = arr[i][j];
                        maxEnd = i;
                    }
                    /*************************************/
                }
            }
        return s.substring(maxEnd - maxLen + 1, maxEnd + 1);
    }
}

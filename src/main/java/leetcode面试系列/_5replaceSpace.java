package leetcode面试系列;

/**
 * @author Ryan
 * @date 2020/3/13 20:58
 */
public class _5replaceSpace {
    public static void main(String[] args) {
        String str="   ";
        System.out.println(str.length());
        String[] strs=str.split(" ");
        for (String i:strs){
            System.out.println(i);
        }
    }
    public String replaceSpace(String s) {
        StringBuilder sb=new StringBuilder();
        int temp=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==' '){
                sb.append(s.substring(temp,i));
                sb.append("%20");
                temp=i+1;
            }
        }
        return sb.toString();
    }
}

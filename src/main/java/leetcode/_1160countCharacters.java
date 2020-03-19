package leetcode;

/**
 * @author Ryan
 * @date 2020/3/17 9:04
 */
public class _1160countCharacters {
    public int countCharacters(String[] words, String chars) {
        int sum=0;

        for(String str:words){
            int[] hashtable=new int[chars.length()];
            int counter=0;
            for(int i=0;i<str.length();i++){
                for(int j=0;j<chars.length();j++){
                    if(str.charAt(i)==chars.charAt(j)&&hashtable[j]==0){
                        hashtable[j]=1;
                        counter++;
                        break;
                    }
                }
            }
            if(counter==str.length())
                sum+=str.length();
        }
        return sum;
    }
}

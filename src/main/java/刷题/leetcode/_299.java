package 刷题.leetcode;

/**
 * @author Ryan
 * @date 2020/4/21 16:15
 */
public class _299 {
    public String getHint(String secret, String guess) {
        int countA=0;
        int countB=0;
        int[] mapa=new int[10];
        int[] mapb=new int[10];
        for(int i=0;i<secret.length();i++){
            if(secret.charAt(i)==guess.charAt(i))
                countA++;
            else{
                int a=secret.charAt(i)-'0';
                int b=guess.charAt(i)-'0';
                for(int j=0;j<10;j++){
                    if(a==j){
                        mapa[j]++;
                    }
                    if(b==j){
                        mapb[j]++;
                    }
                }
            }
        }
        for(int i=0;i<10;i++){
            if(mapa[i]>mapb[i])
                countB+=mapb[i];
            else
                countB+=mapa[i];
        }
        StringBuilder sb=new StringBuilder();
        sb.append(countA);
        sb.append('A');
        sb.append(countB);
        sb.append('B');
        return sb.toString();
    }
}

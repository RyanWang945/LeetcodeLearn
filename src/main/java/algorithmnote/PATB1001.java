package algorithmnote;

/**
 * @author Ryan
 * @date 2019/12/29 9:54
 */
public class PATB1001 {
    public int callatz(int n){
        int ans=0;
        while(n!=1){
            if(n%2==0){
                n=n/2;
            }else{
                n=(3*n+1)/2;
            }
            ans++;
        }
        return ans;
    }
}

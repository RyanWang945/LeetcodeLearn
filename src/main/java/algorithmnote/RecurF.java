package algorithmnote;
import org.junit.jupiter.api.Test;

/**
 * @author Ryan
 * @date 2019/12/30 14:56
 */
public class RecurF {
    public int recurf(int n){
        return F(n);
    }
    private int F(int n){
        if(n==0) return 1;
        else return F(n-1)*n;
    }
    @Test
    public void test_f(){
        int a=3;
        RecurF r=new RecurF();
        System.out.println(r.recurf(a));
    }
}

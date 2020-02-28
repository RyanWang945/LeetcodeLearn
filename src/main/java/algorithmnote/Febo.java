package algorithmnote;

import org.junit.jupiter.api.Test;

/**
 * @author Ryan
 * @date 2019/12/30 15:13
 */
public class Febo {
    public int febo(int n){
        return f(n);
    }
    private int f(int n){
        if(n==1||n==0)
            return 1;
        else return f(n-1)+f(n-2);
    }
}
class test{
    @Test
    public void test(){
        Febo f=new Febo();
        System.out.println(f.febo(4));
    }
}

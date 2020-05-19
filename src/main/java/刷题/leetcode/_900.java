package 刷题.leetcode;

/**
 * @author Ryan
 * @date 2020/5/9 19:26
 */
public class _900 {
    private class RLEIterator {
        int[] A;
        int i,q;
        public RLEIterator(int[] A) {
            this.A=A;
            i=0;
            q=0;
        }

        public int next(int n) {
            while(i<A.length){
                if(q+n>A[i]){
                    n-=A[i]-q;
                    q=0;
                    i+=2;
                }else{
                    q+=n;
                    return A[i+1];
                }
            }
            return -1;
        }
    }
}


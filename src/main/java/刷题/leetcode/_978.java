package 刷题.leetcode;

/**
 * @author Ryan
 * @date 2020/6/17 9:36
 */
public class _978 {
    public int maxTurbulenceSize(int[] A) {
        if (A.length <= 1) {
            return A.length;
        }

        int N = A.length;
        int[] f = new int[N+1];
        int[] g = new int[N+1];
        f[1] = 1;
        g[1] = 1;

        int res = 1;
        for (int k = 2; k <= N; k++) {
            if (A[k-1] > A[k-2]) {
                f[k] = g[k-1] + 1;
            } else {
                f[k] = 1;
            }
            if (A[k-1] < A[k-2]) {
                g[k] = f[k-1] + 1;
            } else {
                g[k] = 1;
            }
            res = Math.max(res, f[k]);
            res = Math.max(res, g[k]);
        }
        return res;
    }

    /**
     *滑动窗口
     */
    public int maxTurbulenceSize2(int[] A) {
        int N=A.length;
        int ans=1;
        int anchor=0;
        for(int i=1;i<N;i++){
            int c=Integer.compare(A[i-1],A[i]);
            if(i==N-1||c*Integer.compare(A[i],A[i+1])!=-1){
                if(c!=0) ans=Math.max(ans,i-anchor+1);
                anchor=i;
            }
        }
        return ans;
    }
}

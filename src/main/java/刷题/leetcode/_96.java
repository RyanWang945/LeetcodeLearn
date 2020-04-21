package 刷题.leetcode;

/**
 * @author Ryan
 * @date 2020/4/13 10:57
 */
public class _96 {
    public int numTrees(int n) {
        int[] G=new int[n+1];
        G[0]=1;
        G[1]=1;
        for(int i=2;i<=n;i++){
            for(int j=1;j<=i;j++)
                G[i]+=G[j-1]*G[i-j];
        }
        return G[n];
    }

    /**
     * 首先要清楚dp的含义，n个节点（1到n）的不同的二叉排序树的数量，我们
     * 要将其分解为子问题，首先是0到n个节点分别有多少个二叉树，很显然0个节点只有1个，1个节点只有1个
     * 但是之后就需要计算了。
     * 然后如何求i个节点有多少个二叉排序树呢？我们可以用j遍历1到i，分别代表总结点数为i时，以j为根节点
     * 的二叉排序树是多少个，很显然是左边的j-1个节点不同的二叉排序树dp[j-1]乘以根右边i-j个节点不同的二叉排序树dp[i-j]
     * 的乘积，而遍历以1到i为节点，需要把他们都加起来，因此是dp[i]+=dp[j-1]*dp[i-j]
     */
    public int numTrees2(int n){
        int[] dp=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            for(int j=1;j<=i;j++){
                dp[i]+=dp[j-1]*dp[i-j];
            }
        }
        return dp[n];
    }
}

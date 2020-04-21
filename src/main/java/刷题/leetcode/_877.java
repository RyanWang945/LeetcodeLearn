package 刷题.leetcode;

/**
 * @author Ryan
 * @date 2020/4/5 21:16
 * dp[i][j].fir = max(piles[i] + dp[i+1][j].sec, piles[j] + dp[i][j-1].sec)
 * dp[i][j].fir = max(    选择最左边的石头堆     ,     选择最右边的石头堆     )
 * # 解释：我作为先手，面对 piles[i...j] 时，有两种选择：
 * # 要么我选择最左边的那一堆石头，然后面对 piles[i+1...j]
 * # 但是此时轮到对方，相当于我变成了后手；
 * # 要么我选择最右边的那一堆石头，然后面对 piles[i...j-1]
 * # 但是此时轮到对方，相当于我变成了后手。
 *
 * if 先手选择左边:
 *     dp[i][j].sec = dp[i+1][j].fir
 * if 先手选择右边:
 *     dp[i][j].sec = dp[i][j-1].fir
 * # 解释：我作为后手，要等先手先选择，有两种情况：
 * # 如果先手选择了最左边那堆，给我剩下了 piles[i+1...j]
 * # 此时轮到我，我变成了先手；
 * # 如果先手选择了最右边那堆，给我剩下了 piles[i...j-1]
 * # 此时轮到我，我变成了先手。
 */
public class _877 {
    /* 返回游戏最后先手和后手的得分之差 */
    int stoneGame(int[] piles) {
        int n = piles.length;
        // 初始化 dp 数组
        Pair[][] dp = new Pair[n][n];
        for (int i = 0; i < n; i++)
            for (int j = i; j < n; j++)
                dp[i][j] = new Pair(0, 0);
        // 填入 base case
        for (int i = 0; i < n; i++) {
            dp[i][i].fir = piles[i];
            dp[i][i].sec = 0;
        }
        // 斜着遍历数组
        for (int l = 2; l <= n; l++) {
            for (int i = 0; i <= n - l; i++) {
                int j = l + i - 1;
                // 先手选择最左边或最右边的分数
                int left = piles[i] + dp[i+1][j].sec;
                int right = piles[j] + dp[i][j-1].sec;
                // 套用状态转移方程
                if (left > right) {
                    dp[i][j].fir = left;
                    dp[i][j].sec = dp[i+1][j].fir;
                } else {
                    dp[i][j].fir = right;
                    dp[i][j].sec = dp[i][j-1].fir;
                }
            }
        }
        Pair res = dp[0][n-1];
        return res.fir - res.sec;
    }
    private class Pair {
        int fir, sec;
        Pair(int fir, int sec) {
            this.fir = fir;
            this.sec = sec;
        }
    }
}


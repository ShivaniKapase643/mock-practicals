
class KnapsackDynamicPragramingA4 {
    public static void main(String[] args) {
        int[] wt = {5, 10, 15, 22, 25};
        int[] val = {30, 40, 45, 77, 90};
        int W = 10, n = wt.length;

        int[][] dp = new int[n + 1][W + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= W; j++) {
                if (wt[i - 1] <= j)
                    dp[i][j] = Math.max(val[i - 1] +
                        dp[i - 1][j - wt[i - 1]],
                        dp[i - 1][j]);
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }

        System.out.println("Maximum value = " + dp[n][W]);
    }
}

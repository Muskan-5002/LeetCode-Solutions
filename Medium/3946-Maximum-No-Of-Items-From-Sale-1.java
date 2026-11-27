import java.util.*;
class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;

        int[] val = new int[n];

        for (int i = 0; i < n; i++) {
            val[i] = 1;

            for (int j = 0; j < n; j++) {
                if (i != j && items[j][0] % items[i][0] == 0) {
                    val[i]++;
                }
            }
        }

        int INF = -1000000000;
        int[] dp = new int[budget + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        int ans = 0;

        for (int p = 1500; p >= 1; p--) {

            int[] have = new int[budget + 1];
            Arrays.fill(have, INF);

            for (int i = 0; i < n; i++) {
                if (items[i][1] != p) continue;

                for (int b = budget; b >= p; b--) {
                    if (dp[b - p] != INF) {
                        have[b] = Math.max(have[b],
                                           dp[b - p] + val[i]);
                    }

                    if (have[b - p] != INF) {
                        have[b] = Math.max(have[b],
                                           have[b - p] + val[i]);
                    }
                }
            }

            for (int b = 0; b <= budget; b++) {
                if (have[b] != INF) {
                    ans = Math.max(ans,
                        have[b] + (budget - b) / p);
                }
            }

            for (int i = 0; i < n; i++) {
                if (items[i][1] != p) continue;

                for (int b = budget; b >= p; b--) {
                    if (dp[b - p] != INF) {
                        dp[b] = Math.max(dp[b],
                                         dp[b - p] + val[i]);
                    }
                }
            }
        }

        return ans;
    }
}

class Solution {
    public int strangePrinter(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        // Step 1: Remove consecutive duplicate characters to optimize
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (i == 0 || s.charAt(i) != s.charAt(i - 1)) {
                sb.append(s.charAt(i));
            }
        }
        s = sb.toString();
        int n = s.length();

        // Step 2: Initialize DP table
        // dp[i][j] stores the min turns for substring s[i...j]
        int[][] dp = new int[n][n];

        // Step 3: Fill DP table
        // We iterate backwards from the last character to the first
        for (int i = n - 1; i >= 0; i--) {
            // Base case: Single character always takes 1 turn
            dp[i][i] = 1; 

            for (int j = i + 1; j < n; j++) {
                // Initial assumption: Print s[i] alone, then solve the rest
                dp[i][j] = dp[i + 1][j] + 1;

                // Attempt to improve the result by finding matching characters
                for (int k = i + 1; k <= j; k++) {
                    if (s.charAt(k) == s.charAt(i)) {
                        // If s[k] matches s[i], we can merge their printing strokes.
                        // We split the problem into [i...k-1] and [k+1...j].
                        // Note: We don't add +1 here because the stroke for s[i] 
                        // is essentially absorbed into the solution for s[i...k-1].
                        int subProblemCost = dp[i][k - 1] + (k + 1 <= j ? dp[k + 1][j] : 0);
                        dp[i][j] = Math.min(dp[i][j], subProblemCost);
                    }
                }
            }
        }

        return dp[0][n - 1];
    }
}
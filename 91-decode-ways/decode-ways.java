class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }

        int n = s.length();
        int[] dp = new int[n + 1];
        
        // Base cases
        dp[0] = 1; // An empty string has 1 way to be decoded (doing nothing)
        dp[1] = 1; // We already checked that s[0] != '0'

        for (int i = 2; i <= n; i++) {
            // Check single digit (s[i-1])
            int singleDigit = s.charAt(i - 1) - '0';
            if (singleDigit >= 1 && singleDigit <= 9) {
                dp[i] += dp[i - 1];
            }

            // Check two digits (s[i-2] and s[i-1])
            int twoDigits = Integer.parseInt(s.substring(i - 2, i));
            if (twoDigits >= 10 && twoDigits <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[n];
    }
}
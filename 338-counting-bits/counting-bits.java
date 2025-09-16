class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        // ans[0] = 0 by default
        for (int i = 1; i <= n; i++) {
            ans[i] = ans[i >> 1] + (i & 1);
        }
        return ans;
    }
}

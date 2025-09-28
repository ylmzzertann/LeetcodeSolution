class Solution {
    public int climbStairs(int n) {
        // f(0)=1, f(1)=1, f(n)=f(n-1)+f(n-2)
        int a = 1, b = 1;
        for (int i = 2; i <= n; i++) {
            int c = a + b;
            a = b;
            b = c;
        }
        return b;
    }
}

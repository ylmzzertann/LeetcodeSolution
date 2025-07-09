class Solution {
    public int countLargestGroup(int n) {
        // Max digit-sum for n ≤ 10^4 is 36 (for 9999), so array size 37 is enough
        int[] counts = new int[37];
        
        // 1) Group numbers by digit-sum
        for (int i = 1; i <= n; i++) {
            counts[digitSum(i)]++;
        }
        
        // 2) Find the maximum group size
        int maxSize = 0;
        for (int c : counts) {
            if (c > maxSize) {
                maxSize = c;
            }
        }
        
        // 3) Count how many groups reach that size
        int result = 0;
        for (int c : counts) {
            if (c == maxSize) {
                result++;
            }
        }
        
        return result;
    }
    
    // Helper: compute sum of digits of x
    private int digitSum(int x) {
        int s = 0;
        while (x > 0) {
            s += x % 10;
            x /= 10;
        }
        return s;
    }
}

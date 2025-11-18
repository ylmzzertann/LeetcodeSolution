class Solution {
    public int countDigitOne(int n) {
        int count = 0;
        
        // We use 'long' for 'i' to prevent overflow when i * 10 > Integer.MAX_VALUE
        for (long i = 1; i <= n; i *= 10) {
            long divider = i * 10;
            
            // Split the number into parts
            // Example n = 314, i = 10 (looking at tens place)
            // high = 3, cur = 1, low = 4
            long high = n / divider;
            long cur = (n / i) % 10;
            long low = n % i;
            
            if (cur == 0) {
                // If current digit is 0, 1s depend only on higher digits
                count += high * i;
            } else if (cur == 1) {
                // If current digit is 1, we get full sets from high, plus part of the current block
                count += high * i + (low + 1);
            } else {
                // If current digit > 1, we get one extra full set
                count += (high + 1) * i;
            }
        }
        
        return count;
    }
}
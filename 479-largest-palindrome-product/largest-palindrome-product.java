class Solution {
    public int largestPalindrome(int n) {
        if (n == 1) return 9;  // Special case

        long upper = (long) Math.pow(10, n) - 1;
        long lower = (long) Math.pow(10, n - 1);

        for (long left = upper; left >= lower; left--) {
            // Create palindrome by mirroring "left"
            long pal = createPalindrome(left);

            // Try to factor palindrome
            for (long a = upper; a * a >= pal; a--) {
                if (pal % a == 0) {
                    return (int) (pal % 1337);
                }
            }
        }
        return -1;
    }

    private long createPalindrome(long left) {
        String s = Long.toString(left);
        String rev = new StringBuilder(s).reverse().toString();
        return Long.parseLong(s + rev);
    }
}

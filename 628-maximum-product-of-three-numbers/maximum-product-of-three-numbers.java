class Solution {
    public int maximumProduct(int[] nums) {
        // En büyük 3 sayı
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        // En küçük 2 sayı
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;

        for (int n : nums) {
            // En büyükleri güncelle
            if (n > max1) {
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (n > max2) {
                max3 = max2;
                max2 = n;
            } else if (n > max3) {
                max3 = n;
            }

            // En küçükleri güncelle
            if (n < min1) {
                min2 = min1;
                min1 = n;
            } else if (n < min2) {
                min2 = n;
            }
        }

        // En büyük üç sayının çarpımı ya da
        // En küçük iki sayı ve en büyük sayının çarpımı
        return Math.max(max1 * max2 * max3, max1 * min1 * min2);
    }
}

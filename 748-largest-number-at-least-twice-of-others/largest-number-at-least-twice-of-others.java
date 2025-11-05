class Solution {
    public int dominantIndex(int[] nums) {
        // En büyük ve ikinci en büyük sayıları tut
        int max = -1;
        int secondMax = -1;
        int maxIndex = -1;
        
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            if (x > max) {
                // Yeni max bulundu, eski max ikinci en büyük olur
                secondMax = max;
                max = x;
                maxIndex = i;
            } else if (x > secondMax) {
                // Max değil ama secondMax'ten büyükse güncelle
                secondMax = x;
            }
        }
        
        // En büyük sayı, ikinci en büyük sayının en az 2 katı olmalı
        if (max >= 2 * secondMax) {
            return maxIndex;
        } else {
            return -1;
        }
    }
}

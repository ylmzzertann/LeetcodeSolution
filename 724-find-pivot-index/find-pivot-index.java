class Solution {
    public int pivotIndex(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            int rightSum = totalSum - leftSum - nums[i];
            if (leftSum == rightSum) {
                return i; // Pivot index bulundu
            }
            leftSum += nums[i]; // Sıradaki sayıyı leftSum'a ekle
        }

        return -1; // Pivot index bulunamadı
    }
}

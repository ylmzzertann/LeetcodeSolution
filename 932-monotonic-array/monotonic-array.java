class Solution {
    public boolean isMonotonic(int[] nums) {
        boolean nonDecreasing = true;
        boolean nonIncreasing = true;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) nonIncreasing = false;
            if (nums[i] < nums[i - 1]) nonDecreasing = false;
            if (!nonDecreasing && !nonIncreasing) return false;
        }
        return true;
    }
}

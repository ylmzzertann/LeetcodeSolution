class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int best = 1, curr = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                curr++;
            } else {
                best = Math.max(best, curr);
                curr = 1;
            }
        }
        return Math.max(best, curr);
    }
}

class Solution {
    public int smallestRangeI(int[] nums, int k) {
        int mn = nums[0], mx = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int v = nums[i];
            if (v < mn) mn = v;
            else if (v > mx) mx = v;
        }
        int diff = mx - mn - (k << 1); // 2*k
        return diff > 0 ? diff : 0;
    }
}

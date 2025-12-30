class Solution {
    public int minPatches(int[] nums, int n) {
        long miss = 1; // Use long to prevent integer overflow
        int patches = 0;
        int i = 0;

        while (miss <= n) {
            // If the current array number can cover 'miss'
            if (i < nums.length && nums[i] <= miss) {
                miss += nums[i];
                i++;
            } 
            // If there is a gap, patch the array with 'miss'
            else {
                miss += miss;
                patches++;
            }
        }

        return patches;
    }
}
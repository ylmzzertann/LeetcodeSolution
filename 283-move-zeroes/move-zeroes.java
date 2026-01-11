class Solution {
    public void moveZeroes(int[] nums) {
        // Variable to track the position where the next non-zero element goes
        int insertPos = 0;

        // Pass 1: Move all non-zero elements to the front
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[insertPos] = nums[i];
                insertPos++;
            }
        }

        // Pass 2: Fill the remaining positions with zeros
        while (insertPos < nums.length) {
            nums[insertPos] = 0;
            insertPos++;
        }
    }
}
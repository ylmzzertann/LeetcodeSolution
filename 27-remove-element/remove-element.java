class Solution {
    public int removeElement(int[] nums, int val) {
        // k will keep track of the index where we place the next non-val element
        int k = 0;
        
        for (int i = 0; i < nums.length; i++) {
            // If the current element is NOT the value we want to remove
            if (nums[i] != val) {
                // Move it to the 'k' position and increment k
                nums[k] = nums[i];
                k++;
            }
        }
        
        // k is the total count of elements not equal to val
        return k;
    }
}
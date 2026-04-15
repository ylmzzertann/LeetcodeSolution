import java.util.HashMap;
import java.util.Map;

class Solution {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();
        
        // Step 1: Build the frequency map
        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }
        
        int longest = 0;
        
        // Step 2: Iterate through the map to find x and x + 1
        for (int key : counts.keySet()) {
            if (counts.containsKey(key + 1)) {
                // The harmonious subsequence consists of all instances of 'key' and 'key + 1'
                int currentLength = counts.get(key) + counts.get(key + 1);
                longest = Math.max(longest, currentLength);
            }
        }
        
        return longest;
    }
}
import java.util.*;

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        // 1. Sort to ensure duplicates are adjacent
        Arrays.sort(nums);
        backtrack(results, new ArrayList<>(), nums, new boolean[nums.length]);
        return results;
    }

    private void backtrack(List<List<Integer>> results, List<Integer> current, int[] nums, boolean[] used) {
        // Base case: if the current list is the size of the input, we found a permutation
        if (current.size() == nums.length) {
            results.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // Skip if the element is already used in this path
            if (used[i]) continue;

            // 2. Skip duplicates: 
            // If the current number is the same as the previous one AND
            // the previous one was NOT used, it means we already processed 
            // this specific value in a previous iteration of this loop level.
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;

            used[i] = true;
            current.add(nums[i]);
            
            backtrack(results, current, nums, used);
            
            // 3. Backtrack: remove last element and mark as unused
            used[i] = false;
            current.remove(current.size() - 1);
        }
    }
}
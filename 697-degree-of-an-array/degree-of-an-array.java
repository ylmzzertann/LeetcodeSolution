import java.util.*;

class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> first = new HashMap<>();
        Map<Integer, Integer> last  = new HashMap<>();
        Map<Integer, Integer> freq  = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            first.putIfAbsent(x, i);
            last.put(x, i);
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }

        int degree = 0;
        for (int c : freq.values()) degree = Math.max(degree, c);

        int ans = nums.length;
        for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
            if (e.getValue() == degree) {
                int x = e.getKey();
                ans = Math.min(ans, last.get(x) - first.get(x) + 1);
            }
        }
        return ans;
    }
}

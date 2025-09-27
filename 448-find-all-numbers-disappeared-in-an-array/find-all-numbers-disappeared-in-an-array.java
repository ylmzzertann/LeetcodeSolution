import java.util.*;

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;

        // Görülenleri işaretle
        for (int i = 0; i < n; i++) {
            int idx = Math.abs(nums[i]) - 1;   // 0-based index
            if (nums[idx] > 0) nums[idx] = -nums[idx];
        }

        // Pozitif kalan indeksler kayıp sayılardır
        List<Integer> missing = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) missing.add(i + 1);
        }
        return missing;
    }
}

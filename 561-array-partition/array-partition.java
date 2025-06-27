import java.util.Arrays;

class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums); // 1. Adım: Sıralama
        int sum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i]; // 2. Adım: Her çiftin küçük elemanını topla
        }
        return sum;
    }
}

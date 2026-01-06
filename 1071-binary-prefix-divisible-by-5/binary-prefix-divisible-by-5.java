import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> result = new ArrayList<>();
        int currentRemainder = 0;
        
        for (int bit : nums) {
            // Shift left (multiply by 2), add the new bit, and take modulo 5
            // This prevents the number from overflowing integer limits
            currentRemainder = (currentRemainder * 2 + bit) % 5;
            
            // If remainder is 0, it is divisible by 5
            if (currentRemainder == 0) {
                result.add(true);
            } else {
                result.add(false);
            }
        }
        
        return result;
    }
}
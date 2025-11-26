import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> result = new ArrayList<>();
        int i = num.length - 1;

        // Loop while there are digits in num OR there is still value left in k
        while (i >= 0 || k > 0) {
            
            // If we are still inside the array bounds, add the digit to k
            if (i >= 0) {
                k += num[i];
                i--;
            }

            // k % 10 gets the last digit of the current sum
            result.add(k % 10);
            
            // k / 10 carries the remaining value over to the next iteration
            k /= 10;
        }

        // Because we added digits from right to left, the list is backwards
        Collections.reverse(result);
        
        return result;
    }
}
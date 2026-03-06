import java.util.Arrays;

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        // Step 1: Sort both arrays to use the greedy approach
        Arrays.sort(g);
        Arrays.sort(s);
        
        int childIndex = 0;
        int cookieIndex = 0;
        
        // Step 2: Iterate through cookies as long as there are children left
        while (childIndex < g.length && cookieIndex < s.length) {
            // If the cookie is large enough for the child's greed
            if (s[cookieIndex] >= g[childIndex]) {
                // Child is satisfied, move to the next child
                childIndex++;
            }
            // Move to the next cookie regardless (if it didn't satisfy 
            // the current child, it won't satisfy any greedier child)
            cookieIndex++;
        }
        
        // The childIndex represents the total number of content children
        return childIndex;
    }
}
class Solution {
    public boolean isAnagram(String s, String t) {
        // Fast fail: Anagrams must be the same length
        if (s.length() != t.length()) {
            return false;
        }

        // Frequency counter for 26 lowercase English letters
        int[] count = new int[26];

        // Iterate over both strings simultaneously
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++; // Increment for s
            count[t.charAt(i) - 'a']--; // Decrement for t
        }

        // Check if all counts are zero
        for (int c : count) {
            if (c != 0) {
                return false;
            }
        }

        return true;
    }
}
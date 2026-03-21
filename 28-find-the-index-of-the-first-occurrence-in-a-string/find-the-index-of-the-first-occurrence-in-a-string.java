class Solution {
    public int strStr(String haystack, String needle) {
        int hLen = haystack.length();
        int nLen = needle.length();

        // If needle is longer than haystack, it's impossible to find a match
        if (nLen > hLen) {
            return -1;
        }

        // We only need to iterate up to (hLen - nLen) 
        // because anything further wouldn't have enough characters to match needle
        for (int i = 0; i <= hLen - nLen; i++) {
            // Check if the substring of haystack starting at i matches needle
            if (haystack.substring(i, i + nLen).equals(needle)) {
                return i;
            }
        }

        return -1;
    }
}
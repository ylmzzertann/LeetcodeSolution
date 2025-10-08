class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s == t) return true;
        if (s == null || t == null) return false;
        if (s.length() != t.length()) return false;

        // Use 256 for extended ASCII. For full Unicode, use HashMap-based method above.
        int[] lastS = new int[256];
        int[] lastT = new int[256];

        // Initialize to 0. We'll store (index + 1) as marker to differentiate from default zero.
        for (int i = 0; i < s.length(); i++) {
            int cs = s.charAt(i);
            int ct = t.charAt(i);

            if (lastS[cs] != lastT[ct]) return false;

            // store i+1 as last seen position
            lastS[cs] = i + 1;
            lastT[ct] = i + 1;
        }
        return true;
    }
}

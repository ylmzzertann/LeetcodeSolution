class Solution {
    public String sortString(String s) {
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) cnt[c - 'a']++;

        StringBuilder sb = new StringBuilder(s.length());
        int remaining = s.length();

        while (remaining > 0) {
            // step 1–3: smallest to largest
            for (int i = 0; i < 26; i++) {
                if (cnt[i] > 0) {
                    sb.append((char) ('a' + i));
                    cnt[i]--;
                    remaining--;
                }
            }
            // step 4–6: largest to smallest
            for (int i = 25; i >= 0 && remaining > 0; i--) {
                if (cnt[i] > 0) {
                    sb.append((char) ('a' + i));
                    cnt[i]--;
                    remaining--;
                }
            }
        }
        return sb.toString();
    }
}

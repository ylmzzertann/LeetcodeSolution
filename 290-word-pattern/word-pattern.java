import java.util.*;

class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (words.length != pattern.length()) return false;

        Map<Character, String> p2w = new HashMap<>();
        Map<String, Character> w2p = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char p = pattern.charAt(i);
            String w = words[i];

            // If we've seen the pattern char, it must map to the same word
            if (p2w.containsKey(p)) {
                if (!p2w.get(p).equals(w)) return false;
            } else {
                p2w.put(p, w);
            }

            // If we've seen the word, it must map to the same pattern char
            if (w2p.containsKey(w)) {
                if (w2p.get(w) != p) return false;
            } else {
                w2p.put(w, p);
            }
        }
        return true;
    }
}

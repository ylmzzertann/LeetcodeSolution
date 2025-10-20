import java.util.*;

class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedSet = new HashSet<>(Arrays.asList(banned));
        Map<String, Integer> count = new HashMap<>();
        
        int n = paragraph.length();
        StringBuilder word = new StringBuilder();
        String result = "";
        int maxFreq = 0;

        for (int i = 0; i <= n; i++) {
            char c = (i < n) ? paragraph.charAt(i) : ' '; // sondaki kelimeyi de işlemek için
            
            if (Character.isLetter(c)) {
                word.append(Character.toLowerCase(c));
            } else if (word.length() > 0) {
                String w = word.toString();
                if (!bannedSet.contains(w)) {
                    int freq = count.getOrDefault(w, 0) + 1;
                    count.put(w, freq);
                    if (freq > maxFreq) {
                        maxFreq = freq;
                        result = w;
                    }
                }
                word.setLength(0); // yeniden kullanmak için sıfırla
            }
        }

        return result;
    }
}

import java.util.*;

class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        // Banned kelimeleri hızlı arama için HashSet'e ekliyoruz
        Set<String> bannedSet = new HashSet<>(Arrays.asList(banned));
        
        // Noktalama işaretlerini boşlukla değiştiriyoruz ve küçük harfe çeviriyoruz
        String normalized = paragraph.replaceAll("[^a-zA-Z]", " ").toLowerCase();
        
        // Kelimeleri ayırıyoruz
        String[] words = normalized.split("\\s+");
        
        // Kelime sayımını tutacak HashMap
        Map<String, Integer> count = new HashMap<>();
        
        for (String word : words) {
            if (!bannedSet.contains(word) && !word.isEmpty()) {
                count.put(word, count.getOrDefault(word, 0) + 1);
            }
        }
        
        // En sık geçen kelimeyi bul
        String result = "";
        int max = 0;
        for (String word : count.keySet()) {
            if (count.get(word) > max) {
                max = count.get(word);
                result = word;
            }
        }
        
        return result;
    }
}

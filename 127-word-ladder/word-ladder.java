import java.util.*;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) return 0;

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        
        int level = 1;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            // Mevcut seviyedeki tüm kelimeleri işle
            for (int i = 0; i < size; i++) {
                String currentWord = queue.poll();
                char[] wordChars = currentWord.toCharArray();
                
                // Her bir karakteri tek tek değiştirip dene
                for (int j = 0; j < wordChars.length; j++) {
                    char originalChar = wordChars[j];
                    
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == originalChar) continue;
                        wordChars[j] = c;
                        String newWord = String.valueOf(wordChars);
                        
                        if (newWord.equals(endWord)) return level + 1;
                        
                        if (dict.contains(newWord)) {
                            queue.add(newWord);
                            dict.remove(newWord); // Ziyaret edildi olarak işaretle
                        }
                    }
                    wordChars[j] = originalChar; // Karakteri eski haline getir
                }
            }
            level++;
        }
        
        return 0;
    }
}
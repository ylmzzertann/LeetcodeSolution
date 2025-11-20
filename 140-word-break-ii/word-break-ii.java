import java.util.*;

class Solution {
    // Sonuçları saklamak için Memoization haritası (Index -> Olası Cümleler Listesi)
    private Map<Integer, List<String>> memo = new HashMap<>();
    private Set<String> wordSet;
    private String s;

    public List<String> wordBreak(String s, List<String> wordDict) {
        this.s = s;
        this.wordSet = new HashSet<>(wordDict); // O(1) erişim için Set'e çeviriyoruz
        return backtrack(0);
    }

    private List<String> backtrack(int start) {
        // Eğer bu index için daha önce hesaplama yaptıysak, hafızadan getir.
        if (memo.containsKey(start)) {
            return memo.get(start);
        }

        List<String> results = new ArrayList<>();

        // Base Case: String'in sonuna ulaştık
        if (start == s.length()) {
            results.add(""); // Boş string ekleyerek geçerli bir yol olduğunu belirtiyoruz
            return results;
        }

        // String'i start indexinden itibaren parçalamaya başla
        for (int end = start + 1; end <= s.length(); end++) {
            // substring maliyetli olabilir ama N=20 olduğu için ihmal edilebilir.
            // Daha "hardcore" optimizasyon için Trie kullanılabilir ama burada overkill olur.
            String word = s.substring(start, end);

            if (wordSet.contains(word)) {
                // Kelime sözlükte varsa, kalan kısım için recursive çağrı yap
                List<String> subSentences = backtrack(end);

                // Dönen sonuçları şu anki kelime ile birleştir
                for (String sub : subSentences) {
                    // Eğer sub boşsa (cümlenin sonu), sadece kelimeyi ekle, yoksa boşlukla birleştir.
                    // "cats" + "" -> "cats"
                    // "cats" + "and dog" -> "cats and dog"
                    results.add(word + (sub.isEmpty() ? "" : " " + sub));
                }
            }
        }

        // Sonucu hafızaya kaydet ve döndür
        memo.put(start, results);
        return results;
    }
}
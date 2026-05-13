import java.util.*;

class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        // Bir IP adresi en az 4, en fazla 12 karakter olabilir.
        if (s.length() < 4 || s.length() > 12) return result;
        
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(String s, int start, List<String> current, List<String> result) {
        // 4 parçayı da bulduysak ve string'in sonuna ulaştıysak geçerli bir IP'dir.
        if (current.size() == 4) {
            if (start == s.length()) {
                result.add(String.join(".", current));
            }
            return;
        }

        // Her parça 1, 2 veya 3 basamaklı olabilir.
        for (int len = 1; len <= 3; len++) {
            // String sınırlarını aşmamalıyız.
            if (start + len > s.length()) break;

            String segment = s.substring(start, start + len);

            // Geçerlilik kontrolleri:
            // 1. Öncü sıfır kontrolü: "0" geçerli ama "01", "001" geçersiz.
            if (segment.startsWith("0") && segment.length() > 1) continue;
            
            // 2. Sayısal değer kontrolü: 0-255 aralığında olmalı.
            int val = Integer.parseInt(segment);
            if (val > 255) continue;

            // Karar ver (Ekle)
            current.add(segment);
            
            // Bir sonraki parça için derinleş
            backtrack(s, start + len, current, result);
            
            // Geri izle (Çıkar)
            current.remove(current.size() - 1);
        }
    }
}
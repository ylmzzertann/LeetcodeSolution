class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0 || t.length() > s.length()) {
            return "";
        }

        // t'deki karakterlerin ihtiyaç frekansı
        int[] need = new int[128]; // ASCII yeterli
        for (char c : t.toCharArray()) {
            need[c]++;
        }

        int left = 0;
        int minStart = 0;
        int minLen = Integer.MAX_VALUE;

        // Eksik olan toplam karakter sayısı (t'nin uzunluğu kadar başlıyoruz)
        int missing = t.length();

        // right ile pencereyi genişletiyoruz
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            // Bu karakter t içinde gerekiyorsa, missing azalt
            if (need[c] > 0) {
                missing--;
            }

            // Bu karakterden bir tane kullandık
            need[c]--;

            // Artık tüm karakterler pencere içinde olduğunda
            while (missing == 0) {
                // Şu anki pencerenin uzunluğunu kontrol et
                int windowLen = right - left + 1;
                if (windowLen < minLen) {
                    minLen = windowLen;
                    minStart = left;
                }

                // Soldan daraltmayı deneyelim
                char leftChar = s.charAt(left);
                need[leftChar]++; // bu karakteri pencereden çıkarıyoruz

                // Eğer need[leftChar] > 0 olduysa, demek ki artık bu karakterden biri eksik
                if (need[leftChar] > 0) {
                    missing++;
                }

                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}

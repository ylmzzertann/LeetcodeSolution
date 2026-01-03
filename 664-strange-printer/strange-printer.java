class Solution {
    public int strangePrinter(String s) {
        if (s.isEmpty()) return 0;

        // 1. ADIM: Tekrarlayan karakterleri temizle (Örn: "aaabb" -> "ab")
        // Bu işlem algoritmayı çok ciddi hızlandırır.
        char[] chars = s.toCharArray();
        int n = 0;
        for (int i = 0; i < chars.length; i++) {
            if (n == 0 || chars[i] != chars[n - 1]) {
                chars[n++] = chars[i];
            }
        }

        // 2. ADIM: DP Tablosunu oluştur
        int[][] dp = new int[n][n];

        // Sondan başa doğru dolduruyoruz (Bottom-up DP)
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1; // Tek bir harf her zaman 1 hamledir

            for (int j = i + 1; j < n; j++) {
                if (chars[i] == chars[j]) {
                    // Eğer başlangıç ve bitiş harfi aynıysa, ekstra hamleye gerek yok.
                    // Örneğin "A...A" yazdırmak, "A..." yazdırmakla aynı maliyettedir.
                    dp[i][j] = dp[i][j - 1];
                } else {
                    // Eğer farklıysa, en iyi bölme noktasını (k) bul
                    int min = Integer.MAX_VALUE;
                    for (int k = i; k < j; k++) {
                        min = Math.min(min, dp[i][k] + dp[k + 1][j]);
                    }
                    dp[i][j] = min;
                }
            }
        }

        return dp[0][n - 1];
    }
}
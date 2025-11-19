class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        
        // Temel kontrol: s, t'den kısaysa t oluşturulamaz.
        if (m < n) {
            return 0;
        }

        // String fonksiyonları (charAt) yerine array erişimi çok daha hızlıdır.
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        // Sadece t'nin uzunluğu kadar bir dizi yeterli (O(N) alan).
        int[] dp = new int[n + 1];

        // Base case: Boş t string'i oluşturmanın tek yolu (hiçbir şey seçmemek).
        dp[0] = 1;

        for (int i = 0; i < m; i++) {
            // Tersten döngü (Backward Iteration)
            // Neden? Çünkü dp[j]'yi güncellerken, bir önceki adımın (i-1) 
            // dp[j-1] değerine ihtiyacımız var. İleri doğru gidersek bu değeri ezeriz.
            for (int j = n; j >= 1; j--) {
                if (sArr[i] == tArr[j - 1]) {
                    dp[j] += dp[j - 1];
                }
                // Eşleşme yoksa dp[j] değişmez, çünkü dp[j] zaten 
                // s'in bir önceki karakterine kadar olan sonucu tutuyor.
            }
        }

        return dp[n];
    }
}
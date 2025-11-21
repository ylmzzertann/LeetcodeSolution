class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        // Sınırları yönetmek için başına ve sonuna 1 ekliyoruz.
        int[] arr = new int[n + 2];
        arr[0] = 1;
        arr[n + 1] = 1;
        for (int i = 0; i < n; i++) {
            arr[i + 1] = nums[i];
        }

        // dp[i][j]: i ve j arasındaki (i ve j hariç) balonları patlatarak 
        // elde edilen maksimum puan.
        int[][] dp = new int[n + 2][n + 2];

        // Tersten (aşağıdan yukarıya) veya aralık genişliğine göre doldurmalıyız.
        // left indeksini n'den geriye doğru götürerek alt problemleri önce çözüyoruz.
        for (int left = n; left >= 0; left--) {
            // right her zaman left'in en az 2 ilerisinde olmalı (arada en az 1 balon olmalı)
            for (int right = left + 2; right <= n + 1; right++) {
                
                // i: left ve right arasında, EN SON patlatılacak balon
                for (int i = left + 1; i < right; i++) {
                    int coins = arr[left] * arr[i] * arr[right];
                    // Toplam = Sol tarafın max'ı + Sağ tarafın max'ı + Şu anki patlama
                    coins += dp[left][i] + dp[i][right];
                    
                    if (coins > dp[left][right]) {
                        dp[left][right] = coins;
                    }
                }
            }
        }

        // 0 ile n+1 arasındaki (tüm orijinal array) maksimum puan
        return dp[0][n + 1];
    }
}
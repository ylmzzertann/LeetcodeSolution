class Solution {
    public int numIdenticalPairs(int[] nums) {
        // Kısıtlamalara göre sayılar 1 ile 100 arasında. 
        // Bu yüzden 101 boyutunda bir dizi işimizi görür (HashMap'ten daha hızlıdır).
        int[] counts = new int[101];
        int goodPairs = 0;

        for (int num : nums) {
            // 1. Bu sayıyı daha önce gördüysen, o kadar yeni çift oluşur.
            // Örneğin: Daha önce 2 tane '3' varsa, yeni gelen '3' ile 2 çift daha oluşur.
            goodPairs += counts[num];
            
            // 2. Sayacını artır ki bir sonraki gelen bununla eşleşebilsin.
            counts[num]++;
        }

        return goodPairs;
    }
}
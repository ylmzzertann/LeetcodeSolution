class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        // Adım 1: Sayıların frekansını tutmak için 101 elemanlı bir dizi oluşturulur.
        // Problem kısıtlamalarına göre sayılar 0 ile 100 arasındadır.
        int[] counts = new int[101];
        for (int num : nums) {
            counts[num]++;
        }

        // Adım 2: Kümülatif toplam hesaplanır.
        // Bu adımdan sonra, counts[i] dizisi, i'den küçük sayıların toplam adedini tutar.
        for (int i = 1; i < 101; i++) {
            counts[i] += counts[i - 1];
        }

        // Adım 3: Sonuç dizisi oluşturulur.
        int n = nums.length;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int num = nums[i];


            if (num == 0) {
                result[i] = 0;
            } else {
                result[i] = counts[num - 1];
            }
        }

        return result;
    }
}
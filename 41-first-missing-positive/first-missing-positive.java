class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        int i = 0;

        // Adım 1: Sayıları doğru indekslerine (x -> index x-1) yerleştir
        while (i < n) {
            // Kontrol edilecek şartlar:
            // 1. Sayı pozitif olmalı (> 0)
            // 2. Sayı dizi sınırları içinde olmalı (<= n)
            // 3. Sayı zaten doğru yerinde OLMAMALI (tekrarları ve sonsuz döngüyü önlemek için)
            int correctIndex = nums[i] - 1;
            if (nums[i] > 0 && nums[i] <= n && nums[i] != nums[correctIndex]) {
                swap(nums, i, correctIndex);
            } else {
                i++;
            }
        }

        // Adım 2: İlk eksik sayıyı bul
        for (int j = 0; j < n; j++) {
            if (nums[j] != j + 1) {
                return j + 1;
            }
        }

        // Adım 3: Eğer hepsi tamsa, cevap n + 1'dir.
        return n + 1;
    }

    private void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;           // nums1'in geçerli son elemanı
        int j = n - 1;           // nums2'nin son elemanı
        int k = m + n - 1;       // nums1'in son indexi (boşluklar dahil)

        // Büyükten küçüğe sona yerleştir
        while (j >= 0) {         // nums2 bitene kadar devam (kalan nums1 zaten yerinde)
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
    }
}

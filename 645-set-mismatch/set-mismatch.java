class Solution {
    public int[] findErrorNums(int[] nums) {
        int dup = -1, missing = -1;

        // 1) Ziyaret işaretleme: görülen indexi negatife çevir
        for (int x : nums) {
            int i = Math.abs(x) - 1;      // değerler 1..n, index 0..n-1
            if (nums[i] < 0) {
                dup = Math.abs(x);        // ikinci kez görüyorsak bu sayı çift yazılmış
            } else {
                nums[i] = -nums[i];       // ilk kez görüyorsak işaretle
            }
        }

        // 2) Pozitif kalan index + 1 => hiç işaretlenmeyen = kayıp sayı
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                missing = i + 1;
                break;
            }
        }

        return new int[]{dup, missing};
    }
}

class Solution {
    public int singleNumber(int[] nums) {
        int sonuc = 0;
        for (int sayi : nums) {
            sonuc = sonuc ^ sayi;
        }
        return sonuc;
    }
}
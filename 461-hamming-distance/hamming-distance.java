class Solution {
    public int hammingDistance(int x, int y) {
        int xor = x ^ y; // Farklı bitleri bul
        int count = 0;
        while (xor != 0) {
            count += xor & 1; // Son biti kontrol et
            xor >>= 1;        // Sağa kaydır
        }
        return count;
    }
}

class Solution {
    public int findComplement(int num) {
        // Tüm bitleri 1 olan bir mask oluştur
        int mask = (Integer.highestOneBit(num) << 1) - 1;
        return num ^ mask;
    }
}

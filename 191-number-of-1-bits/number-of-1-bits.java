class Solution {
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            n &= (n - 1); // En düşük 1 bitini sıfırlar
            count++;
        }
        return count;
    }
}

import java.util.HashSet;

class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        long sumA = 0, sumB = 0;
        for (int x : aliceSizes) sumA += x;
        for (int x : bobSizes)  sumB += x;

        long diff = (sumA - sumB) / 2; // a - b must equal diff

        HashSet<Integer> bobSet = new HashSet<>();
        for (int b : bobSizes) bobSet.add(b);

        for (int a : aliceSizes) {
            int b = (int)(a - diff);
            if (bobSet.contains(b)) return new int[]{a, b};
        }
        return new int[0]; // guaranteed to exist, but just in case
    }
}

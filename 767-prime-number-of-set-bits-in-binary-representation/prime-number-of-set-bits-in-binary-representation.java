import java.util.*;

class Solution {
    public int countPrimeSetBits(int left, int right) {
        // Asal sayılar (maks 32 bit için yeterli)
        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31};
        int primeMask = 0;
        for (int p : primes) primeMask |= (1 << p);

        int ans = 0;
        for (int x = left; x <= right; x++) {
            int bc = Integer.bitCount(x); // çok hızlı (intrinsic)
            if ((primeMask & (1 << bc)) != 0) ans++;
        }
        return ans;
    }
}

class Solution {
    public int maxProfit(int[] prices) {
        int minSoFar = Integer.MAX_VALUE; // şimdiye kadarki en düşük alış fiyatı
        int maxProfit = 0;                // şimdiye kadarki en iyi kâr

        for (int p : prices) {
            if (p < minSoFar) {
                minSoFar = p;             // daha ucuz bir gün bulduk, buradan alırız
            } else {
                maxProfit = Math.max(maxProfit, p - minSoFar); // bugün satarsak kâr
            }
        }
        return maxProfit; // kâr yoksa 0 döner
    }
}

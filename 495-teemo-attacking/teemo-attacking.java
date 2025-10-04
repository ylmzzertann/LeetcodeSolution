class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries == null || timeSeries.length == 0 || duration <= 0) return 0;

        int total = 0;
        for (int i = 0; i < timeSeries.length - 1; i++) {
            int gap = timeSeries[i + 1] - timeSeries[i];
            total += Math.min(duration, gap); // örtüşme varsa sadece gap kadar eklenir
        }
        return total + duration; // son saldırı her zaman tam süre ekler
    }
}

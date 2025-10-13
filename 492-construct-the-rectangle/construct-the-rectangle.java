class Solution {
    public int[] constructRectangle(int area) {
        int w = (int) Math.sqrt(area);
        for (int i = w; i >= 1; i--) {
            if (area % i == 0) {
                int W = i;
                int L = area / i;
                return new int[]{L, W};
            }
        }
        // area >= 1, döngü mutlaka döneceği için buraya normalde gelinmez.
        return new int[]{area, 1};
    }
}

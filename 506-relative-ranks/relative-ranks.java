import java.util.*;

class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        String[] result = new String[n];
        
        // Skorlarla birlikte indeksleri sakla
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = score[i];  // skor
            arr[i][1] = i;         // orijinal index
        }
        
        // Skorları büyükten küçüğe sırala
        Arrays.sort(arr, (a, b) -> b[0] - a[0]);
        
        for (int i = 0; i < n; i++) {
            int idx = arr[i][1]; // orijinal index
            if (i == 0) {
                result[idx] = "Gold Medal";
            } else if (i == 1) {
                result[idx] = "Silver Medal";
            } else if (i == 2) {
                result[idx] = "Bronze Medal";
            } else {
                result[idx] = String.valueOf(i + 1);
            }
        }
        
        return result;
    }
}

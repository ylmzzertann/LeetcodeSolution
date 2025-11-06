import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        // 1) Başlangıca göre sırala
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();

        // 2) Merge et
        int[] current = intervals[0];  // şu anki birleştirdiğimiz aralık
        merged.add(current);

        for (int i = 1; i < intervals.length; i++) {
            int[] next = intervals[i];

            // Eğer çakışma varsa: current[1] >= next[0]
            if (current[1] >= next[0]) {
                // bitişi güncelle: max(current_end, next_end)
                current[1] = Math.max(current[1], next[1]);
            } else {
                // çakışma yoksa, yeni aralığa geç
                current = next;
                merged.add(current);
            }
        }

        // List<int[]> -> int[][]
        return merged.toArray(new int[merged.size()][]);
    }
}

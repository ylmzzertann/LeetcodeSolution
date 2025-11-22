import java.util.List;
import java.util.PriorityQueue;

class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        // Min-Heap yapısı: int[]{değer, liste_indexi, eleman_indexi}
        // Değere göre küçükten büyüğe sıralar.
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        
        int maxVal = Integer.MIN_VALUE;
        int rangeStart = 0;
        int rangeEnd = Integer.MAX_VALUE;
        
        // 1. Adım: Her listenin ilk elemanını heap'e ekle
        // Bu sayede başlangıçta her listeden bir temsilcimiz olur.
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i).isEmpty()) continue; // Güvenlik kontrolü
            int val = nums.get(i).get(0);
            pq.offer(new int[] { val, i, 0 });
            maxVal = Math.max(maxVal, val);
        }
        
        // 2. Adım: Heap dolu olduğu sürece (veya bir liste bitene kadar) devam et
        while (pq.size() == nums.size()) {
            int[] curr = pq.poll(); // En küçük elemanı al
            int minVal = curr[0];
            int row = curr[1]; // Hangi listeden geldiği
            int col = curr[2]; // Listenin kaçıncı elemanı olduğu
            
            // Eğer bulduğumuz yeni aralık (maxVal - minVal), kayıtlı olandan daha küçükse güncelle
            if (maxVal - minVal < rangeEnd - rangeStart) {
                rangeStart = minVal;
                rangeEnd = maxVal;
            }
            
            // Çekilen elemanın olduğu listede bir sonraki eleman var mı?
            if (col + 1 < nums.get(row).size()) {
                int nextVal = nums.get(row).get(col + 1);
                pq.offer(new int[] { nextVal, row, col + 1 });
                // Yeni eklenen eleman, mevcut maksimumdan büyük olabilir
                maxVal = Math.max(maxVal, nextVal);
            } else {
                // Listelerden biri bitti. Artık tüm listeleri kapsayan bir aralık oluşturamayız.
                break;
            }
        }
        
        return new int[] { rangeStart, rangeEnd };
    }
}
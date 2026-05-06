import java.util.Arrays;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        // 1. Diziyi sırala
        Arrays.sort(nums);
        
        // İlk üç sayının toplamını başlangıç değeri olarak alalım
        int closestSum = nums[0] + nums[1] + nums[2];
        
        // 2. Diziyi gezmeye başla
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            
            while (left < right) {
                int currentSum = nums[i] + nums[left] + nums[right];
                
                // Eğer hedefi tam bulursak direkt döndür
                if (currentSum == target) {
                    return currentSum;
                }
                
                // Eğer mevcut toplam, eski en yakın toplamdan daha yakınsa güncelle
                // Mutlak fark (absolute difference) karşılaştırması yapıyoruz
                if (Math.abs(target - currentSum) < Math.abs(target - closestSum)) {
                    closestSum = currentSum;
                }
                
                // Toplamı hedefe yaklaştırmak için işaretçileri kaydır
                if (currentSum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        
        return closestSum;
    }
}
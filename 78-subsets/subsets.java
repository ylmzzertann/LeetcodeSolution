import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // Başlangıçta boş listeyi ve başlangıç indeksini gönderiyoruz
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, int start) {
        // Her adımda oluşan tempList aslında geçerli bir alt kümedir
        result.add(new ArrayList<>(tempList));

        for (int i = start; i < nums.length; i++) {
            // Karar: Elemanı ekle
            tempList.add(nums[i]);
            
            // Bir sonraki elemana geç (i + 1)
            backtrack(result, tempList, nums, i + 1);
            
            // Geri İzleme: Eklediğimiz son elemanı çıkararak diğer olasılıklara bak
            tempList.remove(tempList.size() - 1);
        }
    }
}
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, List<Integer> current, List<List<Integer>> result) {
        // Tüm sayılar kullanıldıysa bir permütasyon bulundu
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current)); // yeni bir kopya eklenir
            return;
        }

        for (int num : nums) {
            // Eğer zaten current içinde varsa atla
            if (current.contains(num)) continue;

            current.add(num); // sayıyı ekle
            backtrack(nums, current, result); // geri izleme
            current.remove(current.size() - 1); // son eklenen sayıyı çıkar
        }
    }
}
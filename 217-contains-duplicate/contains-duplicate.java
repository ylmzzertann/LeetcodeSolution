class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();
        
        for (int num : nums) {
            if (seen.contains(num)) {
                return true; // Daha önce gördüysek, tekrar var demektir
            }
            seen.add(num);
        }
        
        return false; // Hiç tekrar eden eleman yoksa
    }
}
class Solution {
    public int firstUniqChar(String s) {
        int[] count = new int[26]; // sadece küçük harfler olduğu için 26 yeterli

        // 1. Geçiş: her harfin kaç kez geçtiğini say
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }

        // 2. Geçiş: ilk 1 kez geçen karakterin index'ini döndür
        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        return -1; // tekrar etmeyen karakter yoksa
    }
}

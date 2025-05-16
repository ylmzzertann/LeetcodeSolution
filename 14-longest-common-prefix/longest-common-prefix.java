class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        // İlk kelimeyi referans olarak alıyoruz
        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            // prefix, o anki string'in başında yer almıyorsa
            while (strs[i].indexOf(prefix) != 0) {
                // prefix'ten bir karakter silerek kısalt
                prefix = prefix.substring(0, prefix.length() - 1);

                // Eğer prefix tamamen boş kalırsa, ortak prefix yok demektir
                if (prefix.isEmpty()) return "";
            }
        }

        return prefix;
    }
}

class Solution {
    public int[] numberOfLines(int[] widths, String s) {
        int lines = 1;      // s boş değilse en az 1 satır
        int lastWidth = 0;  // son satırın dolu genişliği

        for (char ch : s.toCharArray()) {
            int w = widths[ch - 'a'];
            if (lastWidth + w > 100) { // yeni satır
                lines++;
                lastWidth = w;
            } else {
                lastWidth += w;
            }
        }
        return new int[] { lines, lastWidth };
    }
}

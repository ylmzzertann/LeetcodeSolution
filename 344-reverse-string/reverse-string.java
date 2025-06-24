class Solution {
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;

        while (left < right) {
            // Karakterleri takas et
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;

            // İndeksleri ilerlet
            left++;
            right--;
        }
    }
}

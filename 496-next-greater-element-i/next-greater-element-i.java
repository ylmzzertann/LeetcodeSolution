import java.util.Arrays;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // nums2'deki max değeri bul: nextGreater dizisini tam boyutlu açacağız
        int maxVal = 0;
        for (int x : nums2) if (x > maxVal) maxVal = x;

        int[] nextGreater = new int[maxVal + 1];
        Arrays.fill(nextGreater, -1); // default: sağında büyük yok

        // Monotonik azalan yığın (primitive int stack)
        int n = nums2.length;
        int[] stack = new int[n];
        int top = -1;

        for (int x : nums2) {
            while (top >= 0 && stack[top] < x) {
                nextGreater[stack[top--]] = x;
            }
            stack[++top] = x;
        }
        // Kalanlar zaten -1

        // nums1 cevapları
        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            int v = nums1[i];
            ans[i] = (v <= maxVal) ? nextGreater[v] : -1;
        }
        return ans;
    }
}

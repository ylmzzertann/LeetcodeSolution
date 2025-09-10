import java.util.*;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // nums2'deki her sayı için "bir sonraki büyük" değer
        Map<Integer, Integer> next = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>(); // azalan yığın

        for (int x : nums2) {
            // x, yığının tepesinden büyükse; tepedekinin next greater'ı x'tir
            while (!stack.isEmpty() && stack.peek() < x) {
                next.put(stack.pop(), x);
            }
            stack.push(x);
        }

        // Yığında kalanların sağında daha büyük yok
        while (!stack.isEmpty()) {
            next.put(stack.pop(), -1);
        }

        // nums1 için cevapları doldur
        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = next.getOrDefault(nums1[i], -1);
        }
        return ans;
    }
}

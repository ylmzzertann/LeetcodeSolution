import java.util.*;

class Solution {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> res = new ArrayList<>();
        int n = s.length();
        if (n < 3) return res;

        char[] a = s.toCharArray();
        int i = 0;
        while (i < n) {
            int j = i + 1;
            while (j < n && a[j] == a[i]) j++;
            if (j - i >= 3) res.add(Arrays.asList(i, j - 1));
            i = j;
        }
        return res;
    }
}

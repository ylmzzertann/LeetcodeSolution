import java.util.*;

class Solution {
    public int distributeCandies(int[] candyType) {
        Set<Integer> kinds = new HashSet<>();
        for (int c : candyType) kinds.add(c);
        int maxEat = candyType.length / 2;
        return Math.min(kinds.size(), maxEat);
    }
}

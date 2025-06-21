import java.util.*;

class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> targetList = new ArrayList<>();
        
        for (int i = 0; i < nums.length; i++) {
            targetList.add(index[i], nums[i]);
        }
        
        // Listeyi diziye çevir
        int[] targetArray = new int[targetList.size()];
        for (int i = 0; i < targetList.size(); i++) {
            targetArray[i] = targetList.get(i);
        }
        
        return targetArray;
    }
}

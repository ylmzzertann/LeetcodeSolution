class Solution {
    public boolean containsPattern(int[] arr, int m, int k) {
        int n = arr.length;
        int count = 0;
        
        for (int i = 0; i + m < n; i++) {
            
            if (arr[i] != arr[i + m]) {
                count = 0;
            } else {
                count++;
            }
            
    
            if (count == (k - 1) * m) {
                return true;
            }
        }
        
        return false;
    }
}
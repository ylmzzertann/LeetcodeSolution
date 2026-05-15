class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        // There are 2^n numbers in the sequence
        int numCount = 1 << n; 
        
        for (int i = 0; i < numCount; i++) {
            // Standard binary to gray code formula: i ^ (i >> 1)
            result.add(i ^ (i >> 1));
        }
        
        return result;
    }
}
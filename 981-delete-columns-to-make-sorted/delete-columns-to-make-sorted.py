class Solution(object):
    def minDeletionSize(self, strs):
        """
        :type strs: List[str]
        :rtype: int
        """
        # Count of columns we need to delete
        delete_count = 0
        
        # Number of rows (total strings) and columns (length of strings)
        num_rows = len(strs)
        num_cols = len(strs[0])
        
        # Iterate through each column
        for col in range(num_cols):
            # Check characters from top to bottom in the current column
            for row in range(1, num_rows):
                # If the current character is lexicographically smaller than the one above it
                if strs[row][col] < strs[row - 1][col]:
                    delete_count += 1
                    break # Break early; we already know this column is bad
                    
        return delete_count
class Solution(object):
    def plusOne(self, digits):
        """
        :type digits: List[int]
        :rtype: List[int]
        """
        # Start iterating from the last element down to the first
        for i in range(len(digits) - 1, -1, -1):
            # If the current digit is less than 9, just increment and return
            if digits[i] < 9:
                digits[i] += 1
                return digits
            
            # If the digit is 9, it rolls over to 0
            digits[i] = 0
        
        # If the loop finishes, it means all digits were 9s (e.g., [9, 9, 9])
        # We need to prepend a 1 to the front
        return [1] + digits
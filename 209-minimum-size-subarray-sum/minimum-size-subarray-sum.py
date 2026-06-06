class Solution(object):
    def minSubArrayLen(self, target, nums):
        """
        :type target: int
        :type nums: List[int]
        :rtype: int
        """
        left = 0
        current_sum = 0
        min_length = float('inf')  # Initialize with infinity to easily find the minimum
        
        for right in range(len(nums)):
            current_sum += nums[right]
            
            # Shrink the window from the left as long as the condition is met
            while current_sum >= target:
                min_length = min(min_length, right - left + 1)
                current_sum -= nums[left]
                left += 1
                
        # If min_length was never updated, it means no valid subarray exists
        return min_length if min_length != float('inf') else 0
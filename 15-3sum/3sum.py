class Solution(object):
    def threeSum(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        nums.sort()
        res = []
        
        # We only need to iterate up to the third-to-last element
        for i in range(len(nums) - 2):
            # If the current number is greater than 0, we can't sum to 0
            if nums[i] > 0:
                break
            
            # Skip duplicates for the first element
            if i > 0 and nums[i] == nums[i - 1]:
                continue
                
            left, right = i + 1, len(nums) - 1
            
            while left < right:
                total = nums[i] + nums[left] + nums[right]
                
                if total < 0:
                    left += 1
                elif total > 0:
                    right -= 1
                else:
                    res.append([nums[i], nums[left], nums[right]])
                    
                    # Move both pointers inward
                    left += 1
                    right -= 1
                    
                    # Skip duplicates for the second element (left pointer)
                    while left < right and nums[left] == nums[left - 1]:
                        left += 1
                        
        return res
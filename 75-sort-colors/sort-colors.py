class Solution(object):
    def sortColors(self, nums):
        """
        :type nums: List[int]
        :rtype: None
        """
        left = 0
        right = len(nums) - 1
        i = 0

        while i <= right:
            if nums[i] == 0:
                nums[left], nums[i] = nums[i], nums[left]
                left += 1
                i += 1

            elif nums[i] == 2:
                nums[right], nums[i] = nums[i], nums[right]
                right -= 1

            else:  # nums[i] == 1
                i += 1
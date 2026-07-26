class Solution(object):
    def removeDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums:
            return 0

        # k tracks the index for the next unique element
        k = 1

        for i in range(1, len(nums)):
            # If current element is different from the last unique element recorded
            if nums[i] != nums[k - 1]:
                nums[k] = nums[i]
                k += 1

        return k
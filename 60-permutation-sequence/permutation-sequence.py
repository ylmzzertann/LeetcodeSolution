class Solution(object):
    def getPermutation(self, n, k):
        """
        :type n: int
        :type k: int
        :rtype: str
        """
        from math import factorial

        nums = [str(i) for i in range(1, n + 1)]
        k -= 1  # 0-based indexing

        res = []

        for i in range(n, 0, -1):
            fact = factorial(i - 1)

            idx = k // fact
            res.append(nums.pop(idx))

            k %= fact

        return "".join(res)
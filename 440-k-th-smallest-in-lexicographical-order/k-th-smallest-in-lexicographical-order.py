
class Solution:
    def findKthNumber(self, n: int, k: int) -> int:
        def count_steps(curr, next_prefix):
            steps = 0
            while curr <= n:
                steps += min(n + 1, next_prefix) - curr
                curr *= 10
                next_prefix *= 10
            return steps

        curr = 1
        k -= 1

        while k > 0:
            steps = count_steps(curr, curr + 1)

            if steps <= k:
                # Skip this entire prefix subtree
                curr += 1
                k -= steps
            else:
                # Move deeper into this prefix subtree
                curr *= 10
                k -= 1

        return curr

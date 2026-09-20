class Solution:
    def isInterleave(self, s1: str, s2: str, s3: str) -> bool:
        if len(s1) + len(s2) != len(s3):
            return False

        # dp[j] = whether s3[:i+j] can be formed
        # using s1[:i] and s2[:j]
        dp = [False] * (len(s2) + 1)
        dp[0] = True

        for j in range(1, len(s2) + 1):
            dp[j] = dp[j - 1] and s2[j - 1] == s3[j - 1]

        for i in range(1, len(s1) + 1):
            # Take the next character from s1
            dp[0] = dp[0] and s1[i - 1] == s3[i - 1]

            for j in range(1, len(s2) + 1):
                k = i + j - 1

                # Option 1: take s1[i - 1]
                from_s1 = dp[j] and s1[i - 1] == s3[k]

                # Option 2: take s2[j - 1]
                from_s2 = dp[j - 1] and s2[j - 1] == s3[k]

                dp[j] = from_s1 or from_s2

        return dp[len(s2)]

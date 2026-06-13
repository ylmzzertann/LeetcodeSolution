class Solution(object):
    def shortestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        rev = s[::-1]
        pattern = s + "#" + rev

        lps = [0] * len(pattern)

        j = 0
        for i in range(1, len(pattern)):
            while j > 0 and pattern[i] != pattern[j]:
                j = lps[j - 1]

            if pattern[i] == pattern[j]:
                j += 1
                lps[i] = j

        longest_pal_prefix = lps[-1]

        suffix = s[longest_pal_prefix:]
        return suffix[::-1] + s
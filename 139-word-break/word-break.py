class Solution(object):
    def wordBreak(self, s, wordDict):
        """
        :type s: str
        :type wordDict: List[str]
        :rtype: bool
        """
        # Convert list to set for O(1) lookups
        word_set = set(wordDict)
        
        # dp[i] means s[0:i] can be segmented into dictionary words
        dp = [False] * (len(s) + 1)
        dp[0] = True # Base case: empty string
        
        # Iterate through the string to fill the DP table
        for i in range(1, len(s) + 1):
            for j in range(i):
                # If s[0:j] is valid and s[j:i] is a valid word, then s[0:i] is valid
                if dp[j] and s[j:i] in word_set:
                    dp[i] = True
                    break # Move to the next i once we find a valid split
                    
        return dp[len(s)]
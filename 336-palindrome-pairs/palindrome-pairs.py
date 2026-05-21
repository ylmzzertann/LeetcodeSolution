class Solution(object):
    def palindromePairs(self, words):
        """
        :type words: List[str]
        :rtype: List[List[int]]
        """
        word_to_idx = {word: i for i, word in enumerate(words)}
        pairs = []
        
        for i, word in enumerate(words):
            # We iterate through every possible split point
            for j in range(len(word) + 1):
                prefix = word[:j]
                suffix = word[j:]
                
                # Case 1: Check if the prefix is a palindrome
                if prefix == prefix[::-1]:
                    rev_suffix = suffix[::-1]
                    # Ensure the matching word exists, isn't the current word,
                    # and handle the empty string correctly
                    if rev_suffix in word_to_idx and word_to_idx[rev_suffix] != i:
                        pairs.append([word_to_idx[rev_suffix], i])
                        
                # Case 2: Check if the suffix is a palindrome
                if suffix == suffix[::-1]:
                    rev_prefix = prefix[::-1]
                    # CRUCIAL FIX: 'j < len(word)' prevents duplicate pairs 
                    # when the prefix is the entire word (which Case 1 already handled when j=0)
                    if j < len(word) and rev_prefix in word_to_idx and word_to_idx[rev_prefix] != i:
                        pairs.append([i, word_to_idx[rev_prefix]])
                        
        return pairs
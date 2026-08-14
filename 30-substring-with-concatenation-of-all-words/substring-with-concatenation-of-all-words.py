class Solution(object):
    def findSubstring(self, s, words):
        """
        :type s: str
        :type words: List[str]
        :rtype: List[int]
        """
        if not s or not words:
            return []

        word_len = len(words[0])
        word_count = len(words)
        total_len = word_len * word_count

        if total_len > len(s):
            return []

        # Required frequency of each word
        target = {}
        for word in words:
            target[word] = target.get(word, 0) + 1

        ans = []

        # Try every possible alignment within a word
        for offset in range(word_len):
            left = offset
            right = offset
            window = {}
            count = 0

            while right + word_len <= len(s):
                word = s[right:right + word_len]
                right += word_len

                # Word isn't in words, so reset the window
                if word not in target:
                    window.clear()
                    count = 0
                    left = right
                    continue

                # Add word to current window
                window[word] = window.get(word, 0) + 1
                count += 1

                # Too many copies of this word:
                # shrink from the left until valid again
                while window[word] > target[word]:
                    left_word = s[left:left + word_len]
                    window[left_word] -= 1
                    left += word_len
                    count -= 1

                # Exactly word_count words -> valid answer
                if count == word_count:
                    ans.append(left)

                    # Move left forward so we can continue searching
                    left_word = s[left:left + word_len]
                    window[left_word] -= 1
                    left += word_len
                    count -= 1

        return ans
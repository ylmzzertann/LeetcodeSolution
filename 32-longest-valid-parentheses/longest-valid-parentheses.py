class Solution(object):
    def longestValidParentheses(self, s):
        """
        :type s: str
        :rtype: int
        """
        stack = [-1]  
        max_len = 0
        
        for i, char in enumerate(s):
            if char == '(':
                stack.append(i)
            else:
                stack.pop()
                if not stack:
                    # The stack is empty; this ')' is an unmatched barrier.
                    # Push its index as the new base anchor.
                    stack.append(i)
                else:
                    # Valid substring found! Calculate length using the current index
                    # minus the index of the last unmatched element remaining in the stack.
                    max_len = max(max_len, i - stack[-1])
                    
        return max_len
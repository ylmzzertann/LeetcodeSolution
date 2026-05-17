class Solution(object):
    def canCross(self, stones):
        """
        :type stones: List[int]
        :rtype: bool
        """
        # Create a set of stone positions for O(1) lookups
        stone_set = set(stones)
        target = stones[-1]
        
        # Memoization dictionary to store (current_stone, last_jump) -> bool
        memo = {}
        
        def dfs(position, k):
            # Base Case: If we reached the last stone, we made it!
            if position == target:
                return True
                
            # If we've already calculated this state, return the cached result
            if (position, k) in memo:
                return memo[(position, k)]
            
            # Explore all 3 possible next jumps: k-1, k, k+1
            for next_jump in (k - 1, k, k + 1):
                # The frog can only jump forward (jump size must be greater than 0)
                if next_jump > 0:
                    next_position = position + next_jump
                    # If the next position has a stone, recursively explore it
                    if next_position in stone_set:
                        if dfs(next_position, next_jump):
                            memo[(position, k)] = True
                            return True
                            
            # If no jumps from this state lead to the target, cache and return False
            memo[(position, k)] = False
            return False
        
        # The problem states the first jump MUST be exactly 1 unit from the first stone (stones[0])
        # If the second stone isn't at position 1, the frog can't even make the first jump.
        if stones[1] != 1:
            return False
            
        return dfs(1, 1)
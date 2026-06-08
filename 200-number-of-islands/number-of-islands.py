class Solution(object):
    def numIslands(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """
        if not grid:
            return 0
        
        rows, cols = len(grid), len(grid[0])
        island_count = 0
        
        def dfs(r, c):
            # Base case: boundary check or if the cell is water ('0')
            if r < 0 or r >= rows or c < 0 or c >= cols or grid[r][c] == '0':
                return
            
            # Mark the current cell as visited by sinking it to '0'
            grid[r][c] = '0'
            
            # Explore all 4 adjacent directions (up, down, left, right)
            dfs(r + 1, c) # Down
            dfs(r - 1, c) # Up
            dfs(r, c + 1) # Right
            dfs(r, c - 1) # Left

        # Iterate through every cell in the 2D grid
        for r in range(rows):
            for c in range(cols):
                # If we find land, it's a new island
                if grid[r][c] == '1':
                    island_count += 1
                    # Sink the entire island using DFS
                    dfs(r, c)
                    
        return island_count
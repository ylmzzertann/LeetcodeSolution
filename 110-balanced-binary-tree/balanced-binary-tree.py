class Solution(object):
    def isBalanced(self, root):
        """
        :type root: Optional[TreeNode]
        :rtype: bool
        """
        # If check_height returns -1, the tree is unbalanced
        return self.check_height(root) != -1

    def check_height(self, root):
        # Base case: an empty node has a height of 0
        if not root:
            return 0
        
        # 1. Check the left subtree
        left_height = self.check_height(root.left)
        if left_height == -1:
            return -1
        
        # 2. Check the right subtree
        right_height = self.check_height(root.right)
        if right_height == -1:
            return -1
        
        # 3. Check balance condition of current node
        if abs(left_height - right_height) > 1:
            return -1
        
        # 4. Return actual height if balanced
        return max(left_height, right_height) + 1
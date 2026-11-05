class Solution:
    def inorderTraversal(self, root: TreeNode | None) -> list[int]:
        result = []

        def dfs(node):
            if not node:
                return

            dfs(node.left)       # Visit left subtree
            result.append(node.val)  # Visit root
            dfs(node.right)      # Visit right subtree

        dfs(root)
        return result
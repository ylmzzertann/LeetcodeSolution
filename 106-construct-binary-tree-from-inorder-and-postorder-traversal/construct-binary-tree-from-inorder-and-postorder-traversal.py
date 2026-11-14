
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def buildTree(self, inorder: list[int], postorder: list[int]) -> TreeNode | None:
        index_map = {val: i for i, val in enumerate(inorder)}
        post_idx = len(postorder) - 1

        def helper(left, right):
            nonlocal post_idx

            if left > right:
                return None

            # Last element in postorder is the root
            root_val = postorder[post_idx]
            post_idx -= 1

            root = TreeNode(root_val)
            mid = index_map[root_val]

            # Build right subtree first
            root.right = helper(mid + 1, right)
            root.left = helper(left, mid - 1)

            return root

        return helper(0, len(inorder) - 1)

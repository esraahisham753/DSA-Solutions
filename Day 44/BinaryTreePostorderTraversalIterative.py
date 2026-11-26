# Given the root of a binary tree, return the postorder traversal of its nodes' values.

# Definition for a binary tree node.

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def postorderTraversal(self, root: TreeNode | None) -> list[int]:
        if not root:
            return []

        stack1 = [root]
        stack2 = []

        while stack1:
            node = stack1.pop()
            
            if node.left:
                stack1.append(node.left)
            
            if node.right:
                stack1.append(node.right)
            
            stack2.append(node)
        
        return [node.val for node in reversed(stack2)]
        
# Given the root of a binary tree, return the preorder traversal of its nodes' values.

# Definition for a binary tree node.

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def preorderTraversal(self, root: TreeNode | None) -> list[int]:
        stack = []

        if root:
            stack.append(root)
        output = []
        

        while len(stack) > 0:
            node = stack.pop()
            output.append(node.val)
            
            if node.right:
                stack.append(node.right)
            
            if node.left:
                stack.append(node.left)
        
        return output
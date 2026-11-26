# Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where the sum of the node values in the path equals targetSum. Each path should be returned as a list of the node values, not node references.

# A root-to-leaf path is a path starting from the root and ending at any leaf node. A leaf is a node with no children.

# Definition for a binary tree node.

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def pathSum(self, root: TreeNode | None, targetSum: int) -> list[list[int]]:
        output = []
        path = []

        def preorder(node, target):
            if not node:
                return
            
            path.append(node.val)
            target -= node.val
            
            if not node.left and not node.right:
                if target == 0:
                    output.append(path.copy())
            else:
                preorder(node.left, target)
                preorder(node.right, target)
            
            path.pop()
            
        
        preorder(root, targetSum)
        return output

            
            

            
            
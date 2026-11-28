# Given the root of a binary tree, return its maximum depth.

# A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

# Definition for a binary tree node.

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

from collections import deque

class Solution:
    def maxDepth(self, root: TreeNode | None) -> int:
        if not root:
            return 0
            
        q = deque()
        q.append(root)
        levelCount = 1
        newLevelCount = 0
        level = 0

        while q:
            node = q.popleft()

            if node.left:
                q.append(node.left)
                newLevelCount += 1
            
            if node.right:
                q.append(node.right)
                newLevelCount += 1
            
            levelCount -= 1

            if levelCount == 0:
                level += 1
                levelCount = newLevelCount
                newLevelCount = 0
        
        return level
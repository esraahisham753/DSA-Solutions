# Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

from collections import deque


class Solution:
    def zigzagLevelOrder(self, root: TreeNode | None) -> list[list[int]]:
        if not root:
            return []

        output = []
        levelList = []
        levelCount = 1
        newLevelCount = 0
        q = deque()
        q.append(root)
        left = True

        while q:
            node = q.popleft()
            levelList.append(node.val)
            levelCount -= 1

            if node.left:
                q.append(node.left)
                newLevelCount += 1

            if node.right:
                q.append(node.right)
                newLevelCount += 1

            if levelCount == 0:
                if not left:
                    levelList.reverse()

                output.append(levelList)
                levelList = []
                levelCount = newLevelCount
                newLevelCount = 0
                left = not left

        return output

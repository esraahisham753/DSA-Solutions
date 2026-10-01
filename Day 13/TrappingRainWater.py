"""
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
"""

class Solution:
    def trap(self, height: list[int]) -> int:
        n = len(height)

        if n == 0:
            return 0
        
        left = 0
        right = n - 1
        leftMax = 0
        rightMax = 0
        water = 0

        while left < right:
            if height[left] <= height[right]:
                if height[left] > leftMax:
                    leftMax = height[left]
                else:
                    water += leftMax - height[left]
                
                left += 1
            else:
                if height[right] > rightMax:
                    rightMax = height[right]
                else:
                    water += rightMax - height[right]

                right -= 1

        return water 
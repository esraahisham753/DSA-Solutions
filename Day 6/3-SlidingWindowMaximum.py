"""
You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

Return the max sliding window.
"""

from collections import deque 

class Solution:
    def maxSlidingWindow(self, nums: list[int], k: int) -> list[int]:
        dq = deque()
        result = []
        
        for i in range(len(nums)):
            if len(dq) > 0 and dq[0] <= i - k:
                dq.popleft()
            
            while len(dq) > 0 and nums[dq[-1]] < nums[i]:
                dq.pop()
            
            dq.append(i)

            if i >= k -1:
                result.append(nums[dq[0]])
        
        return result
        
        



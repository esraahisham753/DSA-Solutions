"""
Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.
"""

class Solution:
    def intersect(self, nums1: list[int], nums2: list[int]) -> list[int]:
        map1 = {}
        res = []

        for num in nums1:
            map1[num] = map1.get(num, 0) + 1
        
        for num in nums2:
            if num in map1 and map1[num] > 0:
                res.append(num)
                map1[num] -= 1
        
        
        return res
        
        

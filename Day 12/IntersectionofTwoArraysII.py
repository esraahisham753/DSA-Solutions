"""
Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.
"""

class Solution:
    def intersect(self, nums1: list[int], nums2: list[int]) -> list[int]:
        set1 = set(nums1)
        set2 = set(nums2)
        intersect = set1.intersection(set2)

        map1 = {}
        map2 = {}

        for num in nums1:
            map1[num] = map1.get(num, 0) + 1
        
        for num in nums2:
            map2[num] = map2.get(num, 0) + 1
        
        res = []

        for num in intersect:
            res.extend([num] * min(map1[num], map2[num]))
        
        return res
        

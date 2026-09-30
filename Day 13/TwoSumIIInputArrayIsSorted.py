"""
You are given a 1-indexed array of integers numbers that is already sorted in non-decreasing order.

Find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.

Return the indices of the two numbers index1 and index2 as an integer array [index1, index2] of length 2.

The tests are generated such that there is exactly one solution. You may not use the same element twice.

Your solution must use only constant extra space.
"""

class Solution:
    def twoSum(self, numbers: list[int], target: int) -> list[int]:
        res = []
        l = 0
        r = len(numbers) - 1

        while l < r:
            sumVal = numbers[l] + numbers[r]

            if sumVal == target:
                res.append(l + 1)
                res.append(r + 1)

                return res
            elif sumVal < target:
                l += 1
            else:
                r -= 1
        
        return []

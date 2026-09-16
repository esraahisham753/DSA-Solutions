class Solution(object):
    def runningSum(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        running_sums = [nums[0]]

        for i in range(1, len(nums)):
            running_sums.append(running_sums[i - 1] + nums[i])
        
        return running_sums
        
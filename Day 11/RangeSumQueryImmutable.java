/*
Given an integer array nums, handle multiple queries of the following type:

Calculate the sum of the elements of nums between indices left and right inclusive where left <= right.
Implement the NumArray class:

NumArray(int[] nums) Initializes the object with the integer array nums.
int sumRange(int left, int right) Returns the sum of the elements of nums between indices left and right inclusive (i.e. nums[left] + nums[left + 1] + ... + nums[right]).
*/

class NumArray {
    private int[] prefix;

    public NumArray(int[] nums) {
        this.prefix = new int[nums.length + 1];
        this.prefix[0] = 0;

        for (int i = 1; i <= nums.length; i++) {
            this.prefix[i] = this.prefix[i - 1] + nums[i - 1];
        }    
    }
    
    public int sumRange(int left, int right) {
        return this.prefix[right + 1] - this.prefix[left];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
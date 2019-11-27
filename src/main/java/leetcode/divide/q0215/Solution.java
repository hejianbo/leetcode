package leetcode.divide.q0215;

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        return findKth(nums, k, 0, nums.length - 1);
    }

    private int findKth(int[] nums, int k, int left, int right) {
        // 取中位数
        int pivot = partition(nums, left, right);
        // 大于中位数的放左边, 小于中位数的放右边
        // 如果左边部分 = k - 1 则返回 k
        if (pivot == k - 1) {
            return nums[pivot];
        } else if (pivot > k - 1){
            return findKth(nums, k, left, pivot - 1);
        } else {
            return findKth(nums, k, pivot + 1, right);
        }
    }

    private int partition(int[] nums, int start, int end) {
        int left = start + 1;
        int right = end;
        int val = nums[start];
        while (left <= right) {
            while (left <= end && nums[left] >= val) {
                left++;
            }
            while(right >= start && nums[right] < val) {
                right--;
            }
            if (left < right) {
                swap(nums, left, right);
                left++;
                right--;
            }
        }
        swap(nums, start, right);
        return right;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

package leetcode.divide.q0215;

public class Test {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {3,2,3,1,2,4,5,5,6};
        int k = 4;
        int kthLargest = s.findKthLargest(nums, k);
        System.out.println(kthLargest);
    }
}

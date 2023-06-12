// Two Pointer Approach

class Solution {

    public List<String> summaryRanges(int[] nums) {
        int left = 0;
        List<String> ranges = new ArrayList<>();

        for (int right = 0; right < nums.length; right++) {
            if (right < nums.length - 1 && nums[right] + 1 == nums[right + 1]) {
                continue;
            }
            if (left == right) {
                ranges.add(String.valueOf(nums[left]));
            } else {
                ranges.add(nums[left] + "->" + nums[right]);
            }
            left = right + 1;
        }
        return ranges;
    }
}

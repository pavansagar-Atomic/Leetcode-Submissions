class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(0, nums, ans);
        return ans;
    }

    void solve(int index, int[] nums, List<List<Integer>> ans) {
        if (index == nums.length) {
            List<Integer> temp = new ArrayList<>();

            for (int num : nums) {
                temp.add(num);
            }

            ans.add(temp);
            return;
        }

        for (int i = index; i < nums.length; i++) {
            swap(i, index, nums);

            solve(index + 1, nums, ans);

            swap(i, index, nums);
        }
    }

    void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
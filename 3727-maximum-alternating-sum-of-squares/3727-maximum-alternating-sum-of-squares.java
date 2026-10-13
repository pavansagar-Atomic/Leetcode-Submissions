import java.util.Arrays;

class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long[] arr = new long[n];

        for (int i = 0; i < n; i++) {
            arr[i] = (long) nums[i] * nums[i];
        }

        Arrays.sort(arr);

        long ans = 0;
        int mid = n / 2;

        for (int i = 0; i < mid; i++) {
            ans -= arr[i];
        }

        for (int i = mid; i < n; i++) {
            ans += arr[i];
        }

        return ans;
    }
}
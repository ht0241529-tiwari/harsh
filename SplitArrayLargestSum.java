import java.util.*;

public class SplitArrayLargestSum {
    public static void main(String[] args) {
        int[] nums = {7, 2, 5, 10, 8};
        int m = 2;
        int ans = splitArray(nums, m);
        System.out.println(ans);  // Output should be 18
    }

    static int splitArray(int[] nums, int m) {
        int start = 0;
        int end = 0;

        // Step 1: Initialize start and end
        for (int i = 0; i < nums.length; i++) {
            start = Math.max(start, nums[i]); // max element
            end += nums[i];                   // total sum
        }

        // Step 2: Binary search between start and end
        while (start < end) {
            int mid = start + (end - start) / 2;

            // Step 3: Try to split array with max subarray sum = mid
            int sum = 0;
            int pieces = 1;

            for (int num : nums) {
                if (sum + num > mid) {
                    // Start new subarray
                    sum = num;
                    pieces++;
                } else {
                    sum += num;
                }
            }

            // Step 4: Adjust binary search bounds
            if (pieces > m) {
                start = mid + 1; // too many pieces, increase allowed sum
            } else {
                end = mid;       // valid split, try smaller max sum
            }
        }

        return start; // or end, both are equal here
    }
}
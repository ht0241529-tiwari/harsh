public class Find_Duplicate_in_Sorted_Cycle {
    public static void main(String[] args) {
        int[] num = {3, 1, 3, 4, 2};
    
        int duplicate = findDuplicate(num);
        System.out.println("Duplicate number is: " + duplicate);
    }

    public static int findDuplicate(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            // If current number is not at its correct index
            if (nums[i] != i + 1) {
                int correct = nums[i] - 1;

                // Check if the target index already has the same value
                if (nums[i] != nums[correct]) {
                    swap(nums, i, correct);
                } else {
                    // Duplicate found
                    return nums[i];
                }
            } else {
                i++;
            }
        }
        return -1; // Shouldn't reach here if there's guaranteed one duplicate
    }

    static void swap(int[] num, int first, int second) {
        int temp = num[first];
        num[first] = num[second];
        num[second] = temp;
    }
}
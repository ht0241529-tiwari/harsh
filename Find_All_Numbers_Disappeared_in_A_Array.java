//if range is from 0 to n then element will be at index equal to its value
//if range is from 1 to n then element will be at index equal to its value-1

import java.util.List;
import java.util.ArrayList;

public class Find_All_Numbers_Disappeared_in_A_Array {
    public static void main(String[] args) {
        int[] num = {4, 3, 2, 7, 8, 2, 3,1};
        List<Integer> missing = findDisappearedNumbers(num);
        System.out.println("Missing numbers: " + missing);
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int correct = nums[i] - 1;
            if (nums[i] != nums[correct]) {
                swap(nums, i, correct);
            } else {
                i++;
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int index = 0; index < nums.length; index++) {
            if (nums[index] != index + 1) {//
                ans.add(index + 1);//+1 because index starts from 0
            }
        }
        return ans;//
    }

    static void swap(int[] num, int first, int second) {
        int temp = num[first];
        num[first] = num[second];
        num[second] = temp;
    }
}
//Time Complexity: O(n)
//Space Complexity: O(1)
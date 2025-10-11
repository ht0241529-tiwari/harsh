/* Symple sort the array with the help of cyclic sort algorithm
 // ✅ Use cyclic sort when array contains numbers from 1 to N with no duplicates
// ✅ It's efficient: O(n) time, O(1) space — perfect for interview prep
import java.util.Arrays;

public class cyclesort {
    public static void main(String[] args) {
        int arr[] = {3, 5, 2, 1, 4}; // 🎯 Unsorted array with values from 1 to N
        cyclicsort(arr);            // 🚀 Sort using cyclic sort
        System.out.println(Arrays.toString(arr)); // 📤 Output: [1, 2, 3, 4, 5]
    }

    static void cyclicsort(int[] arr) {
        int i = 0; // 🔁 Start from index 0        while (i < arr.length) {
            int correct = arr[i] - 1; // 🎯 Target index for current value
            // 🔄 If current value is not at its correct position, swap it
            if (arr[i] != arr[correct]) {
                swapfunction(arr, i, correct); // 🔁 Place value at correct index
            } else {
                i++; // ✅ Move to next index only when current is correctly placed
            }
        }
    }

    // 🔧 Swap helper function
    static void swapfunction(int[] arr, int first, int second) {
        int temp = arr[first];     // 🧪 Store first value
        arr[first] = arr[second];  // 📥 Assign second value to first index
        arr[second] = temp;        // 📤 Put stored value into second index
    }
} */



//Question missing number
// public class cyclesort {
//     public static void main(String[] args) {
//         int arr[] = {3, 0, 1};
//          int ans= missingNumber(arr);
//         System.out.println("The Missing Number is: "+ans);
//     }

//     static int missingNumber(int arr[]) {
//         int i = 0;
//         while (i < arr.length) {
//             int correct = arr[i];
//             if (arr[i] < arr.length && arr[i] != arr[correct]) {
//                 swap(arr, i, correct);
//             } else {
//                 i++;
//             }
//         }

//         // Now check for the missing number after sorting
//         for (int index = 0; index < arr.length; index++) {
//             if (arr[index] != index) {
//                 return index;
//             }
//         }

//         return arr.length;
//     }

//     static void swap(int arr[], int f, int s) {
//         int temp = arr[f];
//         arr[f] = arr[s];
//         arr[s] = temp;
//     }
// }


//Question find the Missing number if more t
import java.util.ArrayList;
import java.util.List;

public class find_all_dublicates_number_by_cyclicsort {

    public static void main(String[] args) {
        int arr[] = {4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> ans = findDuplicates(arr);
        System.out.println(ans);  // Should print [2, 3]
    }

    static void swap(int arr[], int f, int s) {
        int temp = arr[f];
        arr[f] = arr[s];
        arr[s] = temp;
    }

    public static List<Integer> findDuplicates(int arr[]) {
        List<Integer> ans = new ArrayList<>();
        int i = 0;

        // Cyclic sort: place each number at its correct index
        while (i < arr.length) {
            int correct = arr[i] - 1;
            if (arr[i] != arr[correct]) {
                swap(arr, i, correct);
            } else {
                i++;
            }
        }

        // After sorting, duplicates will be at wrong positions
        for (int index = 0; index < arr.length; index++) {
            if (arr[index] != index + 1) {
                ans.add(arr[index]); // Add the duplicate value, not index
            }
        }

        return ans;
    }
}
//this is using the array list to find the missing and duplicate number in the array
import java.util.ArrayList;
import java.util.List;

public class Set_Missmatch {
    public static void main(String[] args) {
        int arr[]={3,2,2,4};
        List<Integer> missmatch=findmissmatch(arr);
        System.out.println(missmatch);
    }
    static void swap(int arr[],int first,int second){
        int temp=arr[first];
        arr[first]=arr[second];
        arr[second]=temp;
    }
   public static List<Integer> findmissmatch(int arr[]){
List<Integer> ans=new ArrayList<>();
int i=0;
while(i<arr.length){
    int correct=arr[i]-1;
    if(arr[i]!=arr[correct]){
        swap(arr, i, correct);
    }
    else{
        i++;
    }
}
for(int index=0;index<arr.length;index++){
    if(arr[index]!=index+1){
        ans.add(arr[index]);//duplicate
        ans.add(index+1);//missing number
    }
}
return ans;
}}
//this is another approach without using the array list
// import java.util.*;

// public class Solution {
//     public int[] findErrorNums(int[] nums) {
//         int i = 0;
//         while (i < nums.length) {
//             int correct = nums[i] - 1;
//             if (nums[i] != nums[correct]) {
//                 int temp = nums[i];
//                 nums[i] = nums[correct];
//                 nums[correct] = temp;
//             } else {
//                 i++;
//             }
//         }

//         for (int index = 0; index < nums.length; index++) {
//             if (nums[index] != index + 1) {
//                 return new int[]{nums[index], index + 1};
//             }
//         }
//         return new int[]{-1, -1}; // fallback
//     }
// }

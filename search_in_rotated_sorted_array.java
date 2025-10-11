//but this will not contain dublicate value
public class search_in_rotated_sorted_array {
        public static void main(String[] args) {
                int []arr={4,5,6,7,0,1,2,3};
                int target=1;
              //  int ans =findpivot(arr);

                int ans=search(arr, target);
                System.out.println(ans);
    }
    static int search(int []arr,int target){
        int pivot=findpivot(arr);
        int leftsearch=binary_search(arr, target, 0, pivot);
        if(leftsearch!=-1){
            return leftsearch;
        }
        return binary_search(arr, target, pivot+1, arr.length-1);
    }
    static int findpivot(int []arr){
    int start=0;
    int end=arr.length-1;
    
    while(start<=end){
    int mid=start+(end-start)/2;
    //case 1
   if(mid<end && arr[mid]>arr[mid+1]){
      return mid;
   }
   //case 2
    if(mid>start && arr[mid]<arr[mid-1]){
    return mid-1;
   }
   //case 3
    if(arr[mid]<=arr[start]){
     end=mid-1;
    }
    //case 4
    else{
        start=mid+1;
    }
    }
    return -1;
}
   static int binary_search(int []arr,int target,int start,int end){
    while(start<=end){
        int mid=start+(end-start)/2;
        if(arr[mid]==target){
            return mid;
        }
        if(arr[mid]>target){
            end=mid-1;
        }
        else{
            start=mid+1;
        }
    }
    return -1;
    
   }
}
/*four case explanation 
Case 1: arr[mid] > arr[mid + 1]
Purpose: Detects the drop point directly—pivot is at mid.
Example:
Array: {4, 5, 6, 7, 0, 1, 2, 3}
- mid = 3, arr[mid] = 7, arr[mid + 1] = 0
- Since 7 > 0, pivot is at index 3.

Why needed: This is the most direct way to spot the rotation point.

 Case 2: arr[mid] < arr[mid - 1]
Purpose: Detects the drop point from the other side—pivot is at mid - 1.
Example:
Array: {6, 7, 0, 1, 2}
- mid = 2, arr[mid] = 0, arr[mid - 1] = 7
- Since 0 < 7, pivot is at index 1.

Why needed: Handles cases where the drop is detected from the left side of mid
Case 3: if (arr[mid] <= arr[start]) → end = mid - 1
🧠 Logic:
Agar arr[mid] chhota ya barabar hai arr[start] ke, iska matlab pivot left side mein ho sakta hai.
🔍 Example:
arr = {6, 7, 0, 1, 2}
start = 0 → arr[start] = 6
mid = 2 → arr[mid] = 0


- 0 <= 6 → true
- So pivot must be on the left side of mid
- We do: end = mid - 1 → search space becomes {6, 7}

✅ Why Needed:
Yeh condition tab kaam karti hai jab mid ke baad ka part sorted hai, aur pivot uske pehle chhupa hua hai.

🔁 Case 4: else → start = mid + 1
🧠 Logic:
Agar arr[mid] > arr[start], iska matlab left half sorted hai, toh pivot right side mein ho sakta hai.
🔍 Example:
arr = {4, 5, 6, 7, 0, 1, 2}
start = 0 → arr[start] = 4
mid = 2 → arr[mid] = 6


- 6 > 4 → true
- So pivot must be on the right side of mid
- We do: start = mid + 1 → search space becomes {7, 0, 1, 2}

✅ Why Needed:
Yeh condition tab kaam karti hai jab left half sorted hai, aur pivot abhi tak right mein chhupa hua hai

 */

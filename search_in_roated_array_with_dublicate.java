public class search_in_roated_array_with_dublicate {
    public static void main(String[] args) {
        int []arr={2,2,6,7,0,1,2,2};
                int target=0;
              //  int ans =findpivot(arr);

                int ans=search(arr, target);
                System.out.println(ans);

                    }
    static int search(int []arr,int target){
        int pivot=findpivotindublicate(arr);
        int leftsearch=binary_search(arr, target, 0, pivot);
        if(leftsearch!=-1){
            return leftsearch;
        }
        return binary_search(arr, target, pivot+1, arr.length-1);
    }
    static int findpivotindublicate(int []arr){
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
  //if element at start,end and mid are equal then skip the dublicate
  if(arr[mid]==arr[start] && arr[mid]==arr[end]){
    //skip the dublicate
    //what if these element at start and end were the pivot??
    //check start is pivot
    if(arr[start]>arr[start+1]){
        return start;
    }
    start++;
    if(arr[end]<arr[end-1]){
        return end-1;
    }
    end--;
  }
  //left side is sorted,so pivot shhould be in right
  else if(arr[start]<arr[mid] || (arr[start]==arr[mid] && arr[mid]>arr[end])){
     start=mid+1;
  }
  else{
    end=mid-1;
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

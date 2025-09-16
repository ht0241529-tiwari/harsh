public class rotation_count {
    public static void main(String[] args) {
        //for non dublicate
        //int []arr={4,5,6,7,0,1,2,3};
        //for dublicate arrray
          int []arr={2,2,6,7,0,1,2,2};
        int ans=rotationcount(arr);
        System.out.println(ans);
    }
    static int rotationcount(int []arr){
        //int pivot=findpivot(arr);
          int pivot=findpivotindublicate(arr);
        return pivot+1;
    }
    //for non dublicate
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
    //for dublicate
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
}

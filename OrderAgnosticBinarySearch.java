import java.util.Arrays;

public class OrderAgnosticBinarySearch {
    public static void main(String[] args) {
 //  int [] arr={1,2,3,4,5,6};//asc array
  int [] arr={9,7,6,5,4,2,1};//dsc array
   int target=9;
        int ans=oabs(arr, target);
        System.out.println(ans);        
    }
    static int oabs(int [] arr,int target){
        int start=0;
        int end=arr.length-1;
        boolean isasc=arr[start]<arr[end];
        while(start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid]==target){
                return mid;
            }
            if(isasc){
                if(arr[mid]>target){
                    end=mid-1;
                }
                else{
                    start=mid+1;
                }
            }
            else{
                if(arr[mid]<target){
                    end=mid-1;
                }
                else{
                    start=mid+1;
                }
            }
        }
        return -1;
    }
}

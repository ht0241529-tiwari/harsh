public class find_in_mountain_array {
    public static void main(String[] args) {
        int [] arr={1,3,5,3,2,0};
        int target=3;
        int ans=search(arr,target);
        System.out.println(ans);
    }
    static int search(int arr[],int target){
     int peak =PeakElement(arr);
     int firstTry=oabs(arr,target,0,peak);
     if(firstTry!=-1){
        return firstTry;
     }
     return oabs(arr,target,peak,arr.length-1);
    }
    static int PeakElement(int []arr){
        int start=0;
        int end=arr.length-1;
        while(start<end){
            int mid=start+(end-start)/2;
            if(arr[mid]>arr[mid+1]){
                end=mid;
            }
            else{
                start=mid+1;
            }
        }
        return start;
    }
static int oabs(int [] arr,int target,int start,int end){
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

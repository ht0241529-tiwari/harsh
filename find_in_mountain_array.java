public class find_in_mountain_array {
    public static void main(String[] args) {
        int [] arr={1,3,5,3,2,0};
     int ans =PeakElement(arr);
     System.out.println(ans);

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

}

//question:floor number
//floor number=largest element in array smaller or equal to target called as floor number
public class floor_number {
    public static void main(String[] args) {
            int arr[]={2,4,6,88,99,110};
            int target=87;
        System.out.println(floornumber(arr,target));
    }
    static int floornumber(int [] arr,int target){
        int start=0;
        int end=arr.length-1;
        int result=-1;
        while(start<=end){
        int mid=start+(end-start)/2;
        if(arr[mid]==target){
            return arr[mid];
        }
        if(arr[mid]>target){
            end=mid-1;
        }
        else{
            result=arr[mid];
            start=mid+1;
        }
        }
        return result;
    }
}

public class FIRST_MISSING_POSITION {
    public static void main(String[] args) {
        int arr[]={1,2,0};
        int ans=firstmissingposition(arr);
        System.out.println(ans);
    }
    public static void swap(int[] arr,int f,int s ){
    int temp=arr[f];
    arr[f]=arr[s];
    arr[s]=temp;
    }
    public static int firstmissingposition(int[] arr){
    int i=0;
    while (i<arr.length) {
        int correct=arr[i]-1;
        if(arr[i]>0 && arr[i]<=arr.length && arr[i]!=arr[correct]){
            swap(arr, i, correct);
        }
        else{
            i++;
        }
    }
    for(int j=0;j<arr.length;j++){
        if(arr[j]!=j+1){
            return j+1;
        }
    }
    return arr.length+1;
}
}
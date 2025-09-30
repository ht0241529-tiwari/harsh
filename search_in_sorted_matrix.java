import java.util.Arrays;
public class search_in_sorted_matrix {
    public static void main(String[] args) {
        int [][] matrix={{1,2,3,4,5},
                          {6,7,8,9,10},
                          {11,12,13,14,15},
                          {16,17,18,19,20}};
        int target=7;
        int [] ans=search(matrix,target);
        System.out.println(Arrays.toString(ans));

    }
    static int[] search (int[][] matrix,int target){
      int row=matrix.length;
      int col=matrix[0].length;//be cautious matrix can be empty
        if(row==1){  
            return binarysearch(matrix,0,0,col-1,target);
        }
      int rstart=0;
      int rend=row-1;
      int cmid=col/2;
      //run the loop till 2 rows are remaining
      while(rstart<rend-1){//while this is true it will have more than 2 rows
        int mid=rstart+(rend-rstart)/2;
        if(matrix[mid][cmid]==target){
            return new int[]{mid,cmid};     
    }
    if(matrix[mid][cmid]<target){
        rstart=mid;
    }
    else{
        rend=mid;
    }
      }
      //now we have 2 rows
      //check whether the target is in the col of 2 rows
      if(matrix[rstart][cmid]==target){
        return new int[]{rstart,cmid};
      }
      if(matrix[rstart+1][cmid]==target){
        return new int[]{rstart+1,cmid};
      }
      //search in 1st half
      if(target<=matrix[rstart][cmid-1]){
        return binarysearch(matrix,rstart,0,cmid-1,target);
      }
      //search in 2nd half
      if(target>=matrix[rstart][cmid+1] && target<=matrix[rstart][col-1]){
        return binarysearch(matrix,rstart,cmid+1,col-1,target);
      }
      //search in 3rd half
      if(target<=matrix[rstart+1][cmid-1]){
        return binarysearch(matrix,rstart+1,0,cmid-1,target);
      }
      else{
        return binarysearch(matrix,rstart+1,cmid+1,col-1,target);
      }
}
static int[] binarysearch(int[][] matrix,int row,int colstart,int colend,int target){
    while(colstart<=colend){
        int mid=colstart+(colend-colstart)/2;
        if(matrix[row][mid]==target){
            return new int[]{row,mid};
        }
        if(matrix[row][mid]<target){
            colstart=mid+1;
        }
        else{
            colend=mid-1;
        }
    }
    return new int[]{-1,-1};
}
}
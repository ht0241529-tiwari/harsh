// in the normal order we insert the value at end and remove from the front
//but in the reverse order we insert the value at the front and remove from the end
public class question4{
    public static void main(String[] args){

    }
    public List<List<Integer>> zigzaglevelorder(TreeNode root){
        if(root==null){
            return new ArrayList<>();
        }
        List<List<Integer>> result=new ArrayList<>();
        Deque<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        boolean reverse=false;
        while(!queue.isEmpty()){
            int currentlevel=queue.size();
           List<Integer> currentlist=new ArrayList<>(currentlevel);
           for(int i=0;i<currentlevel;i++){
            if(!reverse){
                TreeNode currentnode=queue.pollFirst();
                currentlist.add(currentnode.val);
                if(currentnode.left!=null){
                    queue.offerLast(currentnode.left);
                }
                if(currentnode.right!=null){
                    queue.offerLast(currentnode.right);
                }
            }
            else{
                TreeNode currentnode=queue.pollLast();
                currentlist.add(currentnode.val);
                if(currentnode.right!=null){//we take first right because we are inserting at the front and we want to maintain the order of left and right
                    queue.offerFirst(currentnode.right);
                }
                if(currentnode.left!=null){
                    queue.offerFirst(currentnode.left);
                }
            }
           }
           reverse=!reverse;
           result.add(currentlist);
            }
            return result;
        }

    }
    Initial Tree:   3
                  /   \
                 9     20
                     /  \
                    15   7

Level 1 (RTL processing):
Queue before: [9, 20]
1. Process 20 (pollLast)
   currentList = [20]
   right=7, left=15
   queue.offerFirst(7.right→null) 
   queue.offerFirst(15.left→null) 
   queue = [9, 15, 7] ❌ WRONG!

2. CORRECT ORDER:
   queue.offerFirst(7)  → queue = [9, 7]
   queue.offerFirst(15) → queue = [9, 15, 7] → [15, 7, 9]

Next Level processes pollLast: 9, 7, 15 ✅ Output: [20, 9], [15, 7]




Why Right-First is MUST:

WRONG ORDER (left first):
curr.right=7: offerFirst(7) → queue front: [7, ...]
curr.left=15: offerFirst(15)→ queue front: [15, 7, ...] ❌

CORRECT ORDER (right first):
curr.right=7: offerFirst(7) → queue front: [7, ...] 
curr.left=15: offerFirst(15)→ queue front: [15, 7, ...] ✅

















// public class question4{
//     public static void main(String[] args){

//     }
//     public List<List<Integer>> zigzaglevelorder(TreeNode root){
//         if(root==null){
//             return new ArrayList<>();
//         }
//         List<List<Integer>> result=new ArrayList<>();
//         Queue<TreeNode> queue=new LinkedList<>();
//         queue.offer(root);
        
//         while(!queue.isEmpty()){
//             int currentlevel=queue.size();
//             List<Integer> currentlist=new ArrayList<>();
//             for(int i=0;i<currentlevel;i++){
//                 TreeNode currentnode=queue.poll();
//                 currentlist.add(currentnode.val);
//                 if(currentnode.left!=null){
//                     queue.offer(currentnode.left);
//                 }
//                 if(currentnode.right!=null){
//                     queue.offer(currentnode.right);
//                 }
//             }

//            if(currentlevel%2==1){
//             Collections.reverse(currentlist);
//            }
//            result.add(currentlist);
//         }
//         return result;
//             }
// }
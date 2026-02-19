public class Question1 {
    public static void main(String[] args){

    }
    public List<List<Integer>> levelorder(TreeNode root){
        List<List<Integer>> result=new ArrayList<>();

        if(root==null){
            return result;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int levelsize=queue.size();
            List<Integer> currentlevel=new ArrayList<>(levelsize);
            for(int i=0;i<levelsize;i++){
                TreeNode currentnode=queue.poll();
                currentlevel.add(currentnode.val);
                if(currentnode.left!=null){
                    queue.offer(currentnode.left);
                }
                if(currentnode.right!=null){
                    queue.offer(currentnode.right);
                }
            }
            result.add(currentlevel);
        }
        return result;
    }
}


//this code is help to understand the level order traversal of a binary tree. It uses a queue to keep track of the nodes at each level and processes them one by one. The result is a list of lists, where each inner list contains the values of the nodes at that particular level.
// //import java.util.*;

// // TreeNode class - Tree ka basic building block
// class TreeNode {
//     int val;
//     TreeNode left;
//     TreeNode right;
    
//     TreeNode(int val) {
//         this.val = val;
//     }
// }

// public class Question1 {
    
//     // Ye main level order function hai
//     public List<List<Integer>> levelorder(TreeNode root) {
//         List<List<Integer>> result = new ArrayList<>();
        
//         if(root == null) {
//             return result;
//         }
        
//         Queue<TreeNode> queue = new LinkedList<>();
//         queue.offer(root);
        
//         while(!queue.isEmpty()) {
//             int levelsize = queue.size();  // Current level ke nodes count
//             List<Integer> currentlevel = new ArrayList<>(levelsize);
            
//             for(int i = 0; i < levelsize; i++) {
//                 TreeNode currentnode = queue.poll();
//                 currentlevel.add(currentnode.val);
                
//                 if(currentnode.left != null) {
//                     queue.offer(currentnode.left);
//                 }
//                 if(currentnode.right != null) {
//                     queue.offer(currentnode.right);
//                 }
//             }
//             result.add(currentlevel);  // ← Ye line missing thi!
//         }
//         return result;
//     }
    
//     // Tree banane ka helper function
//     TreeNode buildTree() {
//         TreeNode root = new TreeNode(1);
//         root.left = new TreeNode(2);
//         root.right = new TreeNode(3);
        
//         root.left.left = new TreeNode(4);
//         root.left.right = new TreeNode(5);
//         root.right.left = new TreeNode(6);
//         root.right.right = new TreeNode(7);
        
//         // Level 3 ke nodes (image jaisa)
//         root.left.left.left = new TreeNode(8);
//         root.left.left.right = new TreeNode(9);
//         root.left.right.left = new TreeNode(10);
        
//         return root;
//     }
    
//     public static void main(String[] args) {
//         Question1 obj = new Question1();
        
//         // Image wala tree banao
//         TreeNode root = obj.buildTree();
        
//         // Level order traversal call karo
//         List<List<Integer>> answer = obj.levelorder(root);
        
//         // Result print karo
//         System.out.println("Level Order Traversal:");
//         for(List<Integer> level : answer) {
//             System.out.println(level);
//         }
//     }
// }

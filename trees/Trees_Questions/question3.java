public class question3 {
    public static void main(String[] args){

    }
    public TreeNode levelorder(TreeNode root){
      int target=14;
        if(root==null){
            return null;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
                int levelsize=queue.size();
         
                TreeNode currentnode=queue.poll();
                if(currentnode.left!=null){
                    queue.offer(currentnode.left);
                }
                if(currentnode.right!=null){
                    queue.offer(currentnode.right);
                }
                if(target==currentnode.val){
                    if(!queue.isEmpty()){
                        return queue.peek();
                    }
                    else{
                        return null;
                    }
            }
        }
        return null;
    }
}
//level order successor problem in this we have to find the level order successor of a given node in a binary tree. The level order 
//successor of a node is the node that appears immediately after the given node in the level order 
//traversal of the tree. If the given node is the last node in the level order traversal, then there is no successor, and we can return null.
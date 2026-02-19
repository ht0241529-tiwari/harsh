//averagelevel of the levels of a binary tree
public class question2{
     public List<Double> levelorder(TreeNode root){
        List<Double> result=new ArrayList<>();

        if(root==null){
            return result;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int levelsize=queue.size();
            double averagelevel=0;
            for(int i=0;i<levelsize;i++){
                TreeNode currentnode=queue.poll();
                averagelevel+=currentnode.val
                if(currentnode.left!=null){
                    queue.offer(currentnode.left);
                }
                if(currentnode.right!=null){
                    queue.offer(currentnode.right);
                }
            }
                averagelevel=averagelevel/levelsize;
            result.add(averagelevel);
        }
        return result;
    }
}
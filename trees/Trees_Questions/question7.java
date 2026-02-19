public class Solution {
    public List<Integer> rightSideView(TreeNode root) {  // LeetCode signature
        if(root == null) {
            return new ArrayList<>();  // ✅ ArrayList (capital L)
        }
        
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while(!queue.isEmpty()) {  // ✅ while loop bahar
            int levelSize = queue.size();  // ✅ Har level ke liye fresh size
            for(int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                if(i == levelSize - 1) {  // ✅ Last node = rightmost
                    result.add(currentNode.val);
                }
                if(currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if(currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
        }
        return result;
    }
}

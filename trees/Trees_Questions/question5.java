//instead of using the collections.reverse() methody you can add the currentList at the beginning of the result list to avoid reversing at the end. Here's how you can do it:
//means at every time new list is added at the beginning of the result list, so that at the end we get the bottom-up order without needing to reverse the list.
public class question5 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int levelsize = queue.size();  // Har level pe update
            List<Integer> currentList = new ArrayList<>(levelsize);
            for (int i = 0; i < levelsize; i++) {  // levelsize use kiya
                TreeNode currentNode = queue.poll();
                currentList.add(currentNode.val);
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
            result.add(0, currentList);  // Add at the beginning to get bottom-up order
        }
        // Collections.reverse(result);  // End mein reverse ya method inefficient hai
        return result;
    }
}

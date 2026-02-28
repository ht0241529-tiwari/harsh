public class question6{
    public Node nodenext(Node root){
        if(root==null){
            returrn null;
        }
        Node leftnode=root;
        while(leftnode.left!=null){
            Node current=leftnode;
            while(current!=null){
                if(current.left!=null){
                    current.left.next=current.right;
                }
                if(current.next!=null){
                    current.right.next=current.next.left;
                }
                current=current.next;
            }
            leftnode=leftnode.left;
        }
        return root;
    }
}

// import java.util.*;

// class Node {
//     public int val;
//     public Node left;
//     public Node right;
//     public Node next;
    
//     public Node() {}
    
//     public Node(int _val) {
//         val = _val;
//     }
    
//     public Node(int _val, Node _left, Node _right, Node _next) {
//         val = _val;
//         left = _left;
//         right = _right;
//         next = _next;
//     }
    
//     // Helper to print tree level by level with next pointers
//     @Override
//     public String toString() {
//         return "Node{" + val + '}';
//     }
// }

// class Solution {
//     public Node connect(Node root) {
//         if (root == null) return null;
        
//         Queue<Node> queue = new LinkedList<>();
//         queue.offer(root);
        
//         while (!queue.isEmpty()) {
//             int levelSize = queue.size();
//             Node prev = null;
            
//             for (int i = 0; i < levelSize; i++) {
//                 Node curr = queue.poll();
                
//                 if (prev != null) {
//                     prev.next = curr;
//                 }
//                 prev = curr;
                
//                 if (curr.left != null) queue.offer(curr.left);
//                 if (curr.right != null) queue.offer(curr.right);
//             }
//         }
//         return root;
//     }
    
//     // Helper to print the result
//     public void printTree(Node root) {
//         Node head = root;
//         while (head != null) {
//             Node curr = head;
//             while (curr != null) {
//                 System.out.print(curr.val);
//                 if (curr.next != null) {
//                     System.out.print(" -> ");
//                 }
//                 curr = curr.next;
//             }
//             System.out.println();
//             head = head.left; // Move to next level
//         }
//     }
// }

// public class Main {
//     public static void main(String[] args) {
//         Solution sol = new Solution();
        
//         // Test case 1: [1,2,3,4,5,6,7]
//         Node root = new Node(1);
//         root.left = new Node(2); 
//         root.right = new Node(3);
//         root.left.left = new Node(4); 
//         root.left.right = new Node(5);
//         root.right.left = new Node(6); 
//         root.right.right = new Node(7);
        
//         System.out.println("Before connect:");
//         sol.printTree(root);
        
//         root = sol.connect(root);
        
//         System.out.println("After connect:");
//         sol.printTree(root);
//         // Output:
//         // 1
//         // 2 -> 3
//         // 4 -> 5 -> 6 -> 7
        
//         // Test case 2: Single node
//         System.out.println("\nTest case 2:");
//         Node root2 = new Node(0);
//         root2 = sol.connect(root2);
//         sol.printTree(root2); // Output: 0
        
//         System.out.println("All tests passed!");
//     }
// }

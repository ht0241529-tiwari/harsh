import java.util.*;

class AVL_Tree {
    private static class Node {
        int value;
        Node left;
        Node right;
        int height; 
        
        public Node(int value) {
            this.value = value;
            this.height = 1;
        }
    }
    
    private Node root;

    private int height(Node node) {
        return (node == null) ? 0 : node.height;
    }

    private Node rotateRight(Node parent){
        Node child = parent.left;
        Node childRight = child.right;
        
        parent.left = childRight;
        child.right = parent;
        
        parent.height = 1 + Math.max(height(parent.left), height(parent.right));
        child.height = 1 + Math.max(height(child.left), height(child.right));
        return child;
    }
    
    private Node rotateLeft(Node child){
        Node parent = child.right;
        Node parentLeft = parent.left;
        
        child.right = parentLeft;
        parent.left = child;
        
        parent.height = 1 + Math.max(height(parent.left), height(parent.right));
        child.height = 1 + Math.max(height(child.left), height(child.right));
        return parent;
    }
    
    private Node rotate(Node node){
        if(node == null) return node;
        
        // CRITICAL FIX: Update height BEFORE balance checks
        node.height = 1 + Math.max(height(node.left), height(node.right));
        
        int balance = height(node.left) - height(node.right);
        
        // Left Heavy
        if(balance > 1){
            if(height(node.left.left) >= height(node.left.right)){
                return rotateRight(node);  // LL
            } else {
                node.left = rotateLeft(node.left);
                return rotateRight(node);  // LR
            }
        }
        // Right Heavy  
        if(balance < -1){
            if(height(node.right.right) >= height(node.right.left)){
                return rotateLeft(node);   // RR
            } else {
                node.right = rotateRight(node.right);
                return rotateLeft(node);   // RL
            }
        }
        return node;
    }
    
    private Node insert(int value, Node node) {
        if(node == null) {
            return new Node(value);
        }
        
        if(value < node.value) {
            node.left = insert(value, node.left);
        } else if(value > node.value) {
            node.right = insert(value, node.right);
        }
        
        return rotate(node);  // Balance after insertion
    }
    
    public void insert(int value) {
        root = insert(value, root);
    }

    public void populate(Scanner scanner) {
        System.out.println("Enter root value:");
        root = new Node(scanner.nextInt());
        
        while(true) {
            System.out.println("Enter value to insert (-1 to stop):");
            int value = scanner.nextInt();
            if(value == -1) break;
            insert(value);
        }
    }

    public void display() {
        System.out.println("=== BINARY SEARCH TREE ===");
        displayTree(root, 0);
        System.out.println("=========================");
    }

    private void displayTree(Node node, int level) {
        if(node == null) return;
        
        displayTree(node.right, level + 1);
        String indent = "   ".repeat(level);
        System.out.println(indent + node.value);
        displayTree(node.left, level + 1);
    }
    
    public static void main(String[] args) {
        AVL_Tree avl = new AVL_Tree();
        Scanner sc = new Scanner(System.in);
        avl.populate(sc);
        avl.display();
        sc.close();
    }
}


//use below code onlly for the see the codn of rotations and height calculation in AVL tree, rest of the code is same as binary search tree
// import java.util.*;

// class AVL_Tree {
//     private static class Node {
//         int value;
//         Node left;
//         Node right;
//         int height;  // Added for height calculation
        
//         public Node(int value) {
//             this.value = value;
//             this.height = 1;  // New node height = 1
//         }
//     }
    
//     private Node root;

//     public AVL_Tree() {}

//     // FIXED: Proper recursive insert for AVL_Tree
//     public Node insert(int value, Node node) {
//         // Base case: empty subtree
//         if (node == null) {
//             return new Node(value);
//         }
        
//         // Recursive cases
//         if (value < node.value) {
//             node.left = insert(value, node.left);
//         } else if (value > node.value) {
//             node.right = insert(value, node.right);
//         }
//         // Duplicate values: ignore ya handle as per requirement
        
//         // Update height
//         node.height = 1 + Math.max(height(node.left), height(node.right));
//         return rotate(node);  // FIXED: Har level pe node return karna zaroori!
//     }
//     private Node rotate(Node node){
//         if(height(node.left)-height(node.right)>1){
//             //lleft heavy 
//             if(height(node.left.left)-height(node.left.right)>0){
//                 //left left case
//                return rotateRight(node);
//         }
//         if(height(node.left.left)-height(node.left.right)<0){
//             //left right case
//             node.left=rotateLeft(node.left);
//             return rotateRight(node);
//         }
//     }
//      if(height(node.left)-height(node.right)<-1){
//             //right heavy 
//             if(height(node.right.left)-height(node.right.right)<0){
//                 //right right case
//                return rotateLeft(node);
//         }
//         if(height(node.right.left)-height(node.right.right)>0){
//             //right left case
//             node.right=rotateRight(node.right);
//             return rotateLeft(node);
//         }
//     }
//      return node;
//     }
//     private Node rotateRight(Node parent){
//         Node child=parent.left;
//         Node childRight=child.right;
//         //rotation
//         child=parent.left;
//         childRight=parent.left;

//         //update heights
//         parent.height=1+Math.max(height(parent.left),height(parent.right));
//         child.height=1+Math.max(height(child.left),height(child.right));
//         return child;
//     }
//     private Node rotateLeft(Node child){
//         Node parent=child.right;
//         Node parentLeft=parent.left;
//         //rotation
//         child.right=parentLeft;
//         parent.left=child;

//         //update heights
//         parent.height=1+Math.max(height(parent.left),height(parent.right));
//         child.height=1+Math.max(height(child.left),height(child.right));
//         return parent;
//     }
//     // Public insert method - root se start
//     public void insert(int value) {
//         root = insert(value, root);
//     }

//     // Height helper method
//     private int height(Node node) {
//         if (node == null) {
//             return 0;
//         }
//         return node.height;
//     }

//     // Interactive populate method (same as before)
//     public void populate(Scanner scanner) {
//         System.out.println("Enter root value:");
//         int rootValue = scanner.nextInt();
//         root = new Node(rootValue);
        
//         while (true) {
//             System.out.println("Enter value to insert (-1 to stop):");
//             int value = scanner.nextInt();
//             if (value == -1) break;
//             insert(value);
//         }
//     }

//     // Hierarchical display (same working)
//     public void display() {
//         System.out.println("=== BINARY SEARCH TREE ===");
//         displayTree(root, 0);
//         System.out.println("=========================");
//     }

//     private void displayTree(Node node, int level) {
//         if (node == null) {
//             return;
//         }
//         displayTree(node.right, level + 1);
//         String indent = "   ".repeat(level);
//         System.out.println(indent + node.value);
//         displayTree(node.left, level + 1);
//     }
//     public static void main(String[] args) {
//         AVL_Tree avlTree = new AVL_Tree();
//         Scanner scanner = new Scanner(System.in);
//         avlTree.populate(scanner);
//         avlTree.display();
//         scanner.close();
//     }

//     }



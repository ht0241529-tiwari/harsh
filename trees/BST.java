import java.util.Scanner;

class BST {
    private static class Node {
        int value;
        Node left;
        Node right;
        int height;  // Added for height calculation
        
        public Node(int value) {
            this.value = value;
            this.height = 1;  // New node height = 1
        }
    }
    
    private Node root;

    public BST() {}

    // FIXED: Proper recursive insert for BST
    public Node insert(int value, Node node) {
        // Base case: empty subtree
        if (node == null) {
            return new Node(value);
        }
        
        // Recursive cases
        if (value < node.value) {
            node.left = insert(value, node.left);
        } else if (value > node.value) {
            node.right = insert(value, node.right);
        }
        // Duplicate values: ignore ya handle as per requirement
        
        // Update height
        node.height = 1 + Math.max(height(node.left), height(node.right));
        return node;  // FIXED: Har level pe node return karna zaroori!
    }

    // Public insert method - root se start
    public void insert(int value) {
        root = insert(value, root);
    }

    // Height helper method
    private int height(Node node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    // Interactive populate method (same as before)
    public void populate(Scanner scanner) {
        System.out.println("Enter root value:");
        int rootValue = scanner.nextInt();
        root = new Node(rootValue);
        
        while (true) {
            System.out.println("Enter value to insert (-1 to stop):");
            int value = scanner.nextInt();
            if (value == -1) break;
            insert(value);
        }
    }

    // Hierarchical display (same working)
    public void display() {
        System.out.println("=== BINARY SEARCH TREE ===");
        displayTree(root, 0);
        System.out.println("=========================");
    }

    private void displayTree(Node node, int level) {
        if (node == null) {
            return;
        }
        displayTree(node.right, level + 1);
        String indent = "   ".repeat(level);
        System.out.println(indent + node.value);
        displayTree(node.left, level + 1);
    }

    public static void main(String[] args) {
        BST tree = new BST();
        Scanner sc = new Scanner(System.in);
        tree.populate(sc);
        tree.display();
        sc.close();
    }
}

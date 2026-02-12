import java.util.Scanner;

class BinaryTree {
    private static class Node {
        int value;
        Node left;
        Node right;
        public Node(int value) {
            this.value = value;
        }
    }
    
    private Node root;

    public BinaryTree() {}

    public void populate(Scanner scanner) {
        System.out.println("Enter root value:");
        int rootValue = scanner.nextInt();
        root = new Node(rootValue);
        populate(scanner, root);
    }

    private void populate(Scanner scanner, Node node) {
        System.out.println("Do you want to enter left of " + node.value + "? (true/false)");
        boolean hasLeft = scanner.nextBoolean();
        if (hasLeft) {
            System.out.println("Enter the value of left of " + node.value);
            int value = scanner.nextInt();
            node.left = new Node(value);
            populate(scanner, node.left);
        }
        
        System.out.println("Do you want to enter right of " + node.value + "? (true/false)");
        boolean hasRight = scanner.nextBoolean();
        if (hasRight) {
            System.out.println("Enter the value of right of " + node.value);
            int value = scanner.nextInt();
            node.right = new Node(value);
            populate(scanner, node.right);
        }
    }

    // NEW HIERARCHICAL DISPLAY
    public void display() {
        System.out.println("=== BINARY TREE ===");
        displayTree(root, 0);
        System.out.println("===================");
    }

    private void displayTree(Node node, int level) {
        if (node == null) {
            return;
        }
        displayTree(node.right, level + 1);  // Right pehle (top)
        String indent = "   ".repeat(level);
        System.out.println(indent + node.value);
        displayTree(node.left, level + 1);   // Left neeche
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        Scanner sc = new Scanner(System.in);
        tree.populate(sc);
        tree.display();
        sc.close();
    }
}

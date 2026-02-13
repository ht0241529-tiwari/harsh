import java.util.Scanner;

public class Traversal_method {
    private static class Node {
        int value;
        Node left;
        Node right;
        int height;
        
        public Node(int value) {
            this.value = value;
            this.height = 1;  // semicolon missing tha!
        }
    }
    
    private Node root;
    
    // PREORDER: Root → Left → Right
    public void preorder() {
        System.out.print("Preorder: ");
        preorder(root);
        System.out.println();
    }
    
    private void preorder(Node node) {
        if (node == null) return;
        System.out.print(node.value + " ");
        preorder(node.left);
        preorder(node.right);
    }
    
    // POSTORDER: Left → Right → Root
    public void postorder() {
        System.out.print("Postorder: ");
        postorder(root);
        System.out.println();
    }
    
    private void postorder(Node node) {
        if (node == null) return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.value + " ");
    }
    
    // INORDER: Left → Root → Right (BST mein sorted order!)
    public void inorder() {
        System.out.print("Inorder: ");
        inorder(root);  // BUG1: postorder(root) tha!
        System.out.println();
    }
    
    private void inorder(Node node) {
        if (node == null) return;
        inorder(node.left);
        System.out.print(node.value + " ");
        inorder(node.right);
    }
    
    // Tree banane ke liye (test karne ke liye)
    public void insert(int value) {
        root = insertHelper(value, root);
    }
    
    private Node insertHelper(int value, Node node) {
        if (node == null) return new Node(value);
        if (value < node.value)
            node.left = insertHelper(value, node.left);
        else if (value > node.value)
            node.right = insertHelper(value, node.right);
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        return node;
    }
    
    private int getHeight(Node node) {
        return node == null ? 0 : node.height;
    }
    
    public static void main(String[] args) {
        Traversal_method tree = new Traversal_method();
        
        // Sample BST banao: 50,30,70,20
        tree.insert(50);
        tree.insert(30);
        tree.insert(70);
        tree.insert(20);
        
        tree.preorder();  // 50 30 20 70
        tree.inorder();   // 20 30 50 70 (sorted!)
        tree.postorder(); // 20 30 70 50
    }
}
// | Traversal | Order           | BST Output  | Real Use Case    |
// | --------- | --------------- | ----------- | ---------------- |
// | Preorder  | Root-Left-Right | 50 30 20 70 | Copy Directory   |
// | Inorder   | Left-Root-Right | 20 30 50 70 | Sorted Print     |
// | Postorder | Left-Right-Root | 20 30 70 50 | Delete Directory |
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
public class SegmentTree {

    public static void main(String[] args) {
        int[] arr = {3, 8, 6, 7, -2, -8, 4, 9};
        SegmentTree st = new SegmentTree(arr);
        // st.display();   // fixed variable name
        
        System.out.println("Sum of range [1,3] = " + st.query(1, 3));
        st.update(2, 10);
        System.out.println("After updating index 2 to 10:");
        st.display();
    }

    private static class Node {
        int data;
        int startinterval;
        int endinterval;
        Node left;
        Node right;

        public Node(int start, int end) {
            this.startinterval = start;
            this.endinterval = end;
        }
    }

    Node root;

    public SegmentTree(int[] arr) {
        // create a tree using this array
        this.root = build(arr, 0, arr.length - 1);
    }

    private Node build(int[] arr, int start, int end) {
        if (start == end) {
            // leaf node
            Node leaf = new Node(start, end);
            leaf.data = arr[start];
            return leaf;
        }

        // create new node with index you are at
        Node node = new Node(start, end);
        int mid = (start + end) / 2;
        node.left = this.build(arr, start, mid);
        node.right = this.build(arr, mid + 1, end);
        node.data = node.left.data + node.right.data;
        return node;
    }

    public void display() {
        display(this.root);
    }

    private void display(Node node) {
        String str = "";

        if (node.left != null) {
            str = str + "Interval=[" + node.left.startinterval + "-" + node.left.endinterval + "] data=" + node.left.data + " => ";
        } else {
            str = str + "no left child => ";
        }

        // current node
        str = str + "Interval=[" + node.startinterval + "-" + node.endinterval + "] data=" + node.data;

        if (node.right != null) {
            str = str + " <= Interval=[" + node.right.startinterval + "-" + node.right.endinterval + "] data=" + node.right.data;
        } else {
            str = str + " <= no right child";
        }

        System.out.println(str + "\n");   // fixed System.out

        // recursion
        if (node.left != null) {
            display(node.left);
        }
        if (node.right != null) {
            display(node.right);
        }
    }

    // query
    public int query(int qstart, int qend) {
        return this.query(this.root, qstart, qend);
    }

    private int query(Node node, int qstart, int qend) {
        // completely outside
        if (node.endinterval < qstart || node.startinterval > qend) {
            return 0;
        }
        // completely inside
        else if (node.startinterval >= qstart && node.endinterval <= qend) {
            return node.data;
        }
        // partially inside
        else {
            int leftans = query(node.left, qstart, qend);
            int rightans = query(node.right, qstart, qend);
            return leftans + rightans;
        }
    }

    // update
    public void update(int index, int value) {
        this.update(this.root, index, value);
    }

    private int update(Node node, int index, int value) {
        if (index >= node.startinterval && index <= node.endinterval) {

            // leaf node
            if (node.startinterval == node.endinterval) {
                node.data = value;
                return node.data;
            } 
            else {
                // internal node
                int leftans = update(node.left, index, value);
                int rightans = update(node.right, index, value);

                node.data = leftans + rightans;
                return node.data;
            }
        }

        // outside interval
        return node.data;
    }
}






















// public class SegmentTree{
//     public static void main(String[] args){
//         int [] arr={3,8,6,7,-2,-8,4,9};
//         SegmentTree st=new SegmentTree(arr);
//         tree.display();
//     }
//     private static class Node{
//         int data;
//         int startinterval;
//         int endinterval;
//         Node left;
//         Node right;

//          public Node(int start, int end){
//         this.startinterval = start;
//         this.endinterval = end;
//      }
//     }

//     Node root;

//     public SegmentTree(int[] arr){
//         //create a tree using this array
//         this.root = build(arr, 0, arr.length - 1);
//     }

//     private Node build(int []arr,int start,int end){
//         if(start==end){
//             //leaf node
//             Node leaf = new Node(start, end);
//             leaf.data = arr[start];
//             return leaf;
//         }
        
//         //create new node with index you are at
//         Node node=new Node(start,end);
//         int mid=(start+end)/2;
//         node.left=this.build(arr,start,mid);
//         node.right=this.build(arr,mid+1,end);
//         node.data=node.left.data+node.right.data;
//         return node;
//     }

//     public void display(){
//         display(this.root);
//     }
//     private void display(Node node){
//         String str="";
//         if(node.left!=null){
//             str=str+"Interval=["+node.left.startinterval+"+"+node.left.endinterval+"] data="+node.left.data+"=>";
//         }
//         else{
//             str=str+"no left child";
//         }

//         //for current node
//         str=str+"Interval=["+node.startinterval+"-"+node.endinterval+"] data="+node.data;
//         if(node.right!=null){
//             str=str+"<=Interval=["+node.right.startinterval+"-"+node.right.endinterval+"] data="+node.right.data;
//         }
//         else{
//             str=str+" no right child";
//         }

//         system.out.println(str+"\n");

//         //call recusrion
//         if(node.left!=null){
//             display(node.left);
//         }
//         if(node.right!=null){
//             display(node.right);
//         }
//     }

//     //query
//     public int query(int qstart,int qend){
//         return this.query(this.root,qstart,qend);
//     }
//     private int query(Node node,int qstart,int qend){
//         //completely outside
//         if(node.endinterval<qstart || node.startinterval>qend){
//             return 0;
//         }
//         // node is completely inside the query interval
//         else if(node.startinterval>=qstart && node.endinterval<=qend){
//             return node.data;
//         }
//         //partially inside and partially outside
//         else{
//             int leftans=query(node.left,qstart,qend);
//             int rightans=query(node.right,qstart,qend);
//             return leftans+rightans;
//         }
//     }

//     //update
//     public void update(int index,int value){
//         this.update(this.root,index,value);
//         }
//     private void update(Node node,int index,int value){
//        if(index>=node.startinterval && index<=node.endinterval){
//         //leaf node
//         if(node.startinterval==node.endinterval){
//             node.data=value;
//             return node.data;
//         }
//        else{
//         //internal node
//        int leftans=update(node.left,index,value);
//         int rightans=update(node.right,index,value);

//         node.data=leftans+rightans;
//         return node.data;
//        }
//      }
//        return node.data;//outside the interval


   
// }
package binarytree;

/*
*
* Youtube Tutorial from Tushar Roy
*
* There are 3 kinds of traversal in Binary Tree
*
*   Pre-Order: V - L - R
*   Print the Root node first, then print everything on the Left side and then print everything on the Right side.
*   This should be done recursively for every node.
*
*
*   In-Order: L - V - R
*   Print everything on the Left side first, then print the Root Node and then print everything on the Right side.
*   This should be done recursively for every node.
*
*   Post Order: L - R - V
*   Print everything on the Left first, then print everything on the right and then finally print the root node.
*   This should be done recursively on every node.
*
*   V - Visit the root node
*   L - Left node
*   R - Right Node
*
*   Time Complexity for all three traversals is O(N)
*
*   N - is the number of items in the call stack.
*
*
* */

public class DFSRecursive {

    public static class Node {

        private Node left;
        private Node right;
        private int data;

        public Node() {

        }

        public Node(Node left, Node right, int data){
            this.left = left;
            this.right = right;
            this.data = data;
        }
    }

    /*
    *
    * Pre-Order Traversal
    * V - L - R
    *
    * */
    public void preOrder(Node node){
        if(node != null){
            System.out.print(node.data + ", ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    /*
    *
    * In Order Traversal
    *
    * L - V - R
    *
    * */

    public void inOrderTraversal(Node node){
        if(node != null){
            inOrderTraversal(node.left);
            System.out.print(node.data + ", ");
            inOrderTraversal(node.right);

        }
    }

    /*
    *
    * Post Order Traversal
    *
    * L - R - V
    *
    * */

    public void postOrderTraversal(Node node){
        if(node != null){
            postOrderTraversal(node.left);
            postOrderTraversal(node.right);
            System.out.print(node.data + ", ");

        }
    }

    /*
    * Search in Binary Search Tree
    *
    * A Binary Search Tree is a Binary Tree, where the left node data is less than the right node. This is true recursively for all child nodes.
    *
    * */

    public Node searchBST(Node node, int key){
        if(node != null){
            if(node.data == key){
                return node;
            } else if(key < node.data){
                return searchBST(node.left, key);
            } else {
                return searchBST(node.right, key);
            }
        }
        return null;
    }


    /*
    *
    * Check if the Binary Search tree is Valid
    *
    * A Binary Search Tree is a Binary Tree, where the left node data is less than the right node. This is true recursively for all child nodes.
    *
    * */

    public boolean isBST(Node node){
        return isValidBST(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean isValidBST(Node node, int min, int max){

        if(node == null){
            return true;
        }

        if(node.data < min || node.data > max){
            return false;
        }

        if(node != null) {
            boolean leftNodeCheck = isValidBST(node.left, min, node.data - 1);
            boolean rightNodeCheck = isValidBST(node.right, node.data + 1, max);
            return leftNodeCheck && rightNodeCheck;
        }

        return false;
    }

    public static void main(String[] args){

        DFSRecursive dfsRecursive = new DFSRecursive();

        // Binary Tree Creation
        Node root = new Node();
        root.data = 10;
        root.left = new Node();
        root.left.data = 2;

        root.left.left = new Node();
        root.left.left.data = 6;

        root.right = new Node();
        root.right.data = 5;

        root.right.left = new Node();
        root.right.left.data = 8;

        root.right.right = new Node();
        root.right.right.data = 3;


        System.out.println("Pre Order Recursive Traversal\n");
        dfsRecursive.preOrder(root);
        System.out.println("\n");

        System.out.println("In Order Recursive Traversal\n");
        dfsRecursive.inOrderTraversal(root);
        System.out.println("\n");

        System.out.println("Post Order Recursive Traversal\n");
        dfsRecursive.postOrderTraversal(root);
        System.out.println("\n");


        // Create a Binary Search Tree
        Node bstRoot = new Node();
        bstRoot.data = 10;

        bstRoot.left = new Node();
        bstRoot.left.data = -5;

        bstRoot.left.left = new Node();
        bstRoot.left.left.data = -10;

        bstRoot.left.right = new Node();
        bstRoot.left.right.data = 0;

        bstRoot.left.right.right = new Node();
        bstRoot.left.right.right.data = 5;

        bstRoot.right = new Node();
        bstRoot.right.data = 30;

        bstRoot.right.right = new Node();
        bstRoot.right.right.data = 36;

        System.out.println("\nCheck Valid BST - " + dfsRecursive.isBST(bstRoot));


        System.out.println("\nSearch for key 0 (data) in Binary Search Tree");
        Node foundNode = dfsRecursive.searchBST(bstRoot, 0);
        System.out.println("\nFound Node " + foundNode.data);

        System.out.println("\nSearch for key 30 (data) in Binary Search Tree");
        Node foundNode1 = dfsRecursive.searchBST(bstRoot, 30);
        System.out.println("\nFound Node " + foundNode1.data);


        // Create a Binary Search Tree
        Node bstRoot1 = new Node();
        bstRoot1.data = 10;

        bstRoot1.right = new Node();
        bstRoot1.right.data = 15;

        bstRoot1.right.right = new Node();
        bstRoot1.right.right.data = 16;

        bstRoot1.right.right.right = new Node();
        bstRoot1.right.right.right.data = 18;

        System.out.println("\nSearch for key 16 (data) in Binary Search Tree");
        Node foundNode2 = dfsRecursive.searchBST(bstRoot1, 16);
        System.out.println("\nFound Node " + foundNode2.data);


        // Check if Same Binary Tree

    }

}

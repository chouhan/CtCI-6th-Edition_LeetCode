package binarytree;

/*
*
* Binary Search Tree Visualizer - http://btv.melezinek.cz/binary-search-tree.html
*
* Youtube Tutorial from Tushar Roy
*
* There are 3 kinds of traversal in Depth First Binary Tree
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
* For a Breadth First Traversal, we need Level By Level Traversal
*
* */

import CtCILibrary.AbstractNode;
import CtCILibrary.BTreePrinter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {

    List<Integer> rootToLeafSumResult = new ArrayList<Integer>();

    public static class Node extends AbstractNode{

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

        public Node copy(){
            Node left = null;
            Node right = null;
            if(this.left != null){
                left = this.left.copy();
            }
            if(this.right != null){
                right = this.right.copy();
            }

            return new Node(left, right, data);
        }

        @Override
        public AbstractNode getLeft() {
            return this.left;
        }

        @Override
        public AbstractNode getRight() {
            return this.right;
        }

        @Override
        public int getData() {
            return this.data;
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
    * Pre-Order Traversal - Iteratively
    * V - L - R
    *
    * Time Complexity: O(N)
    * Space Complexity: O(h) -- h is the height/size of the stack (LIFO)
    *
    * */
    public void preOrderIterative(Node node){
        if(node == null){
            return;
        }
        Stack<Node> stack = new Stack<Node>();
        stack.push(node);
        while(!stack.isEmpty()){
            node = stack.pop();
            System.out.print(node.data +  ", ");
            if(node.right != null){
                stack.push(node.right);
            }
            if(node.left != null){
                stack.push(node.left);
            }
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
    * In Order Traversal - Iteratively
    *
    * L - V - R
    *
    * Time Complexity: O(N)
    * Space Complexity: Depends on size of the stack, which O(h), where h is height of the stack
    *
    * */

    public void inOrderTraversalIterative(Node node){
        if(node == null){
            return;
        }
        Stack<Node> stack = new Stack<Node>();
        while(true){
            if(node != null){
                stack.push(node);
                node = node.left;
            } else {
                if(stack.isEmpty()){
                    break;
                }
                node = stack.pop();
                System.out.print(node.data + ", ");
                node = node.right;
            }
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
    *
    * Post Order Traversal - Iterative
    *
    * L - R - V
    *
    * Time Complexity: O(N)
    * Space Complexity: O(N) -- Since Stack2 will have all the elements.
    *
    * */

    public void postOrderTraversalIterative(Node node){
        if(node == null){
            return;
        }
        Stack<Node> stack1 = new Stack<Node>();
        Stack<Node> stack2 = new Stack<Node>();

        stack1.push(node);

        while(!stack1.isEmpty()){
            node = stack1.pop();
            stack2.push(node);
            if(node.left != null){
                stack1.push(node.left);
            }
            if(node.right != null){
                stack1.push(node.right);
            }
        }

        // Print all nodes now from stack2
        while(!stack2.isEmpty()){
            node = stack2.pop();
            System.out.print(node.data + ", ");
        }
    }

    /*
    *
    * LEVEL-BY-LEVEL Traversal (BFS) USING 2 QUEUES.
    *
    * TIME COMPLEXITY: O(n)
    * SPACE COMPLEXITY: O(n)
    *
    * */
    public void levelOrderUsingTwoQueues(Node node){
        if(node == null) {
            return;
        }

        Queue<Node> q1 = new LinkedList<Node>();
        Queue<Node> q2 = new LinkedList<Node>();

        q1.add(node);

        while(!q1.isEmpty() || !q2.isEmpty()){
            while(!q1.isEmpty()){
                node = q1.poll();
                System.out.print(node.data+ ", ");
                if(node.left != null){
                    q2.add(node.left);
                }
                if(node.right != null){
                    q2.add(node.right);
                }
            }
            System.out.println("");
            while(!q2.isEmpty()){
                node = q2.poll();
                System.out.print(node.data + ", ");
                if(node.left != null){
                    q1.add(node.left);
                }
                if(node.right != null){
                    q1.add(node.right);
                }
            }
            System.out.println("");
        }
    }



    /*
     *
     * LEVEL-BY-LEVEL Traversal (BFS) USING 1 QUEUE.
     *
     * TIME COMPLEXITY: O(n)
     * SPACE COMPLEXITY: O(n)
     *
     * */
    public void levelOrderUsingOneQueue(Node node){
        if(node == null){
            return;
        }

        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(node);
        queue.offer(null);

        while(!queue.isEmpty()){
            node = queue.poll();
            if(node != null){
                System.out.print(node.data + " ");
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            } else {
                if(!queue.isEmpty()){
                    System.out.println();
                    queue.offer(null);
                }
            }
        }

    }



    /*
     *
     * LEVEL-BY-LEVEL Traversal (BFS) USING 1 QUEUE AND COUNTER.
     *
     * TIME COMPLEXITY: O(n)
     * SPACE COMPLEXITY: O(n)
     *
     * */
    public void levelOrderUsingOneQueueAndCounter(Node node){
        if(node == null){
            return;
        }

        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(node);
        int levelCounter = 1;
        int currentCounter = 0;

        while(!queue.isEmpty()){
            while (levelCounter > 0){
                node = queue.poll();
                System.out.print(node.data + " ");
                if(node.left != null){
                    currentCounter++;
                    queue.offer(node.left);
                }
                if(node.right != null){
                    currentCounter++;
                    queue.offer(node.right);
                }
                levelCounter--;
            }
            System.out.println();
            levelCounter = currentCounter;
            currentCounter = 0;
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
    * Insert a node in the Binary Search Tree - USING TWO POINTERS
    *
    * */
    public Node insertNodeInBST(Node node, Node nodeToInsert){
        if(node == null){
            return node;
        }

        // Here Parent pointer will be the reference to the bottom node in the current binary search tree.
        // We will use this parent pointer to add the node to it.
        Node current = node, parent = null;

        while(current != null){
            parent = current;
            if(current.data <= nodeToInsert.data){
                current = current.right;
            } else {
                current = current.left;
            }
        }

        if(parent.data <= node.data){
            parent.right = nodeToInsert;
        } else {
            parent.left = nodeToInsert;
        }
        return node;
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

    public boolean isBST1(Node node) {
        if (node.left != null) {
            if (node.data < node.left.data || !isBST(node.left)) {
                return false;
            }
        }

        if (node.right != null) {
            if (node.data >= node.right.data || !isBST(node.right)) {
                return false;
            }
        }

        return true;
    }

    /*
    *
    * Check if 2 given Nodes are same binary tree
    *
    * */
    public boolean isSameTree(Node node1, Node node2){

        /* This check should be first and the order is important, because if both noded are null, then we would want to return true*/
        if(node1 == null && node2 == null){
            return true;
        }

        if(node1 == null || node2 == null){
            return false;
        }

        boolean isLeftSame = isSameTree(node1.left, node2.left);
        boolean isRightSame = isSameTree(node1.right, node2.right);

        if(node1.data == node2.data && isLeftSame && isRightSame){
            return true;
        }

        return false;
    }

    /*
    *
    * Invert a Binary Tree using recursive method
    *
    * */
    public Node reverseBST(Node node){
        if(node == null){
            return null;
        }
        Node right = reverseBST(node.right);
        Node left = reverseBST(node.left);
        node.left = right;
        node.right = left;
        return node;
    }

    /*
    *
    * Reverse a Binary Tree using iterative method.
    *
    * */
    public Node reverseBSTIteratively(Node node){
        if(node == null){
            return null;
        }

        Queue<Node> queue = new LinkedList<Node>();
        queue.add(node);
        while(!queue.isEmpty()){
           Node current = queue.poll();

           Node temp = current.left;
           current.left = current.right;
           current.right = temp;

           if(current.left != null){
               queue.add(current.left);
           }
           if(current.right != null){
               queue.add(current.right);
           }
        }

        return node;
    }

    /*
    * Invert a Binary Tree
    *  Ex:     1
    *         / \
    *        2   3
    *
    * O/P:  2   3
    *       \  /
    *        1
    * */
    public Node invertBST(Node node){
        if(node == null){
            return null;
        }
        if(node.left != null){
            Node leftChild = invertBST(node.left);
            leftChild.right = node;
        }

        if(node.right != null){
            Node rightChild = invertBST(node.right);
            rightChild.left = node;
        }

        node.left = null;
        node.right = null;

        return node;
    }

    /*
    *
    * Size of the binary tree
    *
    * */
    public int size(Node node){
        if(node == null){
            return 0;
        }
        int leftSize = size(node.left);
        int rightSize = size(node.right);

        return leftSize + rightSize + 1;
    }

    /*
    *
    * Get the Height/Diameter of the Binary Tree
    * Given a binary tree, you need to compute the length of the diameter of the tree.
    * The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
    * This path may or may not pass through the root.
    *
    * https://leetcode.com/problems/diameter-of-binary-tree/description/
    *
    * */
    public int height(Node node){
        if(node == null){
            return 0;
        }

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    /*
    *
    * Root to Leaf Sum Binary Tree
    *
    * Given a Sum, find the path from root to leaf, where sum is equal to all node data from root to leaf
    *
    * Explanation: https://www.youtube.com/watch?v=Jg4E4KZstFE&index=7&list=PLrmLmBdmIlpv_jNDXtJGYTPNQ2L1gdHxu
    *
    * PLEASE NOTE THAT THIS PROBLEM CALCULATES THE SUM FROM THE ROOT (TOP NODE) TO LEAF (LAST NODE) AND NOT TILL THE MIDDLE.
    * ALSO, THIS CODE TRAVERSES FROM LEFT TO RIGHT, SO IF THE PATH IS FIRST FOUND ON THE LEFT, IT RETURNS THE LEFT PATH.
    * SO, IT GIVES ONLY ONE RESULT PATH, EVEN THOUGH THERE ARE MULTIPLE PATHS WHICH EQUALS SUM.
    *
    * */
    public boolean rootToLeafSum(Node node, int sum){
        if(node == null){
            return false;
        }

        // Check if the node is a leaf (last) node
        if(node.left == null && node.right == null){
            // Check if the last leaf node data is same as carried sum
            if(node.data == sum){
                rootToLeafSumResult.add(node.data);
                return true;
            } else {
                return false;
            }
        }

        if(rootToLeafSum(node.left, sum - node.data)){
            rootToLeafSumResult.add(node.data);
            return true;
        }

        if(rootToLeafSum(node.right, sum - node.data)){
            rootToLeafSumResult.add(node.data);
            return true;
        }

        return false;
    }

    /*
    * Find the LOWEST COMMON ANCESTOR in a BINARY SEARCH TREE
    *
    * @returns - int (lowest common ancestor)
    *
    * */

    public int lowestCommonAncestor(Node node, int nodeData1, int nodeData2){

        if(node.data > Math.max(nodeData1, nodeData2)){
            return lowestCommonAncestor(node.left, nodeData1, nodeData2);
        } else if(node.data < Math.min(nodeData1, nodeData2)){
            return lowestCommonAncestor(node.right, nodeData1, nodeData2);
        } else {
            return node.data;
        }
    }


    /*
     * Find the LOWEST COMMON ANCESTOR in a BINARY TREE
     *
     * @returns - int (lowest common ancestor)
     *
     * */
    public int lowestCommonAncestorBinaryTree(Node node, int nodeData1, int nodeData2){
        if(node == null){
            return -1;
        }

        if(node.data == nodeData1 || node.data == nodeData2){
            return node.data;
        }
        int left = lowestCommonAncestorBinaryTree(node.left, nodeData1, nodeData2);
        int right = lowestCommonAncestorBinaryTree(node.right, nodeData1, nodeData2);

        if(left != -1 && right != -1){
            return node.data;
        }

        if(left == -1 && right == -1){
            return -1;
        }

        return left != -1 ? left : right;
    }

    /*
    *
    * Find the Largest BINARY SEARCH TREE IN BINARY TREE
    *
    * https://github.com/mission-peace/interview/blob/master/src/com/interview/tree/LargestBSTInBinaryTree.java
    *
    * */
    public int largestBSTInBT(Node node){
        return getLargestBSTInBT(node).size;
    }

    public MinMax getLargestBSTInBT(Node node){
        if(node == null){
            return new MinMax();
        }

        MinMax leftNode = getLargestBSTInBT(node.left);
        MinMax rightNode = getLargestBSTInBT(node.right);

        MinMax minMax = new MinMax();

        if(leftNode.isBST == false || rightNode.isBST == false ||
                (leftNode.max > node.data || rightNode.min <= node.data)){
            minMax.isBST = false;
            minMax.size = Math.max(leftNode.size, rightNode.size);
            return  minMax;
        }

        minMax.isBST = true;
        minMax.size = leftNode.size + rightNode.size + 1;

        minMax.min = node.left != null ? leftNode.min : node.data;
        minMax.max = node.right != null ? rightNode.max : node.data;

        return minMax;
    }

    class MinMax {
        int size;
        boolean isBST;
        int min;
        int max;

        MinMax(){
            size = 0;
            isBST = true;
            min = Integer.MIN_VALUE;
            max = Integer.MAX_VALUE;
        }
    }

    public static void printBinaryTree(Node root, int level){
        if(root==null)
            return;
        printBinaryTree(root.right, level+1);
        if(level!=0){
            for(int i=0;i<level-1;i++)
                System.out.print("|\t");
            System.out.println("|-------"+root.data);
        }
        else
            System.out.println(root.data);
        printBinaryTree(root.left, level+1);
    }

    public void print(String prefix, Node n, boolean isLeft) {
        if (n != null) {
            System.out.println (prefix + (isLeft ? "|-- " : "\\-- ") + n.data);
            print(prefix + (isLeft ? "|   " : "    "), n.left, true);
            print(prefix + (isLeft ? "|   " : "    "), n.right, false);
        }
    }

    /*
    *
    * MAIN
    *
    * */
    public static void main(String[] args){

        BinaryTree binaryTree = new BinaryTree();

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

        System.out.println("Is root node a valid BST " + binaryTree.isBST(root));
        System.out.println("");

        new BTreePrinter().printNode(root);


        System.out.println("Pre Order Recursive Traversal\n");
        binaryTree.preOrder(root);
        System.out.println("\n");

        System.out.println("\n\nPre Order Recursive Traversal - Iteratively\n");
        binaryTree.preOrderIterative(root);
        System.out.println("\n");

        System.out.println("In Order Recursive Traversal\n");
        binaryTree.inOrderTraversal(root);
        System.out.println("\n");

        System.out.println("\n\nIn Order Recursive Traversal - Iteratively\n");
        binaryTree.inOrderTraversalIterative(root);
        System.out.println("\n");

        System.out.println("Post Order Recursive Traversal\n");
        binaryTree.postOrderTraversal(root);
        System.out.println("\n");

        System.out.println("\n\nPost Order Recursive Traversal - Iteratively\n");
        binaryTree.postOrderTraversalIterative(root);
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

        new BTreePrinter().printNode(bstRoot);
        System.out.println("\nCheck Valid BST - " + binaryTree.isBST(bstRoot));
        System.out.println("\nCheck Valid BST1 - " + binaryTree.isBST1(bstRoot));


        System.out.println("\nSearch for key 0 (data) in Binary Search Tree");
        Node foundNode = binaryTree.searchBST(bstRoot, 0);
        System.out.println("\nFound Node " + foundNode.data);

        System.out.println("\nSearch for key 30 (data) in Binary Search Tree");
        Node foundNode1 = binaryTree.searchBST(bstRoot, 30);
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
        Node foundNode2 = binaryTree.searchBST(bstRoot1, 16);
        System.out.println("\nFound Node " + foundNode2.data);


        // Check if Same Binary Tree
        System.out.println("\nCheck if same tree");
        Node node1 = bstRoot.copy();
        Node node2 = bstRoot.copy();
        boolean sameTree = binaryTree.isSameTree(node1, node2);
        System.out.println("\nAre both trees same? " + sameTree);

        System.out.println("\nCheck if this is same tree");
        Node node3 = bstRoot.copy();
        Node node4 = bstRoot1.copy();
        boolean sameTree1 = binaryTree.isSameTree(node3, node4);
        System.out.println("\nAre both trees same? " + sameTree1);

        System.out.println("\nPre Order Recursive Traversal - Before Reverse\n");
        Node toReverse = bstRoot.copy();
        new BTreePrinter().printNode(toReverse);
        binaryTree.preOrder(toReverse);
        System.out.println("\nInvert a Binary Tree");
        binaryTree.reverseBST(toReverse);
        System.out.println("\nPre Order Recursive Traversal - After Reverse\n");
        binaryTree.preOrder(toReverse);
        System.out.println("");
        new BTreePrinter().printNode(toReverse);

        System.out.println("");
        System.out.println("\nThe size of Binary Search Tree bstRoot is " + binaryTree.size(bstRoot));

        System.out.println("");
        System.out.println("\nThe Height/Diameter of Binary Search Tree bstRoot is " + binaryTree.height(bstRoot));

        System.out.println("");
        System.out.println("Binary Tree Print ");
        new BTreePrinter().printNode(bstRoot);
        System.out.println("\nCheck Valid BST - " + binaryTree.isBST(bstRoot));
        // Set sum = -5, 0, 76, 71
        System.out.println("\nThe Root Leaf Sum of a BINARY TREE (NOT A BINARY SEARCH TREE) path is found? " + binaryTree.rootToLeafSum(bstRoot, -5));
        System.out.println("\nThe Root Leaf Sum of a BINARY TREE (NOT A BINARY SEARCH TREE) is " + binaryTree.rootToLeafSumResult.toString().replaceAll("\\[|\\]", "").replaceAll(", ","\t"));

        Node bstRootCopy = bstRoot1.copy();


        System.out.println("");
        System.out.println("BEFORE - Binary Tree Print - bstRootCopy");
        new BTreePrinter().printNode(bstRootCopy);

        binaryTree.rootToLeafSumResult = new ArrayList<>();
        System.out.println("\nBEFORE - The Root Leaf Sum of a BINARY TREE (NOT A BINARY SEARCH TREE) path is found? " + binaryTree.rootToLeafSum(bstRootCopy, 59));
        System.out.println("\nBEFORE - The Root Leaf Sum of a BINARY TREE (NOT A BINARY SEARCH TREE) is " + binaryTree.rootToLeafSumResult.toString().replaceAll("\\[|\\]", "").replaceAll(", ","\t"));

        /*bstRootCopy.left = new Node();
        bstRootCopy.left.data = 10;*/

        bstRootCopy.left = new Node();
        bstRootCopy.left.data = 18;

        bstRootCopy.left.left = new Node();
        bstRootCopy.left.left.data = 16;

        bstRootCopy.left.left.left = new Node();
        bstRootCopy.left.left.left.data = 15;

        System.out.println("");
        System.out.println("AFTER - Binary Tree Print - bstRootCopy");
        new BTreePrinter().printNode(bstRootCopy);

        binaryTree.rootToLeafSumResult = new ArrayList<>();
        System.out.println("\nAFTER - The Root Leaf Sum of a BINARY TREE (NOT A BINARY SEARCH TREE) path is found? " + binaryTree.rootToLeafSum(bstRootCopy, 59));
        System.out.println("\nAFTER - The Root Leaf Sum of a BINARY TREE (NOT A BINARY SEARCH TREE) is " + binaryTree.rootToLeafSumResult.toString().replaceAll("\\[|\\]", "").replaceAll(", ","\t"));


        System.out.println("\nLEVEL-BY-LEVEl Ordering using two Queues");
        binaryTree.levelOrderUsingTwoQueues(bstRoot);

        System.out.println("\nLEVEL-BY-LEVEl Ordering using One Queue\n");
        binaryTree.levelOrderUsingOneQueue(bstRoot);

        System.out.println("\n\nLEVEL-BY-LEVEl Ordering using One Queue and Counter\n");
        binaryTree.levelOrderUsingOneQueueAndCounter(bstRoot);


        /*Node nodeToInvert = bstRoot.copy();
        System.out.println("\nBEFORE - Invert a BT");
        new BTreePrinter().printNode(nodeToInvert);
        Node invertedNode = binaryTree.invertBST(bstRoot);
        System.out.println("\nAFTER - Invert a BT");
        new BTreePrinter().printNode(invertedNode);*/


        System.out.println("\nBEFORE - Inserting a node");
        new BTreePrinter().printNode(bstRoot);
        System.out.println("\nInsert a node in a Binary Search Tree");
        Node nodeToInsert = new Node();
        nodeToInsert.right = null;
        nodeToInsert.left = null;
        nodeToInsert.data = 7;
        binaryTree.insertNodeInBST(bstRoot, nodeToInsert);
        System.out.println("\nAFTER - Inserting a node");
        new BTreePrinter().printNode(bstRoot);


        System.out.println("\nLowest Common Ancestor in BINARY SEARCH TREE");
        System.out.println("The lowest common ancestor for -10, 0 is " + binaryTree.lowestCommonAncestor(bstRoot, -10, 0));

        System.out.println("\nLowest Common Ancestor in BINARY SEARCH TREE");
        System.out.println("The lowest common ancestor is 30, 36 is " + binaryTree.lowestCommonAncestor(bstRoot, 30, 36));

        System.out.println("\nLowest Common Ancestor in BINARY SEARCH TREE");
        System.out.println("The lowest common ancestor is 5, 7 is " + binaryTree.lowestCommonAncestor(bstRoot, 5, 7));

        System.out.println("\nLowest Common Ancestor in BINARY SEARCH TREE");
        System.out.println("The lowest common ancestor is -10, 30 is " + binaryTree.lowestCommonAncestor(bstRoot, -10, 30));

        System.out.println("");
        System.out.println("\n ---------------------------------------------------------------------------------------------- ");
        System.out.println("\n\n");
        new BTreePrinter().printNode(root);

        System.out.println("\nLowest Common Ancestor in BINARY TREE");
        System.out.println("The lowest common ancestor for 2, 5 is " + binaryTree.lowestCommonAncestorBinaryTree(root, 2, 5));

        System.out.println("\nLowest Common Ancestor in BINARY TREE");
        System.out.println("The lowest common ancestor is 6, 8 is " + binaryTree.lowestCommonAncestorBinaryTree(root, 6, 8));

        System.out.println("\nLowest Common Ancestor in BINARY TREE");
        System.out.println("The lowest common ancestor is 2, 3 is " + binaryTree.lowestCommonAncestorBinaryTree(root, 2, 3));

        System.out.println("\nLowest Common Ancestor in BINARY TREE");
        System.out.println("The lowest common ancestor is 5, 3 is " + binaryTree.lowestCommonAncestorBinaryTree(root, 5, 3));

        System.out.println("\nLowest Common Ancestor in BINARY TREE");
        System.out.println("The lowest common ancestor is 6, -1 (-1 does not exist) is " + binaryTree.lowestCommonAncestorBinaryTree(root, 6, -1));


        System.out.println("");
        System.out.println("\n ---------------------------------------------------------------------------------------------- ");
        System.out.println("\n\n");

        Node largestBSTInBT = new Node();
        largestBSTInBT.data = 25;

        largestBSTInBT.left = new Node();
        largestBSTInBT.left.data = 18;

        largestBSTInBT.left.left = new Node();
        largestBSTInBT.left.left.data = 19;

        largestBSTInBT.left.left.right = new Node();
        largestBSTInBT.left.left.right.data = 15;

        largestBSTInBT.left.right = new Node();
        largestBSTInBT.left.right.data = 20;

        largestBSTInBT.left.right.left = new Node();
        largestBSTInBT.left.right.left.data = 18;

        largestBSTInBT.left.right.right = new Node();
        largestBSTInBT.left.right.right.data = 25;

        largestBSTInBT.right = new Node();
        largestBSTInBT.right.data = 50;

        largestBSTInBT.right.left = new Node();
        largestBSTInBT.right.left.data = 35;

        largestBSTInBT.right.left.right = new Node();
        largestBSTInBT.right.left.right.data = 40;

        largestBSTInBT.right.left.left = new Node();
        largestBSTInBT.right.left.left.data = 20;

        largestBSTInBT.right.left.left.right = new Node();
        largestBSTInBT.right.left.left.right.data = 25;

        largestBSTInBT.right.right = new Node();
        largestBSTInBT.right.right.data = 60;

        largestBSTInBT.right.right.left = new Node();
        largestBSTInBT.right.right.left.data = 55;

        largestBSTInBT.right.right.right = new Node();
        largestBSTInBT.right.right.right.data = 70;

//        new BTreePrinter().printNode(largestBSTInBT);

//        binaryTree.printBinaryTree(largestBSTInBT, 0);

        binaryTree.print("", largestBSTInBT, false);
        System.out.println("The largest BST in this BT is " + binaryTree.largestBSTInBT(largestBSTInBT));


        /* ------------------------------------------------------------------------------------------------------------- */

        System.out.println(" --------------------------------------------------------------------------------------------------- ");

    }
}
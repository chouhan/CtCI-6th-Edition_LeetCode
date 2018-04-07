import java.util.LinkedList;

// https://leetcode.com/problems/minimum-depth-of-binary-tree/description/
public class MinDepthBST {

    // Driver

    public static void main(String args[]){
        MinDepthBST minDepthBSTMain = new MinDepthBST();

        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        node.right = new TreeNode(3);
        /*node.right.left = new TreeNode(3);
        node.right.right = new TreeNode(2);*/

        System.out.println("Minimum Depth is " + minDepthBSTMain.minDepthBST(node));
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
          val = x;
      }
  }

    public int minDepthBST(TreeNode root){


        // If the root node is null, then return 0
        if(root == null){
            return 0;
        }

        /*This case is already being handled in the while loop*/
        // If the root node does not have left and right leafs then height is 1
        // if(root.left == null && root.right == null){
        //     return 1;
        // }

        // Store the nodes in a LinkedList. Why LinkedList?.
        // Because, we are adding a element to head and removing element from the Head, which is O(1) operation
        LinkedList<TreeNode> nodes = new LinkedList<TreeNode>();

        // Store the counts in a LinkedList. Okay now why LinkedList again for maintaining Counts?
        // If we were using a ArrayList, then we will have to maintain 2 different arraylist for counting
        // currentNode.left node and currentNode.right node. Finally, we will have to take the
        // minimum of arraylist size of both left and right node counts.

        // If it is a LinkedList, then the least minimum count number always stays at the HEAD (first) pointer,
        // as keep adding counts while iterating over root nodes left and right.
        // So we grab the first head value and return it as minimum.
        LinkedList<Integer> counts = new LinkedList<Integer>();

        // Add the root node to LinkedList
        nodes.add(root);

        // Add count as 1 initially, since we should be counting the root node that we just added.
        counts.add(1);

        // Loop thru each node in the LinkedList, until the node in the LinkedList is not empty.
        while(!nodes.isEmpty()){

            // Get the current node. Retrieves and deletes the current element in the linkedlist.
            // currentNode will the first element in the linkedlist upon removal.
            TreeNode currentNode = nodes.remove();
            int count = counts.remove();

            // If the currentNode's left is null and currentNode's right is null, which means that we have
            // reached the end of the BST. So we return the first element of the LinkedList count
            if(currentNode.left == null && currentNode.right == null){
                return count;
            }

            // If currentNode's left is not null, then keep adding the left node to nodes linkedlist.
            // Also, increment the count and add to counts linkedlist
            if(currentNode.left != null){
                nodes.add(currentNode.left);
                counts.add(count + 1);
            }

            // If currentNode's right is not null, then keep adding the right node to nodes linkedlist.
            // Also, increment the count and add to counts linkedlist
            if(currentNode.right != null){
                nodes.add(currentNode.right);
                counts.add(count + 1);
            }
        }

        return 0;
    }
}

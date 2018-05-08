import java.util.Deque;
import java.util.LinkedList;

// https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
public class MaxDepthBST {

    // Driver - [3,9,20,null,null,15,7,6,7,5,4,3]

    public static void main(String args[]){
        MaxDepthBST maxDepthBSTMain = new MaxDepthBST();

        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(9);
        node.right = new TreeNode(20);
        node.right.left = new TreeNode(15);
        node.right.left.left = new TreeNode(6);
        node.right.left.left.left = new TreeNode(3);
        node.right.left.right = new TreeNode(7);
        node.right.right = new TreeNode(7);
        node.right.right.left = new TreeNode(5);
        node.right.right.right = new TreeNode(4);
        System.out.println("Maximum Depth is " + maxDepthBSTMain.maxDepthBST(node));
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
          val = x;
      }
  }

    public int maxDepthBST(TreeNode root){


        // If the root node is null, then return 0
        if(root == null){
            return 0;
        }

        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int count = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode node = queue.poll();

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            count++;
        }

        return count;
    }
}

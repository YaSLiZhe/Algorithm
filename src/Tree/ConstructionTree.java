package Tree;

import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class ConstructionTree {
    public TreeNode createTree(int[] nums){
        int length = nums.length;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        TreeNode root = new TreeNode(nums[0]);
        q.offer(root);
       int i = 1;

       while(!q.isEmpty() && i<length){
           TreeNode cur = q.poll();
           int leftVal = nums[i++];
           if(leftVal != -1){
               cur.left = new TreeNode(leftVal);
               q.offer(cur.left);
           }

           if(i < length){
               int rightVal = nums[i++];
               if(rightVal != -1){
                   cur.right = new TreeNode(rightVal);
                   q.offer(cur.right);
               }
           }
       }
        return root;
    }
}

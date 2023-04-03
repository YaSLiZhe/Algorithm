package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal
{
    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Stack<TreeNode> s = new Stack<>();
        while(!s.isEmpty() || root != null){
            if(root != null){
                s.push(root);
                root = root.left;
            }
            else{
                    root = s.pop();
                    res.add(root.val);
                    root = root.right;
                    }
        }
        return res;
    }
}

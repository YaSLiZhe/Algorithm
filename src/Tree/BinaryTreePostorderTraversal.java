package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(root);
        while(!s1.isEmpty()){
            TreeNode cur = s1.pop();
            s2.push(cur);
            if(cur.left != null){
                s1.push(cur.left);
            }
            if(cur.right != null){
                s1.push(cur.right);
            }
        }
        while(!s2.isEmpty()){
            res.add(s2.pop().val);
        }
        return res;
    }
}

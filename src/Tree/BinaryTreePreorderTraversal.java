package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal {
    public  List<Integer> preorderTraversal(TreeNode root){
    List<Integer> res = new ArrayList<>();
    preorder(root, res);
    return res;
    }

    private void preorder(TreeNode root, List<Integer> list){
        if(root == null){
            return;
        }
        list.add(root.val);
        preorder(root.left,list);
        preorder(root.right, list);
    }

    public List<Integer> preorderTraversal2(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            res.add(cur.val);
            //先右再左，确保顺序
            if(cur.right != null){
                stack.add(cur.right);
            }
            if(cur.left != null){
                stack.add(cur.left);
            }
        }
        return res;
    }
}

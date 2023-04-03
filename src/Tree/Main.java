package Tree;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static  void main(String[] args) {
     int[] nums = {1,2,3,4,5,6,6};
    ConstructionTree cTree = new ConstructionTree();
    TreeNode node = cTree.createTree(nums);
    BinaryTreePostorderTraversal postorderT = new BinaryTreePostorderTraversal();
    List<Integer> res =  postorderT.postorderTraversal(node);
    loopList(res);

    }

    private static void loopList(List<Integer> list){
        for(int i = 0;i < list.size();i++){
            System.out.print(list.get(i));
            System.out.print("  ");
        }
    }
}

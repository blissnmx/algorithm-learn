/**
 * @author ning_mx
 * @date 22:48 2022/6/14
 * @desc
 */
package medium.BDFS;

import org.junit.Test;
import tree.TreeNode;

/**
 * @author ning_mx
 * @date 2022/6/14
 */
public class 合并二叉树 {

    @Test
    public void testMergeTreeNode(){
        mergeTreeDFS(new TreeNode(1), new TreeNode(2));
    }
    public static tree.TreeNode mergeTreeDFS(tree.TreeNode root1, tree.TreeNode root2){
        if(root1 == null) return root2;
        if(root2 == null) return root1;
        tree.TreeNode root = new TreeNode(root1.val + root2.val);
        root.left = mergeTreeDFS(root1.left, root2.left);
        root.right = mergeTreeDFS(root1.right, root2.right);
        return root;
    }
}

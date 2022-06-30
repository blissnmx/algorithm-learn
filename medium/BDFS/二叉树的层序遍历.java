/**
 * @author ning_mx
 * @date 19:26 2022/6/26
 * @desc
 */
package medium.BDFS;

import org.junit.Test;
import sun.reflect.generics.tree.Tree;
import sun.rmi.server.InactiveGroupException;
import tree.TreeNode;

import java.util.*;

/**
 * @author ning_mx
 * @date 2022/6/26
 */
public class 二叉树的层序遍历 {
    /**
     * 102. 二叉树的层序遍历
     * @param root
     */
    @Test
    public void levelOrder(Node root){
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return ;
        Queue<Node> que = new LinkedList<>();
        que.offer(root);
        while (!que.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = que.size();
            for (int i = 0; i < size; i++) {
                Node node = que.poll();
                list.add(node.val);
                if (node.left != null) {
                    que.offer(node.left);
                }
                if(node.right != null){
                    que.offer(node.right);
                }
            }
            result.add(list);
         }
    }

    /**
     * 107. 二叉树的层序遍历 II
     * 自底向上层次遍历，将每次遍历的行添加到列表最前面即可，
     */
    @Test
    public void levelOrderBottom(){
        tree.TreeNode root = new TreeNode(1);
        Queue<TreeNode> que = new LinkedList<>();
        List<List<Integer>> r = new ArrayList<>();
        que.offer(root);
        while (!que.isEmpty()) {
            int size = que.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = que.poll();
                list.add(node.val);
                if(node.left != null ) que.offer(node.left);
                if(node.right != null) que.offer(node.right);
            }
            r.add(0,list);
        }
    }
    /**
     *  199.二叉树的右视图
     */
    @Test
    public void btreeRightView(){
        TreeNode root = new TreeNode(0);
        List<Integer> result = new ArrayList<>();
        if(root ==null) return ;

        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        while (!que.isEmpty()) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = que.poll();
                if(i == size-1){
                    result.add(node.val);
                }
                if(node.left!=null) que.offer(node.left);
                if(node.right!=null) que.offer(node.right);
            }
        }
    }
    /**
     * 637.二叉树的层平均值
     */
    @Test
    public void btreeAvarageOfLevels(){
        TreeNode root = new TreeNode(0);
        List<Double> result = new ArrayList<>();
        if(root ==null) return ;
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        while (!que.isEmpty()) {
            int size = que.size();
            double sum = 0 ;
            for (int i = 0; i < size; i++) {
                TreeNode node = que.poll();
                sum += node.val;
                if(node.left != null) que.offer(node.left);
                if(node.right!=null) que.offer(node.right);
            }
            result.add(sum / size);
        }
    }
    /*
    429.N叉树的前序遍历
     */
    public List<List<Integer>> levelOrder(NodeN root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null ) return result;
        Queue<NodeN> que = new LinkedList<>();
        que.offer(root);
        while (!que.isEmpty()) {
            int size = que.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                NodeN node = que.poll();
                assert node != null;
                list.add(node.val);
                if (node.children != null && node.children.size() > 0) {
                    for (NodeN child : node.children) {
                        que.offer(child);
                    }
                }
            }
            result.add(list);
        }
        return result;
    }
}
class NodeN {
    public int val;
    public List<NodeN> children;

    public NodeN() {}

    public NodeN(int _val) {
        val = _val;
    }

    public NodeN(int _val, List<NodeN> _children) {
        val = _val;
        children = _children;
    }
};

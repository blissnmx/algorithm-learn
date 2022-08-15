/**
 * @author ning_mx
 * @date 10:21 2022/6/26
 * @desc
 */
package medium.BDFS;

import Model.TreeNode;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author ning_mx
 * @date 2022/6/26
 * @desc 给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 *
 * 初始状态下，所有 next 指针都被设置为 NULL。
 * 输入：root = [1,2,3,4,5,6,7]
 * 输出：[1,#,2,3,#,4,5,6,7,#]
 * 解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。序列化的输出按层序遍历排列，同一层节点由 next 指针连接，'#' 标志着每一层的结束。
 *
 */
class Node {
    int val;
    Node left;
    Node right;
    Node next;
}
public class 填充二叉树指针 {

    @Test
    public void fillBtreeDFS(){
        Node root = new Node();
        fillDFS(root);
    }
    public void fillDFS(Node root){
        if(root == null ) return ;
        Node left = root.left;
        Node right = root.right;
        while(left != null){
            left.next = right;
            left = left.right;
            right = right.left ;
        }
        fillDFS(root.left);
        fillDFS(root.right);
    }
    //两个队列实现层序遍历
    public Node fillBFSQuee(Node root){
        if(root == null ) return null;
        //队列中存放每一层的元素
        Queue<Node> que = new LinkedList<Node>();
        Queue<Node> que2 = new LinkedList<Node>();
        que.offer(root);

        while(!que.isEmpty()){
            Node node = que.poll();
            if(node.left!=null){
                que2.offer(node.left);
                que2.offer(node.right);
            }

            while(!que.isEmpty()){
                Node cur = que.poll();
                node.next = cur;
                if(cur.left!=null){
                    que2.offer(cur.left);
                    que2.offer(cur.right);
                }
                node = cur;
            }
            que = que2;
            que2 = new LinkedList<Node>();
        }
        return root;
    }
    //根据父节点为左右子节点的next指针赋值
    public Node fillBFSNoQuee(Node root){
        if(root == null) return root;
        Node pre = root;
        while(pre.left != null){
            Node tmp = pre ;
            while(tmp !=null){
                tmp.left.next = tmp.right;
                if(tmp.next!=null){
                    tmp.right.next = tmp.next.left;
                }
                tmp = tmp.next;
            }
            pre = pre.left;

        }
        return root;
    }
}
/**
 * 102.二叉树的层序遍历
 * 107.二叉树的层次遍历II
 * 199.二叉树的右视图
 * 637.二叉树的层平均值
 * 429.N叉树的前序遍历
 * 515.在每个树行中找最大值
 * 116.填充每个节点的下一个右侧节点指针
 * 117.填充每个节点的下一个右侧节点指针II
 * 104.二叉树的最大深度
 * 111.二叉树的最小深度
 */

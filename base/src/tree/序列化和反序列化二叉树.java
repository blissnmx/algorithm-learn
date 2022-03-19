/**
 * @author ning_mx
 * @date 17:13 2022/3/14
 * @desc
 */
package tree;

/**
 * @author ning_mx
 * @date 2022/3/14
 * 请设计一个算法能将二叉树序列化成一个字符串并能将该字符串反序列化出原来二叉树的算法。
 */
public class 序列化和反序列化二叉树 {

    public static String serialize(TreeNode root){
         return  firstIterator(root);
    }

    public static TreeNode deserialize(String str) {
        String[] strs = str.split(",");
        int[] i = {0};
        return genTreeNode(strs,i);
    }

    private static TreeNode genTreeNode(String[] strs, int[] i) {
        String str = strs[i[0]];
        i[0]++;
        if ("@".equals(str)) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(str));
        node.left = genTreeNode(strs, i);
        node.right = genTreeNode(strs, i);
        return node ;
    }

    public static String firstIterator(TreeNode root) {
        if (root == null) {
            return "@";
        }
        String val = String.valueOf(root.val);
        String left = String.valueOf(firstIterator(root.left));
        String right = String.valueOf(firstIterator(root.right));
        return val +"," + left+"," + right;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        System.out.println(serialize(root));

        TreeNode deserialize = deserialize(serialize(root));
        System.out.println(deserialize);
    }
}

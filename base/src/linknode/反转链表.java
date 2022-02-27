/**
 * @author ning_mx
 * @date 11:39 2022/2/24
 * @desc
 */
package linknode;

/**
 * @author blissnmx
 * @date 2022/2/24
 * 输入单向链表，输出翻转后的链表
 * 例如链表A【1-2-3-4-5-6】 返回【6-5-4-3-2-1】
 */
public class 反转链表 {
    /**
     * 三指针防止断裂问题
     * 时间复杂度：O(n)
     */
    public static ListNode revertListNode(ListNode head) {
        ListNode pre =null , cur = head ;
        while (cur != null) {
            ListNode next = cur.next ;
            cur.next = pre ;
            pre = cur ;
            cur = next ;
        }
        return pre;
    }

    public static void main(String[] args) {
         ListNode a = new ListNode(1)
                 .setNext(new ListNode(2)
                .setNext(new ListNode(3)
                .setNext(new ListNode(4)
                .setNext(new ListNode(5)
                .setNext(new ListNode(6)
                )))));

        ListNode listNode = revertListNode(a);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}

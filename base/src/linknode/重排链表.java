/**
 * @author ning_mx
 * @date 11:39 2022/2/24
 * @desc
 */
package linknode;

import Model.ListNode;

/**
 * @author blissnmx
 * @date 2022/2/24
 * 给你一个链表，链表中结点的顺序是L0→ L1→ L2→…→ Ln-1→ Ln，
 * 请问如何重排链表使得结点的顺序变成L0→ Ln→ L1→ Ln-1→ L2→ Ln-2→…？
 */
public class 重排链表 {

    /**
     * 可以观察到重排后的链表是原链表的前半部分和翻转后的后半部分组成
     * 1、得到前半部分链表、后半部分链表（快慢指针）
     * 2、翻转后半部分，将两部分组成新的链表
     */
    public static ListNode twoListNodeRevertAndMerge(ListNode head) {
        ListNode slow = head ,fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next ;
        }
        ListNode back = revertListNode(slow.next) ;
        slow.next = null;
        ListNode front = head ;
        ListNode dummy = front;
        while (back != null && front != null) {
            ListNode fnext = front.next ;
            ListNode bnext = back.next;
            front.next = back ;
            back.next = fnext ;
            front = fnext ;
            back = bnext ;
        }
        return dummy;
    }

    /**
     * 三指针防止断裂问题
     * 时间复杂度：O(n)
     */
    public static ListNode revertListNode(ListNode head) {
        ListNode pre =null , cur = head ;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur ;
            cur = next ;
        }
        return pre;
    }

    public static void main(String[] args) {
         ListNode head = new ListNode(1)
                 .setNext(new ListNode(2)
                .setNext(new ListNode(3)
                .setNext(new ListNode(4)
                .setNext(new ListNode(5)
                .setNext(new ListNode(6)
                )))));
        ListNode listNode = twoListNodeRevertAndMerge(head);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}

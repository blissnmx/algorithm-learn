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
 * 如何判断一个链表是不是回文？要求解法的时间复杂度是O(n)， 另外不得使用超过O(1)的辅助空间。
 * 如果一个链表是回文，那么链表中结点序列从前往后看和从后往前看是相同的。
 * 例如，图4.13中的链表的结点序列从前往后看和从后往前看都是1、2、3、3、2、1，因此这是一个回文链表。
 */
public class 回文链表 {

    /**
     * 可以观察到回文链表的前半部分和翻转后的后半部分是相同的
     * 1、得到前半部分链表、后半部分链表（快慢指针）
     * 2、以此比较两个链表（前半部分可能多一个（奇数），在比较的时候可以忽略）
     */
    public static boolean checkIsPalldromeNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode back = revertListNode(slow.next);
        slow.next = null;
        ListNode front = head;
        while (back != null && front != null) {
            if (front.val != back.val) {
                return false;
            }
            back = back.next;
            front = front.next;
        }
        return true;
    }

    /**
     * 三指针防止断裂问题
     * 时间复杂度：O(n)
     */
    public static ListNode revertListNode(ListNode head) {
        ListNode pre = null, cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1)
                .setNext(new ListNode(2)
                        .setNext(new ListNode(3)
                                .setNext(new ListNode(2)
                                        .setNext(new ListNode(1)
                                        ))));
        System.out.println("checkIsPalldromeNode(head) = " + checkIsPalldromeNode(head));

    }
}

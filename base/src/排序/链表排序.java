/**
 * @author ning_mx
 * @date 10:47 2022/3/31
 * @desc
 */
package 排序;

import Model.ListNode;

/**
 * @author ning_mx
 * @date 2022/3/31
 */
public class 链表排序 {
    public static ListNode mergeSortNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //拆分链表
        ListNode mid = getMid(head);

        //递归子数组
        ListNode listNode = mergeSortNode(head);
        ListNode listNode1 = mergeSortNode(mid);

        //合并排序后的子链表
        return merge(listNode, listNode1);
    }

    private static ListNode merge(ListNode mid, ListNode head) {
        ListNode r = new ListNode(0);
        ListNode cur = r;
        while (mid != null || head != null) {
            if (head == null || (mid != null && (mid.val < head.val))) {
                cur.next = mid;
                mid = mid.next;
            } else {
                cur.next = head;
                head = head.next;
            }
            cur = cur.next;
        }
        return r.next;
    }

    private static ListNode getMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode second = slow.next;
        slow.next = null;

        return second;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4).setNext(new ListNode(3)
                .setNext(new ListNode(5)
                        .setNext(new ListNode(2)
                                .setNext(new ListNode(1)
                                        .setNext(new ListNode(6))))));
        ListNode listNode = mergeSortNode(head);
        while (listNode != null) {
            System.out.print(listNode.val);
            listNode = listNode.next;
        }
    }
}

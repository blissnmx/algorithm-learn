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
 * 给你一个链表，请问如何删除链表中的倒数第k个结点？假设链表中结点的总数为n，那么1≤k≤n。要求只能遍历链表一次。
 * 例如输入【1-2-3-4-5-6】的链表，删除倒数第2个结点之后的链表【1-2-3-4-6】
 */
public class 删除倒数第k个结点 {
    /**
     * 快慢指针，快指针先移动k步，然后和慢指针同时移动直到快指针到尾部时，慢指针的下一个即为k节点
     * k.next = k.next.next删除k
     * 时间复杂度：O(n+k)
     */
    public static ListNode removeBackNode(ListNode head, int k) {
        ListNode s = head, f = head;
        for (int i = 1; i <= k; i++) {
            f = f.next;
        }
        while (f.next != null) {
            f = f.next;
            s = s.next;
        }
        s.next = s.next.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1).setNext(new ListNode(2)
                .setNext(new ListNode(3)
                        .setNext(new ListNode(4)
                                .setNext(new ListNode(5)
                                        .setNext(new ListNode(6))))));
        ListNode listNode = removeBackNode(head, 2);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}

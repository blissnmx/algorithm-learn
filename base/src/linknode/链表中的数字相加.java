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
 * 给你两个表示非负整数的单向链表，请问如何实现这两个整数的相加并且把和仍然用单向链表表示？
 * 链表中的每个结点表示整数十进制的一位，并且头结点对应整数的最高位数而尾结点对应整数的个位数
 */
public class 链表中的数字相加 {

    /**
     * 1、整数相加是从右到左，因此将两个链表翻转后相加的结果再翻转返回即可
     * 2、整数相加为十进制，注意进位
     */
    public static ListNode twoSumListNode(ListNode a, ListNode b) {
        ListNode listNodeA = revertListNode(a);
        ListNode listNodeB = revertListNode(b);
        ListNode head = new ListNode(0);
        ListNode sumNode = head;
        int carry = 0;
        while (listNodeA != null || listNodeB != null) {
            int va = listNodeA == null ? 0 : listNodeA.val;
            int vb = listNodeB == null ? 0 : listNodeB.val;
            int sum = (va + vb + carry) >= 10 ? (va + vb + carry - 10) : (va + vb);
            ListNode listNode = new ListNode(sum);
            carry = (va + vb) >= 10 ? 1 : 0;
            sumNode.next = listNode;
            sumNode = sumNode.next;

            listNodeA = listNodeA.next;
            listNodeB = listNodeB.next;
        }
        if (carry > 0) {
            sumNode.next = new ListNode(carry);
        }
        return revertListNode(head.next);
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
        ListNode a = new ListNode(1)
                .setNext(new ListNode(2)
                        .setNext(new ListNode(3)
                                .setNext(new ListNode(4)
                                        .setNext(new ListNode(5)
                                                .setNext(new ListNode(6)
                                                )))));
        ListNode b = new ListNode(10)
                .setNext(new ListNode(9)
                        .setNext(new ListNode(8)
                                .setNext(new ListNode(7)
                                        .setNext(new ListNode(6)
                                                .setNext(new ListNode(5)
                                                )))));

        ListNode listNode = twoSumListNode(a, b);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}

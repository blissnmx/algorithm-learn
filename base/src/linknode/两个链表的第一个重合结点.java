/**
 * @author ning_mx
 * @date 11:39 2022/2/24
 * @desc
 */
package linknode;

/**
 * @author blissnmx
 * @date 2022/2/24
 * 输入两个单向链表，请问如何找出它们的第一个重合结点
 * 例如链表A【1-2-4-5-6】 链表B【7-8-4-5-6】 第一个重合节点为4，返回4
 */
public class 两个链表的第一个重合结点 {
    /**
     * 1、得到两个链表的长度的差值k,较长的链表指针先移动k步；
     * 2、两个链表同时移动，得到重合的节点
     * 时间复杂度：O(m+n)
     */
    public static ListNode findRepeatNode(ListNode a , ListNode b ) {
        int aLen = countListNode(a);
        int bLen = countListNode(b);
        int k = Math.abs(aLen - bLen);
        ListNode tmpLongNode = b;
        ListNode tmpShorterNode = a;
        if(aLen>bLen){
            tmpLongNode = a ;
            tmpShorterNode = b ;
        }
        for (int i = 1; i <= k; i++) {
            tmpLongNode = tmpLongNode.next;
        }
        while(tmpLongNode.val != tmpShorterNode.val){
            tmpLongNode = tmpLongNode.next ;
            tmpShorterNode = tmpShorterNode.next;
        }
        return tmpLongNode;
    }

    private static int countListNode(ListNode head) {
        int count = 0 ;
        while (head != null) {
            head = head.next;
            count++;
        }
        return count ;
    }



    public static void main(String[] args) {
         ListNode a = new ListNode(1)
                 .setNext(new ListNode(2)
                .setNext(new ListNode(3)
                .setNext(new ListNode(2)
                .setNext(new ListNode(4)
                .setNext(new ListNode(5)
                )))));
         ListNode b = new ListNode(7)
                 .setNext(new ListNode(8)
                .setNext(new ListNode(9)
                .setNext(new ListNode(4)
                .setNext(new ListNode(5)
                .setNext(new ListNode(9)
                )))));
        //System.out.println("countListNode(a) = " + countListNode(a));
        ListNode listNode = findRepeatNode(a,b);
        System.out.println("listNode.val = " + listNode.val);
    }
}

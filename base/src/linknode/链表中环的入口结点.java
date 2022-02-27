/**
 * @author ning_mx
 * @date 11:39 2022/2/24
 * @desc
 */
package linknode;

/**
 * @author blissnmx
 * @date 2022/2/24
 *
 * 一个链表中包含环，如何找出环的入口结点？
 * 从链表的头结点开始沿着next指针进入环的第一个结点为环的入口结点。
 */
public class 链表中环的入口结点 {
    /**
     * 快慢指针，找到环中相遇的节点，作为下一步的快的指针
     * 再使用双指针，双指针相遇即为入口
     * 时间复杂度：O(n)
     */
    public static ListNode findCircleInNode(ListNode head ) {
        ListNode slow = head ;
        ListNode fast = checkListNodeCircle(head);
        if(fast == null ){
            return null;
        }
        while(slow != fast){
            slow = slow.next ;
            fast = fast.next ;
        }
        return fast;
    }

    //判断链表是否有环
    private static ListNode checkListNodeCircle(ListNode head){
        ListNode slow = head ,fast = head;
        while(fast != null){
            slow = slow.next ;
            fast = fast.next ;
            if(fast != null ){
                fast = fast.next ;
            }
            if(slow == fast){
                return fast;
            }
        }
        return null ;
    }

    public static void main(String[] args) {
        ListNode inNode = new ListNode(4);
        ListNode head = new ListNode(1).setNext(new ListNode(2)
                .setNext(new ListNode(3)
                .setNext(inNode
                .setNext(new ListNode(5)
                .setNext(new ListNode(6)
                        .setNext(inNode)
                )))));
        ListNode listNode = findCircleInNode(head);
        System.out.println("listNode.val = " + listNode.val);
    }
}

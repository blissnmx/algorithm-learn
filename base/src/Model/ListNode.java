/**
 * @author ning_mx
 * @date 11:36 2022/2/24
 * @desc
 */
package Model;

/**
 * @author blissnmx
 * @date 2022/2/24
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public ListNode setNext(ListNode next) {
        this.next = next;
        return this;
    }
}

/**
 * @author ning_mx
 * @date 15:41 2022/3/8
 * @desc
 */
package queue;

/**
 * @author ning_mx
 * @date 2022/3/8
 * 使用链表实现一个队列的数据结构，要求以下方法
 * poll() 返回队列最前面的元素，并删除元素
 * peek() 返回队列最前面的元素，不删除元素
 * offer() 在队列尾部增加一个元素
 * size()  返回队列大小
 */
public class 链表实现队列 {
    class Node{
        public  int val ;
        public Node next ;

        public Node(int val) {
            this.val = val;
        }
    }

    /**
     * 链表实现队列的“先进先出”,需要成员属性保存头节点和尾节点
     */
    class MyQueue{
        public Node head ;
        public Node tail ;
        private int size ;

        public MyQueue() {
            this.head = new Node(-1);
            tail = head;
        }

        public void offer(int val) {
            if (head == null) {
                head.next = new Node(val);
                tail = head.next;
            }else{
                tail.next = new Node(val);
            }
            size++;
        }

        public int peek() {
            return head.next.val;
        }
        public int poll(){
            head.next = head.next.next ;
            size -- ;
            return head.next.val;
        }
        public int size(){
            return size ;
        }

    }

}

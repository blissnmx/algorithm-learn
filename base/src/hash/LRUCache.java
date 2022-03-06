/**
 * @author ning_mx
 * @date 15:14 2022/2/28
 * @desc
 */
package hash;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ning_mx
 * @date 2022/2/28
 * 请设计实现一个最近最少使用（Least Recently Used，LRU）缓存，要求如下两个操作的时间复杂度都是O(1)：
 * <p>
 * + get(key)：如果缓存中存在键值key，则返回它对应的值；否则返回-1。
 * + put(key, value)：如果缓存中之前包含键值key，将它的值设为value；否则添加键值key及对应的值value。
 * 在添加一个键值时如果缓存容量已经满了，则在添加新键值之前删除最近最少使用的键值（缓存里最长时间没有被使用过的元素）。
 * </p>
 */
public class LRUCache {
    private int capacity;
    private Map<Integer, ListNode> container;
    private ListNode head ;
    private ListNode tail ;
    public LRUCache(int cap) {
        capacity = cap ;
        container = new HashMap<>();
        //哨兵节点，简化插入、删除操作
        head = new ListNode(-1, -1);
        tail = new ListNode(-1, -1);
        head.next = tail ;
        tail.pre = head ;
    }

    /**
     * get操作返回之前，将当前位置的链表移至链表末尾，头结点表示最少使用的节点（淘汰）
     * @param key
     * @return
     */
    public int get(int key) {
        if (!container.containsKey(key)) {
            return -1;
        }
        ListNode listNode = container.get(key);
        //删除原位置
        deleteNode(listNode);
        //移至末尾
        moveToTail(listNode, listNode.val);
        return listNode.val;
    }


    public void put(int key, int val) {
        if (container.containsKey(key)) {
            moveToTail(container.get(key),val);
        }else{
            //判断容量
            if (container.size() == capacity) {
                container.remove(head.next.key);
                deleteNode(head.next);
            }
            ListNode newNode = new ListNode(key, val);
            container.put(key, newNode);
            insertTail(newNode);
        }
    }

    private void insertTail(ListNode newNode) {
        tail.pre.next = newNode ;
        newNode.pre = tail.pre ;
        newNode.next = tail;
        tail.pre = newNode ;
    }

    private void deleteNode(ListNode node) {
        node.pre.next = node.next ;
        node.next.pre = node.pre ;
    }

    private void moveToTail(ListNode listNode, int val) {
        //删除旧节点
        deleteNode(listNode);
        listNode.val = val ;
        //末尾增加新节点
        insertTail(listNode);
    }

    public class ListNode {
        public int key;
        public int val;
        public ListNode next;
        public ListNode pre;

        public ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "key=" + key +
                    ", val=" + val +
                    ", next=" + next +
                    ", pre=" + pre +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "LRUCache{" +
                "capacity=" + capacity +
                ", container=" + container +
                ", head=" + head.next +
                ", tail=" + tail.pre +
                '}';
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1,2);
        cache.put(2,3);
        System.out.println("cache = " + cache);
        cache.put(3,4);
        System.out.println("cache = " + cache);

    }
}

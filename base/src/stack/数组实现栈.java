/**
 * @author ning_mx
 * @date 16:26 2022/3/8
 * @desc
 */
package stack;

import java.util.Arrays;

/**
 * @author ning_mx
 * @date 2022/3/8
 */
public class 数组实现栈 {
    private int[] arr;
    private int top ;
    private int capacity;
    public 数组实现栈() {
        this.capacity = 16;
        this.arr = new int[capacity];
    }

    public void push(int val) {
        top++;
        arr[top] = val;
        if(arr.length == capacity){
            arr = Arrays.copyOf(arr, arr.length*2);
        }
    }
    public int pop() {
        return arr[top--] ;
    }
}

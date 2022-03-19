/**
 * @author ning_mx
 * @date 16:10 2022/3/8
 * @desc
 */
package queue;

import java.util.Stack;

/**
 * @author ning_mx
 * @date 2022/3/8
 */
public class 用栈实现队列 {
    private int size ;
    private Stack<Integer> in;
    private Stack<Integer> out;

    public 用栈实现队列() {
        this.in = new Stack<>();
        this.out = new Stack<>();
    }
    public int pop(){
        if(out.empty()){
            return -1;
        }
        size -- ;
       return out.pop();
    }

    /**
     * 两个栈需要读取其中一个到另一个，时间复杂度为O(n)
     * @param val
     */
    public void push(int val) {
        in.push(val);
        while (!in.empty()){
            out.push(in.pop());
        }
        size++;
    }

}

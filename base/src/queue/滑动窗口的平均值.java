/**
 * @author ning_mx
 * @date 14:32 2022/3/8
 * @desc
 */
package queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ning_mx
 * @date 2022/3/8
 * 请实现如下类型MovingAverage计算滑动窗口里所有数字的平均值，该类型构造函数的参数确定滑动窗口的大小，
 * 成员函数next每次调用的时候都会往滑动窗口添加一个整数，并返回滑动窗口里所有数字的平均值。
 *
 * class MovingAverage {
 *     public MovingAverage(int size);
 *     public double next(int val);
 * }
 */
public class 滑动窗口的平均值 {
    class MovingAverage {
        private Queue<Integer> queue ;
        private int capacity ;
        private int sum ;

        public MovingAverage(int size){
            //双向链表实现的队列结构
            this.queue = new LinkedList<>();
            this.capacity = size ;
        }

        public double next(int val){
            queue.offer(val);
            sum += val ;
            if (queue.size() > capacity) {
                Integer first = queue.poll();
                sum -= first ;
            }
             return (double) sum / queue.size();
        }
    }
}

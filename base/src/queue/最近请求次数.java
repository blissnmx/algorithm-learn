/**
 * @author ning_mx
 * @date 14:47 2022/3/8
 * @desc
 */
package queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ning_mx
 * @date 2022/3/8
 * 请实现如下类型RecentCounter，它是统计过去3000毫秒内的请求次数的计数器。
 * 该类型的构造函数RecentCounter()初始化计数器，请求数为0；
 * 函数ping(int t)在在时间t添加一个新请求（t表示以毫秒为单位的时间），并返回过去3000毫秒内（时间范围为[t-3000, t]）发生的所有请求数。
 * 假设每次调用函数ping时参数t都比之前调用时的参数值大。
 * 例如，在初始化一个RecentCounter计数器之后，ping(1)的返回值是1，因为时间范围[-2999, 1]只有1个请求；
 * ping(10)的返回值是2，因为时间范围[-2990, 10]有2个请求；
 * ping(3001)的返回值是3，因为时间范围[1, 3001]有3个请求；
 * ping(3002)的是3，因为时间范围[ 2, 3002]只有两个请求，发生在时间1的请求已经不在这个时间范围了。
 */
public class 最近请求次数 {
    class RecentCounter {
        private Queue<Integer> times;
        private int catacity;

        public RecentCounter() {
            this.catacity = 3000;
            this.times = new LinkedList<>();
        }

        /**
         * first+3000 < t -->poll
         */
        public int ping(int t) {
            times.offer(t);
            while (times.peek() + catacity < t) {
                times.poll();
            }
            return times.size();
        }
    }
}

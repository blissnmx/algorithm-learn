package medium.backtracking;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class 组合 {

    /**
     * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
     * @param n
     * @param k
     * @return
     */
    public static List<List<Integer>> testCombine1(int n, int k){
        List<List<Integer>> res = new ArrayList<>();
        if(k<=0 || n < k ) return res;
        //List<Integer> path = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        //DFS
        dfsCombine(n,k,1,res,path);

        return res;
    }

    private static void dfsCombine(int n, int k, int begin, List<List<Integer>> res,Deque<Integer> path) {
        //终止条件
        if(path.size() == k ){
            res.add(new ArrayList<>(path));
            return ;
        }
        for (int i = begin ;i <= n - (k-path.size()) + 1 ; i++) {
            path.addLast(i);
            dfsCombine(n,k,i+1,res,path);
            //搜索结束，回溯
            path.removeLast();
        }
    }

    @Test
    public void testCombine(){
        List<List<Integer>> lists = testCombine1(4, 2);
        lists.stream().forEach(d->d.stream().forEach(System.out::println));
    }
}

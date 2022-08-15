package medium.backtracking;

import org.junit.Test;

import java.util.*;

public class 全排列 {

    /**
     * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
     * @return
     */
    public static List<List<Integer>> testAggrangement1(int [] nums){
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length==0) return res;
        //List<Integer> path = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        //DFS
        dfsAggrangement(nums,res,path);

        return res;
    }

    private static void dfsAggrangement(int [] nums, List<List<Integer>> res,Deque<Integer> path) {
        //终止条件
        if(path.size() == nums.length ){
            res.add(new ArrayList<>(path));
            return ;
        }
        for (int i = 0 ;i < nums.length ; i++) {
            int val = nums[i];
            if(path.contains(val)){
                continue;
            }
            path.addLast(val);
            dfsAggrangement(nums,res,path);
            //搜索结束，回溯
            path.removeLast();
        }
    }


    @Test
    public void testCombine(){
        int []  nums = {1,2,3};
        List<List<Integer>> lists = testAggrangement1(nums);
        System.out.println(lists);
    }


    @Test
    public void testCombine2(){
        int []  nums = {1,2,3};
        List<List<Integer>> lists = testAggrangement2(nums);
        System.out.println(lists);
    }

    /**
     * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列
     * @param nums
     * @return
     */
    private List<List<Integer>> testAggrangement2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length==0) return res;
         Deque<Integer> path = new ArrayDeque<>();
        boolean [] used = new boolean[nums.length];
        Arrays.sort(nums);
        //DFS
        dfsAggrangement2(nums,res,path,used);

        return res;
    }
    private static void dfsAggrangement2(int [] nums, List<List<Integer>> res,Deque<Integer> path,boolean [] used) {
        if(path.size() == nums.length){
            res.add(new ArrayList<>(path));
            return ;
        }
        for (int i = 0; i < nums.length; i++) {
            if(used[i]){
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && !used[i-1]) {
                continue;
            }
            path.addLast(nums[i]);
            used[i] = true;
            dfsAggrangement2(nums,res,path,used);
            used[i] = false;
            path.removeLast();
        }
    }

  @Test
    public void testCombine3(){
        int []  nums = {1,2,3};
        List<List<Integer>> lists = combinationSum(nums);
        System.out.println(lists);
    }

    /**
     * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
     *
     * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。 
     *
     * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
     * @param nums
     * @return
     */
    private List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length==0) return res;
         Deque<Integer> path = new ArrayDeque<>();
        Arrays.sort(nums);
        //DFS
        dfscombinationSum(nums,res,path,target);

        return res;
    }
    private static void dfscombinationSum(int [] nums, List<List<Integer>> res,Deque<Integer> path, int target) {
        int sum = path.stream().map(d->d).sum();
        if(sum == target){
            res.add(new ArrayList<>(path));
            return ;
        }
        for (int i = 0; i < nums.length; i++) {
            if(sum + nums[i] > target){
                break;
            }
            path.addLast(nums[i]);
            dfsAggrangement2(nums,res,path,used);
            path.removeLast();
        }
    }



}

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
        List<List<Integer>> lists = combinationSum(nums,3);
        System.out.println(lists);
    }

    /**
     * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
     *
     * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。 
     *
     * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
     * @param candidates
     * @return
     */
    private List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(candidates.length==0) return res;
         Deque<Integer> path = new ArrayDeque<>();
        Arrays.sort(candidates);
        //DFS
        int [] sum = new int[1];
        dfscombinationSum(candidates,0,res,path,target,sum);

        return res;
    }
    private static void dfscombinationSum(int [] nums,int begin, List<List<Integer>> res,Deque<Integer> path, int target,int [] sum) {
        //int sum = path.stream().mapToInt(d->d).sum();
        if(sum[0] == target){
            res.add(new ArrayList<>(path));
            return ;
        }
        if(sum[0] > target) return ;

        for (int i = begin; i < nums.length; i++) {
            if(sum[0] + nums[i] > target){
                break;
            }
            path.addLast(nums[i]);
            sum[0] +=nums[i];
            dfscombinationSum(nums,i,res,path,target,sum);
            path.removeLast();
            sum[0] -=nums[i];
        }
    }

 @Test
    public void testCombine4(){
        int []  nums = {1,2,3};
        List<List<Integer>> lists = combinationSum2(nums,3);
        System.out.println(lists);
    }

    /**
     * 给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
     *
     * candidates 中的每个数字在每个组合中只能使用 一次 。
     * @param candidates
     * @return
     */
    private List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(candidates.length==0) return res;
         Deque<Integer> path = new ArrayDeque<>();
        Arrays.sort(candidates);
        //DFS
        int [] sum = new int[1];
        boolean [] used = new boolean[candidates.length];
        dfscombinationSum2(candidates,0,res,path,target,sum,used);

        return res;
    }
    private static void dfscombinationSum2(int [] nums,int begin, List<List<Integer>> res,Deque<Integer> path, int target,int [] sum,boolean [] used) {
        if(sum[0] > target) return ;
        if(sum[0] == target){
            res.add(new ArrayList<>(path));
            return ;
        }
        for (int i = begin; i < nums.length; i++) {
            if(sum[0] + nums[i] > target){
                break;
            }
            if(i>0 && nums[i] == nums[i-1] && used[i-1]){
                continue;
            }
            path.addLast(nums[i]);
            sum[0] +=nums[i];
            used[i] = true;
            dfscombinationSum2(nums,i+1,res,path,target,sum,used);
            path.removeLast();
            sum[0] -=nums[i];
            used[i] = false;
        }
    }



}

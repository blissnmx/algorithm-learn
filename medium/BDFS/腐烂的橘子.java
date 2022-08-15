/**
 * @author ning_mx
 * @date 9:34 2022/7/7
 * @desc
 */
package medium.BDFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ning_mx
 * @date 2022/7/7
 */
public class 腐烂的橘子 {

     //BFS
    public int test(){
        int[][] grid = new int[][]{};
        if(grid.length==0) return -1;
        //find 2 index and 1 count
        Queue<int[]> que =new LinkedList<>();
        int countOne = 0 ;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int v = grid[i][j];
                if(v == 2){
                    que.offer(new int[]{i,j});
                }
                if(v == 1){
                    countOne++;
                }
            }
        }
        int m = grid.length,n = grid[0].length,result = 0;
        while(countOne>0 && !que.isEmpty()){
            int size = que.size();
            for (int i1 = 0; i1 < size; i1++) {
                int[] tmp = que.poll();
                int i = tmp[0], j = tmp[1];
                //判断上下左右的值
                if(j>0 && grid[i][j-1] == 1){
                    countOne--;
                    grid[i][j-1] = 2;
                    que.offer(new int[]{i, j - 1});
                }
                if(j+1<n && grid[i][j+1] == 1){
                    countOne--;
                    grid[i][j+1] = 2;
                    que.offer(new int[]{i, j + 1});
                }
                if(i>0 && grid[i-1][j] == 1){
                    countOne--;
                    grid[i-1][j] = 2;
                    que.offer(new int[]{i-1, j });
                }
                if(i+1<m && grid[i+1][j] == 1){
                    countOne--;
                    grid[i+1][j] = 2;
                    que.offer(new int[]{i+1, j });
                }
            }
            result++;
        }

        if(countOne == 0){
            return result;
        }else{
            return  -1;
        }
    }
}

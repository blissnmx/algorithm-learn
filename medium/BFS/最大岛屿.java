package medium.BFS;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class 最大岛屿 {

    /**
     * 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在 水平或者竖直的四个方向上 相邻。
     * 你可以假设 grid 的四个边缘都被 0（代表水）包围着。
     *
     * 岛屿的面积是岛上值为 1 的单元格的数目。
     *
     * 计算并返回 grid 中最大的岛屿面积。如果没有岛屿，则返回面积为 0 。
     * 输入：grid =
     * [
     * [0,0,1,0,0,0,0,1,0,0,0,0,0],
     * [0,0,0,0,0,0,0,1,1,1,0,0,0],
     * [0,1,1,0,1,0,0,0,0,0,0,0,0],
     * [0,1,0,0,1,1,0,0,1,0,1,0,0],
     * [0,1,0,0,1,1,0,0,1,1,1,0,0],
     * [0,0,0,0,0,0,0,0,0,0,1,0,0],
     * [0,0,0,0,0,0,0,1,1,1,0,0,0],
     * [0,0,0,0,0,0,0,1,1,0,0,0,0]]
     * 输出：6
     * [
     * [1,1,0,0,0],
     * [1,1,0,0,0],
     * [0,0,0,1,1],
     * [0,0,0,1,1]]
     */
    @Test
    public void largeAreaIsland(){
        int[][] grid = new int[][]{{1,1,0,0,0},{1,1,0,0,0},{0,0,0,1,1},{0,0,0,1,1}};
        int max = 0 ,m = grid.length,n = grid[0].length ;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {

                int v = grid[i][j];
                if(v == 1){
                    int count = 0 ;
                    queue.offer(new int[]{i,j});
                    grid[i][j] = 0 ;
                    while(!queue.isEmpty()){
                        int[] arr = queue.poll();
                        int r = arr[0],c = arr[1];
                        //广度搜索，避免重复，搜索过的置为0
                        if(r+1 < m && grid[r+1][c] == 1){
                            queue.offer(new int[]{r + 1, c});
                            grid[r+1][c] = 0;
                        }
                        if(r-1>=0 && grid[r-1][c] == 1){
                            queue.offer(new int[]{r-1,c}); 
                            grid[r-1][c] = 0;
                        }
                        if(c+1 < n && grid[r][c+1] == 1 ){
                            queue.offer(new int[]{r, c + 1});
                            grid[r][c+1] = 0;
                        }
                        if (c - 1 >= 0 && grid[r][c-1] == 1) {
                            queue.offer(new int[]{r, c - 1});
                            grid[r][c-1] = 0 ;
                        }
                        count++;
                    }
                    max = Math.max(count, max);
                }
            }
        }
        System.out.println("岛屿最大面积为："+max);


    }



}

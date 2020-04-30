package leetcode.offer;

public class question47 {
    /*
    * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。
    * 你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。
    * 给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
示例 1:

输入:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
输出: 12
解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物
 

提示：

0 < grid.length <= 200
0 < grid[0].length <= 200
    *
    * */

    public static void main(String[] args) {
        int[][] grid = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        System.out.println(maxValue(grid));
    }


    /*
     * @Description  ：
     * @author       : zhangMingJie
     * @param        : [grid]
     * @return       : int
     * @date         : 2020/4/30 11:52
     */
    public static int maxValue(int[][] grid) {
//        System.out.println(grid.length + " " + grid[0].length);
        int[][] dp = new int[grid.length + 1][grid[0].length + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = 0;
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                dp[i+1][j+1] = Math.max(dp[i][j + 1] + grid[i][j], dp[i + 1][j] + grid[i][j]);
            }
        }
        return dp[grid.length][grid[0].length];
    }
}

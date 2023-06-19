class Solution {
    int mod = 1_000_000_007;

    public int countPaths(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] visited = new int[m][n];

        // Iterate over all cells grid[i][j] and sum over dfs(i, j).
        int answer = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                answer = (answer + dfs(grid, i, j, visited)) % mod;
            }
        }

        return answer;
    }

    int dfs(int[][] grid, int i, int j, int[][] visited) {
        // If visited[i][j] is non-zero, it means we have got the value of dfs(i, j),
        // so just return visited[i][j].
        if (visited[i][j] != 0) return visited[i][j];

        // Otherwise, set answer = 1, the path made of grid[i][j] itself.
        int answer = 1;

        int[][] directions = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        // Check its four neighbor cells, if a neighbor cell grid[prevI][prevJ] has a
        // smaller value, we move to this cell and solve the subproblem: dfs(prevI, prevJ).
        for (int[] d : directions) {
            int prevI = i + d[0], prevJ = j + d[1];
            if (0 <= prevI && prevI < grid.length && 0 <= prevJ && prevJ < grid[0].length && grid[prevI][prevJ] < grid[i][j]) {
                answer += dfs(grid, prevI, prevJ, visited);
                answer %= mod;
            }
        }

        // Update visited[i][j], so that we don't recalculate its value later.
        visited[i][j] = answer;
        return answer;
    }
}

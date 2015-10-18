/*
Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

For example,
X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X
*/
public class Solution {
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    int[][] color;
    char[][] map;
    int n, m, sum = 1;
    Queue<Integer> q = new LinkedList<>();
    Set<Integer> check = new HashSet<>();
    void search(int x, int y) {
        int tx, ty, k, step = 4;
        boolean flag = false;
        q.add(x*m+y);
        color[x][y] = sum;
        while (!q.isEmpty()) {
            k = q.poll();
            x = k/m;
            y = k%m;
            for (int i = 0; i < step; i++) {
                tx = x+dx[i];
                ty = y+dy[i];
                if (tx<0 || ty<0 || tx>=n || ty>=m) {
                    if (!flag)
                        flag = true;
                    continue;
                }
                if (map[tx][ty] == 'O' && color[tx][ty] == 0) {
                    q.add(tx*m+ty);
                    color[tx][ty] = sum;
                }
            }
        }
        if (flag)
            check.add(sum);
    }
    public void solve(char[][] board) {
        map = board;
        n = map.length;
        if (n == 0)
            return;
        m = map[0].length;
        color = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (map[i][j] == 'O' && color[i][j] == 0) {
                    search(i, j);
                    sum++;
                }
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (color[i][j] != -1 && !check.contains(color[i][j]))
                    map[i][j] = 'X';
    }
}
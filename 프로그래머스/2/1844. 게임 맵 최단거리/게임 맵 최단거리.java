import java.util.*;

class Solution {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int answer = -1;
    static boolean [][] visited;
    
    public int solution(int[][] maps) {
        
        // dfs(maps, 1, 0, 0);
        visited = new boolean[maps.length][maps[0].length];
        bfs(maps, 0, 0);
        
        return answer;
    }
    
    void bfs(int[][] maps, int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        
        queue.add(new int[] {x, y, 1});
        visited[x][y] = true;
        
        while(!queue.isEmpty()){
            int[] poll = queue.poll();
            int poll_x = poll[0];
            int poll_y = poll[1];
            int dist = poll[2];
            
            if (poll_x == maps.length - 1 && poll_y == maps[0].length - 1) {
                answer = dist;
                return;
            }
            
            for(int i=0; i<4; i++){
                int nx = poll_x + dx[i];
                int ny = poll_y + dy[i];
                
                if (nx >= 0 && nx < maps.length && ny >= 0 && ny < maps[0].length){
                    if (maps[nx][ny] != 0 && !visited[nx][ny]){
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx, ny, dist + 1});
                    }
                }
            }
        }
    }
    
    void dfs(int[][] maps, int result, int x, int y){
        if (x == maps.length - 1 && y == maps[0].length - 1){
            answer = Math.min(answer, result);
            return;
        }
        
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if (nx >= 0 && nx < maps.length && ny >= 0 && ny < maps[0].length){
                if (maps[nx][ny] != 0){
                    maps[nx][ny] = 0;
                    dfs(maps, result + 1, nx, ny);
                    maps[nx][ny] = 1;
                }
            }
        }
    }
}
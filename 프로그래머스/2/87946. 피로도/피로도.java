class Solution {
    static int answer;
    static boolean[] visited;
    
    public int solution(int k, int[][] dungeons) {
        answer = 0;
        visited = new boolean[dungeons.length];
        
        recursion(k, dungeons, 0);
        return answer;
    }
    
    void recursion(int tired, int[][] map, int count){
        answer = Math.max(answer, count);
        
        for(int i=0; i<map.length; i++){
            if (!visited[i] && tired >= map[i][0]){
                visited[i] = true;
                recursion(tired - map[i][1], map, count + 1);
                visited[i] = false;
            }
        }
    }
}
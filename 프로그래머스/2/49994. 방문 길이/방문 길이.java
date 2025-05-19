import java.util.*;

class Solution {
    
    public int solution(String dirs) {
        int answer = 0;
        Set<String> set = new HashSet<>();
        int x = 0;
        int y = 0;
        
        for(char chr : dirs.toCharArray()){
            int nx = x;
            int ny = y;
            
            switch(chr){
                case 'U': ny ++; break;
                case 'D': ny --; break;
                case 'R': nx ++; break;
                case 'L': nx --; break;
            }
            
            if (nx < -5 || nx > 5 || ny < -5 || ny > 5) continue;
            
            String move = x + "," + y + "," + nx + "," + ny;
            String reverse = nx + "," + ny + "," + x + "," + y;
            
            if (!set.contains(move) && !set.contains(reverse)){
                set.add(move);
                set.add(reverse);
                answer ++;
            }
            
            x = nx;
            y = ny;
        }
        return answer;
    }
}
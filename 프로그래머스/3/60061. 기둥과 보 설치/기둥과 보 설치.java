import java.util.*;

class Solution {
    
    class Node implements Comparable<Node>{
        int x;
        int y;
        int frame;
        
        public Node(int x, int y, int frame) {
        this.x = x;
        this.y = y;
        this.frame = frame;
    }
        
        @Override
        public int compareTo(Node n){
            if (this.x == n.x && this.y == n.y){
                return Integer.compare(this.frame, n.frame);
            }
            else if (this.x == n.x){
                return Integer.compare(this.y, n.y);
            }
            else return Integer.compare(this.x, n.x);
        }
    }
    
    boolean isPossible(ArrayList<ArrayList<Integer>> answer){
        for(int i=0; i<answer.size(); i++){
            int x = answer.get(i).get(0);
            int y = answer.get(i).get(1);
            int frame = answer.get(i).get(2);
            
            if (frame == 0){
                boolean check = false;
                if (y == 0) check = true;
                for (int j = 0; j < answer.size(); j++) {
                    if (x - 1 == answer.get(j).get(0) && y == answer.get(j).get(1) 
                        && 1 ==  answer.get(j).get(2)) {
                        check = true;
                    }
                    if (x == answer.get(j).get(0) && y == answer.get(j).get(1) 
                        && 1 == answer.get(j).get(2)) {
                        check = true;
                    }
                    if (x == answer.get(j).get(0) && y - 1 == answer.get(j).get(1)
                        && 0 == answer.get(j).get(2)) {
                        check = true;
                    }
                }
                if (!check) return false; 
            }
            else if (frame == 1){
                boolean check = false;
                boolean left = false;
                boolean right = false;
                
                for (int j = 0; j < answer.size(); j++) {
                    if (x == answer.get(j).get(0) && y - 1 == answer.get(j).get(1) 
                        && 0 == answer.get(j).get(2)) {
                        check = true;
                    }
                    if (x + 1 == answer.get(j).get(0) && y - 1 == answer.get(j).get(1) 
                        && 0 == answer.get(j).get(2)) {
                        check = true;
                    }
                    if (x - 1 == answer.get(j).get(0) && y == answer.get(j).get(1) 
                        && 1 == answer.get(j).get(2)) {
                        left = true;
                    }
                    if (x + 1 == answer.get(j).get(0) && y == answer.get(j).get(1) 
                        && 1 == answer.get(j).get(2)) {
                        right = true;
                    }
                }
                if (left && right) check = true;
                if (!check) return false;
            }
        }
        return true;
    }
    
    public int[][] solution(int n, int[][] build_frame) {
        ArrayList<ArrayList<Integer>> answer = new ArrayList<ArrayList<Integer>>();
        
        for(int i=0; i<build_frame.length; i++){
            int x = build_frame[i][0];
            int y = build_frame[i][1];
            int frame = build_frame[i][2];
            int op = build_frame[i][3];
            
            if (op == 0){
                int idx = 0;
                for(int j=0; j<answer.size(); j++){
                    if (x == answer.get(j).get(0) && y == answer.get(j).get(1)
                       && frame == answer.get(j).get(2)){
                        idx = j;
                    }
                }
                
                ArrayList<Integer> remv = answer.get(idx);
                answer.remove(idx);
                if(!isPossible(answer)){
                    answer.add(remv);
                }
            }
            else if (op == 1){
                ArrayList<Integer> insert = new ArrayList<>();
                insert.add(x);
                insert.add(y);
                insert.add(frame);
                
                answer.add(insert);
                if (!isPossible(answer)){
                    answer.remove(answer.size()-1);
                }
            }
        }
        
        ArrayList<Node> ans = new ArrayList<>();
        for(int i=0; i<answer.size(); i++){
            ans.add(new Node(answer.get(i).get(0), 
                             answer.get(i).get(1), 
                             answer.get(i).get(2))
                    );
            }
        Collections.sort(ans);
        
        int[][] res = new int[ans.size()][3];
        for(int i=0; i<ans.size(); i++){
            res[i][0] = ans.get(i).x;
            res[i][1] = ans.get(i).y;
            res[i][2] = ans.get(i).frame;
        }
        
        
        return res;
    }
}
class Solution {
    
    int balance(String p){
        int count = 0;
        
        for(int i=0; i<p.length(); i++){
            if (p.charAt(i) == ')') count --;
            else if (p.charAt(i) == '(') count ++;
            if (count == 0) return i;
        }
        
        return 0;
    }
    
    boolean check(String p){
        int count = 0;
        
        for(int i=0; i<p.length(); i++){
            if (p.charAt(i) == ')') count --;
            else if (p.charAt(i) == '(') count ++;
            if (count < 0) return false;
        }
        
        return count == 0;
    }
    
    public String solution(String p) {
        String answer = "";
        
        if(p.equals("")) return answer;
        
        int idx = balance(p);
        
        String u = p.substring(0, idx+1);
        String v = p.substring(idx+1, p.length());
        
        if (check(u)){
            answer = u + solution(v);
        }
        else{
            answer += "(";
            answer += solution(v);
            answer += ")";
            
            String str = u.substring(1, u.length()-1);
            
            for(int i=0; i<str.length(); i++){
                if (str.charAt(i) == ')') answer += "(";
                else answer += ")";
            }
        }
        return answer;
    }
}
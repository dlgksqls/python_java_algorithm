import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {};
        int[] std1 = {1, 2, 3, 4, 5};
        int[] std2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] std3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int std1_count = 0;
        int std2_count = 0;
        int std3_count = 0;
        
        for(int i = 0; i < answers.length; i++) {
            if (answers[i] == std1[i % std1.length]) std1_count++;
            if (answers[i] == std2[i % std2.length]) std2_count++;
            if (answers[i] == std3[i % std3.length]) std3_count++;
        }
        
        int maxScore = Math.max(std1_count, Math.max(std2_count, std3_count));
        ArrayList<Integer> result = new ArrayList<>();
        if (std1_count == maxScore) result.add(1);
        if (std2_count == maxScore) result.add(2);
        if (std3_count == maxScore) result.add(3);
        
        answer = result.stream().mapToInt(i -> i).toArray();
        
        return answer;
    }
}

class Solution {
    public int solution(String[] babbling) {
        int count = 0;
        String[] patterns = {"aya", "ye", "woo", "ma"};

        for (String word : babbling) {
            String temp = word;

            for (String pattern : patterns) {
                if (temp.contains(pattern + pattern)) {
                    temp = ""; // 연속 중복된 발음이 있으면 무효
                    break;
                }
            }

            if (!temp.isEmpty()) {
                temp = temp.replaceAll("aya|ye|woo|ma", "1");
                if (temp.matches("1+")) {
                    count++;
                }
            }
        }
        return count;
    }
}

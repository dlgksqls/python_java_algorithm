class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        String[] array1 = new String[n];
        String[] array2 = new String[n];
        
        for (int i=0; i<n; i++){
            array1[i] = num_to_bit(arr1[i], n);
            array2[i] = num_to_bit(arr2[i], n);
        }
        
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (array1[i].charAt(j) == '#' || array2[i].charAt(j) == '#') {
                    sb.append("#");
                } else {
                    sb.append(" ");
                }
            }
            answer[i] = sb.toString();
        }
        return answer;
    }
    
    public static String num_to_bit(int number, int range){
        String returnBit = "";
        while(number > 0){
            if (number % 2 == 0){
                returnBit = " " + returnBit;
            }
            else{
                returnBit = "#" + returnBit;
            }
            number /= 2;
        }
        while (returnBit.length() < range){
            returnBit = " " + returnBit;
        }
        return returnBit;
    }
}
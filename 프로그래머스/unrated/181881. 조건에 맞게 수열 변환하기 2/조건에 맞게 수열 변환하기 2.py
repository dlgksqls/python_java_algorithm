def solution(arr):
    answer = 0
    stack = 0
    
    while True:
        for i in range(len(arr)):
            if arr[i] >= 50 and arr[i] % 2 == 0:
                arr[i] /= 2
                stack = 0
            elif arr[i] < 50 and arr[i] % 2 != 0:
                arr[i] = arr[i] * 2 + 1
                stack = 0
            else:
                stack+=1  
                
            if stack == len(arr):
                return answer
            elif i == len(arr)-1:
                answer+=1
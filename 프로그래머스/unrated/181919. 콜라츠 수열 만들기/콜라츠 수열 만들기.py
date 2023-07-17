def solution(n):
    answer = []
    
    answer.append(n)
    while True:
        if n % 2 == 0:
            n = n/2
            answer.append(n)
        elif n % 2 != 0:
            n = 3 * n + 1
            answer.append(n)
        if n == 1:
            break
        
    return answer
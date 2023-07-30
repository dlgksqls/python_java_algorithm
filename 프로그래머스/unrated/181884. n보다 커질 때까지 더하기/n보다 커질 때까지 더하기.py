def solution(numbers, n):
    answer = 0
    for i in numbers:
        if answer + i > n:
            answer += i
            break
        else:
            answer += i
        
    return answer
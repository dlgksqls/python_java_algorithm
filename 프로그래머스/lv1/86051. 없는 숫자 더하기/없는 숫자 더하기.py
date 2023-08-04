def solution(numbers):
    answer = 0
    numbers.sort()
    sum_all_at = 0
    sum_answer = 0
    
    for i in range(10):
        sum_all_at += i
    for j in numbers:
        sum_answer += j
        
    return sum_all_at - sum_answer
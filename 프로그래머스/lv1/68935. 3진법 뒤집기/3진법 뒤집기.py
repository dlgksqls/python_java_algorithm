def solution(n):
    answer = 0
    result = ''
    
    while n:
        
        result += str(n%3)
        n = n//3
    
    return int(result,3)

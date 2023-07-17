def solution(a, b):
    answer = 0
    result_1 = str(a)+str(b)
    result_2 = 2*a*b
    
    if int(result_1) > result_2:
        answer = int(result_1)
    elif int(result_1) < result_2:
        answer = result_2
        
    return answer
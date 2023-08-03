def solution(a, b):
    answer = 0
    if a<b:
        for i in range(a,b+1):
            answer+=i
    elif a>b:
        for j in range(b,a+1):
            answer+=j
    else:
        answer = a    
    return answer